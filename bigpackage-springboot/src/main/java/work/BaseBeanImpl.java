package work;

import java.time.LocalDate;

/**
 * @ClassName BaseBeanImpl
 * @Description TODO
 * @Author 王帆
 * @Date 2020/1/20 16:05
 * @Version 1.0
 */
public class BaseBeanImpl extends BaseBean {
    @Override
    protected void doSend() {
        System.out.println("doSend run...");
    }

    public static void main(String[] args) {
        String now = LocalDate.now().toString();
        String redisKey = String.format("INTERNATIONAL_SMS_SEND_LIMIT_KEY_%s", now);
        System.out.println(redisKey);
    }
}
