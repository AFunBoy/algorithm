package com.umetrip.statistic.excel;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

/**
 * @ClassName XmlReader
 * @Description TODO
 * @Author 王帆
 * @Date 2020/1/22 16:36
 * @Version 1.0
 */
public class XmlReader {
    static String url = "http://10.5.144.42:8080/cat/r/e?op=history&domain=UmeSMSServer&ip=All&date=20190101&reportType=month&step=1&type=UmeSMSServer.SMSSend.source&ip=All&forceDownload=xml";


    public String httpGet(String url) throws Exception {
        Request.Builder requestBuilder = new Request.Builder();
        Request request = requestBuilder.get().url(url).build();
        OkHttpClient client = new OkHttpClient();

        Response response = client.newBuilder().callTimeout(99999L, TimeUnit.SECONDS).build().newCall(request).execute();

        ResponseBody body = response.body();
        String string = body.string();
        return string;
    }

    @Test
    public void testLocalDate() {
        for (int i = 0; i < 12; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {

        String str1 = "http://10.5.144.42:8080/cat/r/e?op=history&domain=UmeSMSServer&ip=All&date=";
        String str2 = "&reportType=month&step=-1&type=&ip=All&forceDownload=xml";
        List<String> urlList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            urlList.add(str1 + LocalDate.of(2019, 02, 01).plusMonths(i).toString().replace("-", "") + str2);
        }

        HashMap<String, HashMap<String, Object>> data = new HashMap<>();
        HashSet<String> uniqueKey = new HashSet<>();
        XmlReader reader = new XmlReader();
        for (String url : urlList) {
            String s = reader.httpGet(url);
            int i = url.indexOf("&date=");
            String date = url.substring(i + 6, i + 14);
            date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd")).minusMonths(1).toString().replaceAll("-", "");
            HashMap<String, Object> monthData = new HashMap<>();
            data.put(date, monthData);
            Element body = Jsoup.parse(s).body();
            Elements eles = body.getElementsByAttributeValue("ip", "All");
            for (Element ele : eles) {
                Element source = ele.getElementById("UmeSMSServer.SMSSend.source");
                Elements names = source.getElementsByTag("name");
                for (Element element : names) {
                    String id = element.attr("id");
                    monthData.put(id, Long.parseLong(element.attr("totalcount")));
                    uniqueKey.add(id);
                }
            }
        }

        //写excel
        String path = "D://ttest1.xlsx";
//        String[] headList = new String[uniqueKey.size()];
        //行标题
//        headList = uniqueKey.toArray(headList);
        List<String> uniqueKeyList = uniqueKey.stream().sorted().collect(Collectors.toList());
        //列标题
        List<String> dateList = data.keySet().stream().sorted().collect(Collectors.toList());
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < uniqueKey.size(); i++) {
            XSSFCell cell = row.createCell(i + 1);
            cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);
            cell.setCellValue(uniqueKeyList.get(i));
        }
        int rowNum = 1;
        for (String date : dateList) {
            HashMap<String, Object> dateData = data.get(date);
            row = sheet.createRow(rowNum);
            XSSFCell cell = row.createCell(0);
            cell.setCellValue(date);
            for (int i = 0; i < uniqueKey.size(); i++) {
                cell = row.createCell(i + 1);
                cell.setCellType(XSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(Double.parseDouble(Optional.ofNullable(dateData.get(uniqueKeyList.get(i))).orElse("0").toString()));
            }
            rowNum++;
        }

        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.flush();
        fos.close();
        System.out.println("done");
    }

}
