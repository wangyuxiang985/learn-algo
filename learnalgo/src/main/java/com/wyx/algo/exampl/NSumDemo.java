package com.wyx.algo.exampl;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName NSumDemo
 * @Description 解决TwoSum等NSum问题
 * @Author yuxiang
 * @Date 2020/12/18
 * @Version 1.0
 **/
public class NSumDemo {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 9;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }


    /*
     * 如果假设输入一个数组 nums 和一个目标和 target，请你返回 nums 中能够凑出 target 的两个元素的值，
     * 比如输入 nums = [1,3,5,6], target = 9，那么算法返回两个元素 [3,6]。可以假设只有且仅有一对儿元素可以凑出 target
     **/
    private static int[] twoSum(int[] nums, int target) {
//        先对 nums 排序，然后利用前文 双指针技巧 写过的左右双指针技巧，从两端相向而行就行了：
        if (Objects.isNull(nums)) {
            return null;
        }
        Arrays.sort(nums);
        //定义左右两个指针
        int left = 0, right = nums.length - 1;
        while (left < right) {
            //算出两个指针的和
            int sum = nums[left] + nums[right];
            //比较移动左右指针
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                //符合预期
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }
}
