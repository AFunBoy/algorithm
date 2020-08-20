package work;

public class Test {

    @org.junit.Test
    public void test() {
        int length = 71;
        double b = 70;
        Double result = length / b;
        System.out.println(result);
        Double ceil = Math.ceil(result);
        System.out.println(ceil);
        System.out.println(ceil.intValue());
        for (int i = 0; i < result; i++) {
            System.out.println("count");

        }

    }

}
