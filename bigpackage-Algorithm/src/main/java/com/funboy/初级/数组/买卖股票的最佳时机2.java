package com.funboy.初级.数组;

import org.junit.Test;

/**
 * @Author: 王帆
 * @CreateTime: 2018-11-19 16:00
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。  设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 */
public class 买卖股票的最佳时机2 {
    @Test
    public void go() {
        int i = maxProfit(new int[]{2,1,2,0,1});
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int money = 0;
        int buy = 2147483647;

        for (int i = 0; i < prices.length; i++) {
            //先循环确定买的价格是不是最低,最低了再循环卖的价格
        int sale = -1;

            if (prices[i] <= buy) {
                buy = prices[i];
                if (i == (prices.length - 1)) {
                    return money;
                }
            } else {
                for (int j = i; j < prices.length; j++) {
                    if (prices[j] > sale) {
                        sale = prices[j];
                        if (j == prices.length - 1) {
                            money += (sale - buy);
                            return money;
                        }
                    } else {
                        money += (sale - buy);
                        i = j - 1;
                        buy = 2147483647;
                        break;
                    }
                }
            }
        }
        return money;
    }


    @Test
    public void go1() {
        for (int i = 0; i < 10; i++) {
            if (1 == 1) {
                for (int j = 0; j < 5; j++) {
                    System.out.println(j);
                }
            }
        }
    }

}
