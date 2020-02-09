package work;

import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName OfNullable
 * @Description TODO
 * @Author 王帆
 * @Date 2020/1/19 16:07
 * @Version 1.0
 */
public class OfNullable {
    @Test
    public void test(){
        String a = "asd";
        String b = "is nullable";
        String s = Optional.ofNullable(a).orElse(b);
    }
}
