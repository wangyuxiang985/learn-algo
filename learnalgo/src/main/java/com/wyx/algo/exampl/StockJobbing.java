package com.wyx.algo.exampl;

/**
 * @ClassName StockJobbing
 * @Description 股票买卖问题
 * @Author yuxiang
 * @Date 2020/7/7
 * @Version 1.0
 **/
public class StockJobbing {


    /**
     给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     注意：你不能在买入股票前卖出股票。

     例如：
     输入: [7,1,5,3,6,4]
     输出: 5
     解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

     dp[-1][k][0] = 0
    解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
    dp[-1][k][1] = -infinity
    解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
    dp[i][0][0] = 0
    解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
    dp[i][0][1] = -infinity
    解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。

     只交易一次即k=1
     dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
     dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
     = max(dp[i-1][1][1], -prices[i])
     解释：k = 0 的 base case，所以 dp[i-1][0][0] = 0。

     现在发现 k 都是 1，不会改变，即 k 对状态转移已经没有影响了。
     可以进行进一步化简去掉所有 k：
     dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     dp[i][1] = max(dp[i-1][1], -prices[i])
     */
    private static int maxProfit_k_1(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length][2];
        for (int i = 0; i < length; i++) {
            if (i -1 == -1) {
                dp[i][0]=0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit_k_1(prices);
        System.out.println(i);

    }
}
