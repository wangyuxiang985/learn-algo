package com.wyx.algo.exampl;

/**
 * @ClassName ZhaoLingQian
 * @Description 凑零钱问题
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
 * // coins 中是可选硬币面值，amount 是目标金额
 * int coinChange(int[] coins, int amount); 函数签名
 * 1.先确定「状态」，也就是原问题和子问题中变化的变量。由于硬币数量无限，所以唯一的状态就是目标金额 amount
 * 2.然后确定 dp 函数的定义：当前的目标金额是 n，至少需要 dp(n) 个硬币凑出该金额。
 * 3.然后确定「选择」并择优，也就是对于每个状态，可以做出什么选择改变当前状态。具体到这个问题，无论当的目标金额是多少，
 *   选择就是从面额列表 coins 中选择一个硬币，然后目标金额就会减少：
 * 4.最后明确 base case，显然目标金额为 0 时，所需硬币数量为 0；当目标金额小于 0 时，无解，返回 -1：
 **/
public class ZhaoLingQian {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(coinChange1(new int[]{1,2,3,4,5,6,7}, 23));
        System.out.println("耗时：" + (System.currentTimeMillis()-startTime));
    }

    /**
     * 1.暴力递归
     * 把所有肯能的凑硬币方法都穷举出来，然后找找看最少需要多少枚硬币。
     * 时间复杂度为 O(k * n^k)
    **/
    private static int coinChange1(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = coinChange1(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = subProblem < res ? subProblem + 1 : res;
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
}
