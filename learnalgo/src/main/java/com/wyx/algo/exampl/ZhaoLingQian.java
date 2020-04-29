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
        System.out.println(coinChange2(new int[]{1,2,5}, 11));
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

    /**
     * 带备忘录的递归
     * 消除了子问题的冗余，所以子问题总数不会超过金额数 n，即子问题数目为 O(n)。
     * 处理一个子问题的时间不变，仍是 O(k)，所以总的时间复杂度是 O(kn)。
     **/
    private static int coinChange2(int[] coins, int amount) {

        if (amount < 0) {
            return -1;
        }
        int[] memo = new int[amount + 1];
        int helper = helper(memo, coins, amount);
        return helper;
    }

    private static int helper(int[] memo, int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        if (0 == amount) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = helper(memo, coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = subProblem < res ? subProblem + 1 : res;
            //记录备忘录
            memo[amount] = res != Integer.MAX_VALUE ? res : -1;
        }
        return memo[amount];
    }
}
