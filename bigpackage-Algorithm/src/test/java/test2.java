import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author: 王帆
 * @CreateTime: 2019-04-01 18:03
 * @Description:
 */
public class test2 {
    @Test
    public void test() {
        for (int i = 0; i < 50; i++) {
            System.out.println("select a.dianboId,a.createTime,b.endTime,b.createTime from live_vod_user_stat_" + i + " a left join live_vod_info b on a.dianboId = b.videoId order by b.endTime desc ;");
            LongAdder adder = new LongAdder();
            //System.out.println("select * from live_vod_user_stat_"+i+" order by createTime desc;");
            ThreadLocal<SimpleDateFormat> formatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat());
            String format = formatThreadLocal.get().format(new Date());
            System.out.println(format);

        }
    }

    @Test
    public void test2() {
        LocalDateTime parse = LocalDateTime.parse("2020-05-06 23:59:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);
    }

    @Test
    public void test3() {
        HashMap<String, Long> map = new HashMap<>();
        map.put(null, 14054L);
        map.put("-1", 14042L);
        map.put("0", 14043L);
        map.put("1", 14044L);
        map.put("2", 14045L);
        map.put("3", 14046L);
        map.put("4", 14047L);
        map.put("5", 14048L);
        map.put("6", 14049L);
        map.put("7", 14050L);
        map.put("8", 14051L);
        map.put("9", 14052L);
        map.put("10", 14053L);
        System.out.println(JSONObject.toJSONString(map));
    }

    @Test
    public void test4() {
        String type = "13";
        System.out.println(tees(type));
    }

    private Long tees(String type) {
        String str = "{null:14054,\"-1\":14042,\"0\":14043,\"1\":14044,\"2\":14045,\"3\":14046,\"4\":14047,\"5\":14048,\"6\":14049,\"7\":14050,\"8\":14051,\"9\":14052,\"10\":14053}";
        Map map = JSON.parseObject(str, Map.class);
        Object o = map.get(type);
        if (o == null) {
            return 14055L;
        } else {
            return ((Integer) o).longValue();
        }
    }
}
