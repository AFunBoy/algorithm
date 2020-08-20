package com.umetrip.statistic.excel;

import com.umetrip.statistic.ExcelUtil;
import com.umetrip.statistic.bean.WendyBean;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @ClassName 李文哲数据统计
 * @Description TODO
 * @Author 王帆
 * @Date 2020/2/9 21:57
 * @Version 1.0
 */
public class 李文哲数据统计 {
    public static void main(String[] args) throws Exception {
        //list的每个元素是一行的数据
        List<List<Object>> lists = ExcelUtil.readExcel(new File("D://统计表.xlsx"));
        //按照第三列排序，放在一个Map里
        List<WendyBean> wendyBeans = transBean(lists);
        Map<String, List<WendyBean>> hashMap = byProvince(wendyBeans);
        //已经是省了，每个省是key，value是所有的市
//        HashMap<String, Map<String, List<WendyBean>>> finalMap = new HashMap<>();
        //开始写
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (String pro : hashMap.keySet()) {
            List<WendyBean> list = hashMap.get(pro);
            //按照城市的map
            Map<String, List<WendyBean>> city = byCity(list);
//            finalMap.put(pro, city);
            //每一个sheel都是一个省
            XSSFSheet sheet = workbook.createSheet(pro);
            //第一行，表头
            XSSFRow row = sheet.createRow(1);
            String[] title = "企业名称,项目名称,项目省份,城市,物业类型,建筑面积,口罩每日消耗量(只）,消毒水每日消耗量（L）".split(",");
            for (int i = 0; i < title.length; i++) {
                XSSFCell cell = row.createCell(i);
                cell.setCellValue(title[i]);
            }
            int rowNum = 2;
            for (String s : city.keySet()) {
                List<WendyBean> cityList = city.get(s);
                for (WendyBean wendyBean : cityList) {
                    row = sheet.createRow(rowNum);
                    row.createCell(0).setCellValue(wendyBean.getBusinessName());
                    row.createCell(1).setCellValue(wendyBean.getProName());
                    row.createCell(2).setCellValue(wendyBean.getProvince());
                    row.createCell(3).setCellValue(wendyBean.getCity());
                    row.createCell(4).setCellValue(wendyBean.getCategory());
                    row.createCell(5).setCellValue(wendyBean.getFloorage());
                    row.createCell(6).setCellValue(wendyBean.getMaskWastage());
                    row.createCell(7).setCellValue(wendyBean.getWaterWastage());
                    rowNum++;
                }
            }


        }
        String path = "D://statistic.xlsx";
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fos.flush();
        fos.close();
        System.out.println("done");
    }

    public static List<WendyBean> transBean(List<List<Object>> object) {
        ArrayList<WendyBean> wendyBeans = new ArrayList<>();
        int i = 0;
        try {
            System.out.println(object.size());
            for (List<Object> bean : object) {
                i++;
                WendyBean wendyBean = new WendyBean();
                wendyBean.setBusinessName(bean.get(0).toString());
                wendyBean.setProName(bean.get(1).toString());
                wendyBean.setProvince(bean.get(2).toString());
                wendyBean.setCity(Optional.ofNullable(bean.get(3)).orElse("unknown").toString());
                wendyBean.setCategory(bean.get(4).toString());
                wendyBean.setFloorage(Double.parseDouble(bean.get(5).toString()));
                wendyBean.setMaskWastage(Double.parseDouble(bean.get(6).toString()));
                wendyBean.setWaterWastage(Double.parseDouble(bean.get(7).toString()));
                wendyBeans.add(wendyBean);
            }
        } catch (Exception e) {
            System.out.println(i);
            e.printStackTrace();
        }

        return wendyBeans;
    }


    public static Map<String, List<WendyBean>> byProvince(List<WendyBean> wendyBeans) {
        HashMap<String, List<WendyBean>> hashMap = new HashMap<>();
        for (WendyBean wendyBean : wendyBeans) {
            String provience = wendyBean.getProvince().replaceAll("市|省|(|)|（|）|直辖", "");
            provience = provience.replaceAll("（", "");
            provience = provience.replaceAll("）", "");
            provience = provience.replaceAll(" ", "");
            provience = provience.replaceAll("省", "");
            provience = provience.replaceAll("市", "");
            provience = provience.replaceAll("地区", "");
            provience = provience.replaceAll("直辖", "");
            if (provience.contains("广西")) {
                provience = "广西壮族自治区";
            }
            if (provience.contains("新疆")) {
                provience = "新疆维吾尔自治区";
            }
            if (provience.contains("澳门")) {
                provience = "澳门特别行政区";
            }
            if (provience.contains("香港")) {
                provience = "香港特别行政区";
            }
            if (provience.contains("西藏")) {
                provience = "西藏自治区";
            }
            if (provience.contains("内蒙")) {
                provience = "内蒙古自治区";
            }
            if (provience.contains("上海")) {
                provience = "上海";
            }
            if (provience.contains("苏州")) {
                provience = "江苏";
            }
            if (provience.contains("苏")) {
                provience = "江苏";
            }
            if (provience.contains("长沙")) {
                provience = "湖南";
            }
            if (provience.contains("西安")) {
                provience = "陕西";
            }
            if (provience.contains("广州")) {
                provience = "广东";
            }
            if (provience.contains("宁夏")) {
                provience = "宁夏回族自治区";
            }
            provience = washProvince(provience);
            List<WendyBean> wendyBeans1 = hashMap.get(provience);
            if (null == wendyBeans1) {
                ArrayList<WendyBean> list = new ArrayList<>();
                list.add(wendyBean);
                hashMap.put(provience, list);
            } else {
                wendyBeans1.add(wendyBean);
            }
        }
        return hashMap;
    }

    public static String washProvince(String province) {
        String str = "北京市，天津市，上海市，重庆市，河北省，山西省，辽宁省，吉林省，黑龙江省，" +
                "江苏省，浙江省，安徽省，福建省，江西省，山东省，河南省，湖北省，湖南省，广东省，" +
                "海南省，四川省，贵州省，云南省，陕西省，甘肃省，青海省，台湾省，内蒙古自治区，" +
                "广西壮族自治区，西藏自治区，江西省，宁夏回族自治区，新疆维吾尔自治区，香港特别行政区，澳门特别行政区";
        str = str.replaceAll("市|省", "");
        String[] provinces = str.split("，");
        List<String> proList = Arrays.asList(provinces);
        if (proList.contains(province)) {
            return province;
        } else {
            return "other";

        }
    }

    public static Map<String, List<WendyBean>> byCity(List<WendyBean> cityList) {
        HashMap<String, List<WendyBean>> cityMap = new HashMap<>();
        for (WendyBean wendyBean : cityList) {
            String city = wendyBean.getCity().replaceAll(" ", "").replaceAll("市", "");
            List<WendyBean> wendyBeans = cityMap.get(city);
            if (wendyBeans == null) {
                ArrayList<WendyBean> list = new ArrayList<>();
                list.add(wendyBean);
                cityMap.put(city,list);
            } else {
                wendyBeans.add(wendyBean);
            }
        }
        return cityMap;
    }

}
