package work;

/**
 * @ClassName BaseBean
 * @Description TODO
 * @Author 王帆
 * @Date 2020/1/5 11:34
 * @Version 1.0
 */
abstract class BaseBean {

    public void send(String string) {
        System.out.println(string);
        doSend();
    }

    abstract protected void doSend();
}
