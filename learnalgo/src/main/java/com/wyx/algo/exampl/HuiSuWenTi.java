package com.wyx.algo.exampl;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName HuiSuWenTi
 *解决一个回溯问题，实际上就是一个决策树的遍历过程
 * 1、路径：也就是已经做出的选择。
 * 2、选择列表：也就是你当前可以做的选择。
 * 3、结束条件：也就是到达决策树底层，无法再做选择的条件。
 *
 * 核心就是 for 循环里面的递归，在递归调用之前「做选择」，在递归调用之后「撤销选择」
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 **/
public class HuiSuWenTi {

    private static List<List<Integer>> res = new LinkedList<List<Integer>>();
    private static List<char[][]> res2 = new LinkedList<char[][]>();

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 2, 3};
//        List<List<Integer>> lists = quanPaiLei(nums);
//        System.out.println(lists);
        List<char[][]> lists = huangHou(8);
        System.out.println(lists.size());
    }

    /**
     * N皇后问题，输入棋盘边长 n，返回所有合法的放置
     * '.' 表示空，'Q' 表示皇后
     */
    private static List<char[][]> huangHou(int n) {
        //初始化棋盘
        char[][] cur = new char[n][n];
        for(int i = 0;i < n;i++) {
            for (int j = 0; j < n; j++){
                cur[i][j] = '.';
             }
        }

        backtrack2(cur, 0);
        return res2;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 cur 的最后一行
    private static void backtrack2(char[][] cur, int row) {
        //触发结束条件
        if (row == cur.length) {
            res2.add(cur);
            return;
        }
        int n = cur[row].length;
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(cur, row, col)) {
                continue;
            }
            // 做选择
            cur[row][col] = 'Q';
            // 进入下一行决策
            backtrack2(cur,row + 1);
            // 撤销选择
            cur[row][col] = '.';
        }
    }

    //是否可以在 cur[row][col] 放置皇后？
    private static boolean isValid(char[][] cur, int row, int col) {
        int n = cur.length;
        //检查列是否有皇后冲突
        for (int i = 0; i < n; i++) {
            if (cur[i][col] == 'Q') {
                return false;
            }
        }
        //检查行是否有皇后冲突
        for (int i = 0; i < cur[row].length; i++) {
            if (cur[row][i] == 'Q') {
                return false;
            }
        }
        //检查右上方是否有皇后冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (cur[i][j] == 'Q') {
                return false;
            }
        }
        //检查左上方是否有皇后冲突
        for (int i = row -1, j = col -1; i>=0 && j >= 0; i--, j--) {
            if (cur[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


    /**
     * 输入一组不重复的数字，返回它们的全排列
    **/
    private static List<List<Integer>> quanPaiLei(int[] nums) {
        //定义一个链表记录路径
        LinkedList<Integer> track = new LinkedList<Integer>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        //触发结束条件
        if (nums.length == track.size()) {
            res.add(new LinkedList<Integer>(track));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            //排除不合法的选择 路径里面包含
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //递归
            backtrack(nums,track);
            //取消选择
            track.removeLast();
        }

    }
}
