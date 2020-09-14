import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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


}
