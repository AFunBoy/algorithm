package com.funboy.初级.数组;

import org.junit.Test;

import java.util.concurrent.Callable;

/**
 * @Author: 王帆
 * @CreateTime: 2018-12-18 10:19
 * @Description:
 */
public class test {
    @Test
    public void go() throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("sdfsdfsd"));
        thread.start();
        thread.sleep(100l);
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("sdfsdfsd"));
        thread.start();
        thread.yield();
        int normPriority = Thread.NORM_PRIORITY;
    }


}
