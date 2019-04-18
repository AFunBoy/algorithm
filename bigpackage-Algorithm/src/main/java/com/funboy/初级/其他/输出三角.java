package com.funboy.初级.其他;

import java.util.ArrayList;

/**
 * @Author: 王帆
 * @CreateTime: 2019-03-13 17:51
 * @Description:
 */
public class 输出三角 {

    public static void main(String[] args) {
        ArrayList<Object> l1 = new ArrayList<>();
        ArrayList<Object> l2 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            l1.add(i);

        }
        l2 = ( ArrayList<Object>)l1.clone();
        l2.clear();
        System.out.println(l1.toString());
        System.out.println(l2.toString());
    }
}
