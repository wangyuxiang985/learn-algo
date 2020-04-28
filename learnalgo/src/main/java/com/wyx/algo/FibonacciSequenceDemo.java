package com.wyx.algo;

/**
 * @ClassName FibonacciSequenceDemo
 * @Description 斐波那契数列解法
 * @Author yuxiang
 * @Date 2020/4/28
 * @Version 1.0
 **/
public class FibonacciSequenceDemo {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long i = dpDeiDai(50);
        System.out.println(i);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime-startTime));
    }

    /**
     * 暴力破解 递归
     * 存在 重叠子问题
     * 时间复杂度为 O(2^n) 指数级
     **/
    private static long baoLi(int n) {
        if (n == 1 || n == 2) {
            return 1L;
        }
        return baoLi(n - 1) + baoLi(n - 2);
    }

    /**
     * 带备忘录 自顶向下递归
     * 造一个「备忘录」，每次算出某个子问题的答案后别急着返回，先记到「备忘录」里再返回；
     * 每次遇到一个子问题先去「备忘录」里查一查，如果发现之前已经解决过这个问题了，直接把答案拿出来用，不要再耗时去计算
     * 一般使用一个数组充当这个「备忘录」
     * 解决重复子问题
     * 时间复杂度是 O(n)
     **/
    private static long beiWang(int n) {
        if (n < 1) {
            return 0L;
        }
        long[] memo = new long[n+1];
       return hepler(memo, n);
    }

    private static long hepler(long[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1L;
        }
         if (memo[n] != 0) {
            //已经计算过，存入备忘录
            return memo[n];
        }
        memo[n] = hepler(memo, n - 1) + hepler(memo, n - 2);
        return memo[n];
    }

    /**
     * dp 数组的迭代解法 自底向上
     * 效率跟带备忘录的差不多
     **/
    private static long dpDeiDai(int n) {
//        long[] memo = new long[n + 1];
//        memo[1] = memo[2] = 1L;
//        for (int i = 3; i <= n; i++) {
//            memo[i] = memo[i - 1] + memo[i - 2];
//        }
        if (n == 1 || n == 2) {
            return 1;
        }
        long per = 1L, cur = 1L;
        for (int i = 3; i <= n; i++) {
            long sum = per + cur;
            per = cur;
            cur = sum;
        }
        return cur;
    }
}
