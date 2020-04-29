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

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = quanPaiLei(nums);
        System.out.println(lists);
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
