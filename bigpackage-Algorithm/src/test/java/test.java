import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: 王帆
 * @CreateTime: 2018-12-26 11:32
 * @Description:
 */
public class test {

    @Test
    public void test() {
        HashMap<Object, Object> map = new HashMap<>();
        fullMap(map);
        System.out.println(JSONObject.toJSONString(map));
    }

    private void changeName(Person person) {
        person.setName("abc");
    }


    private void fullMap(Map map) {
        map.put("abc", "abc");
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

        public void setAge(int age) {
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


