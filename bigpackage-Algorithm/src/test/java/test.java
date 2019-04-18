import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: 王帆
 * @CreateTime: 2018-12-26 11:32
 * @Description:
 */
public class test {

    @Test
    public void test() {
        System.out.println(14%7);


    }

    class Person {
        Person() {
        }


        Person(int age, String name) {
            this.age = age;
            this.name = name;
        }


        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public  void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}


