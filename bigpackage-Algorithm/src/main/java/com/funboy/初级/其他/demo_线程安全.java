package com.funboy.初级.其他;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 王帆
 * @CreateTime: 2019-03-20 09:50
 * @Description:
 */
public class demo_线程安全 {
    public static final int ACCOUNTSNUMS = 10;
    public static final int DELAY = 10;
    public static final int INITIALBANLANCE = 1000;

    public static void main(String[] args) {
        Bank1 bank = new Bank1(ACCOUNTSNUMS, INITIALBANLANCE);
        for (int i = 0; i < ACCOUNTSNUMS; i++) {
            int from = i;
            Runnable r = () -> {
                while (true) {
                    double amount = INITIALBANLANCE * Math.random();
                    int to = (int) (ACCOUNTSNUMS * Math.random());
                    bank.transfer(from, to, amount);
                    try {
                        Thread.sleep((int) (DELAY * Math.random()));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}


class Bank1 {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    Bank1(int n, double initialBalance) {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }

    public void transfer(int from, int to, double amount) {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                sufficientFunds.await();
            }
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f account[%d] to account[%d] ", amount, from, to);
            accounts[to] += amount;
            System.out.printf("Total balance : %10.2f %n ", getSum());
            sufficientFunds.signalAll();
        } catch (InterruptedException e) {

        } finally {
            bankLock.unlock();
        }
    }

    public int size() {
        return accounts.length;
    }

    public double getSum() {
        bankLock.lock();
        try {
            double sum = 0;
            for (double account : accounts) {
                sum += account;
            }
            return sum;
        } finally {
            bankLock.unlock();
        }
    }
}