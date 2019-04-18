package com.funboy.初级.其他;

import java.util.Arrays;

/**
 * @Author: 王帆
 * @CreateTime: 2019-03-19 16:39
 * @Description:
 */
public class demo_线程不安全 {
    public static final int ACCOUNTSNUMS = 10;
    public static final int DELAY = 10;

    public static void main(String[] args) {

        Bank bank = new Bank(ACCOUNTSNUMS, 1000d);
        for (int i = 0; i < ACCOUNTSNUMS; i++) {
            int fromAccount = i;
            Runnable runnable = () -> {
                try {
                    while (true) {
                        int toAccount = (int) (bank.getSize() * Math.random());
                        double amount = 1000 * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int) (DELAY * Math.random()));
                    }
                } catch (InterruptedException e) {

                }
            };

            Thread t = new Thread(runnable);
            t.start();
        }
    }
}


class Bank {
    private final double[] accounts;

    public Bank(int size, Double amount) {
        accounts = new double[size];
        Arrays.fill(accounts, amount);
    }

    public double getSum() {
        double sum = 0d;
        for (double account : accounts) {
            sum += account;
        }
        return sum;
    }

    public void transfer(int from, int to, double amount) {
        if (accounts[from] < amount) {
            return;
        }
        System.out.print(Thread.currentThread());
        accounts[from] -= amount;
        System.out.printf(" %10.2f from %d to %d ", amount, from, to);
        accounts[to] += amount;
        System.out.printf(" total amount : %10.2f%n", getSum());
    }

    public int getSize() {
        return accounts.length;
    }
}
