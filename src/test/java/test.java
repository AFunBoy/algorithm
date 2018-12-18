import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author: 王帆
 * @CreateTime: 2018-12-11 11:15
 * @Description:
 */
public class test {
    @Test
    public void go() {
        Double a = 123.456789;
        System.out.println(new BigDecimal(a).setScale(4,BigDecimal.ROUND_HALF_UP));
        System.getProperties();
    }

}
