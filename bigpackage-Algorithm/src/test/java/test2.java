import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Supplier;

/**
 * @Author: 王帆
 * @CreateTime: 2019-04-01 18:03
 * @Description:
 */
public class test2 {
    @Test
    public void test() {
        for (int i = 0; i <50; i++) {
            System.out.println("select a.dianboId,a.createTime,b.endTime,b.createTime from live_vod_user_stat_"+i+" a left join live_vod_info b on a.dianboId = b.videoId order by b.endTime desc ;");
            LongAdder adder  = new LongAdder();
            //System.out.println("select * from live_vod_user_stat_"+i+" order by createTime desc;");
            ThreadLocal<SimpleDateFormat> formatThreadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat());
            String format = formatThreadLocal.get().format(new Date());
            System.out.println(format);
            
        }
    }
}
