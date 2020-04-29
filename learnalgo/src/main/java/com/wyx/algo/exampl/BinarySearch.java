package com.wyx.algo.exampl;

/**
 * @ClassName BinarySearch
 * @Description 二分查找解题套路框架
 * 分析二分查找的一个技巧是：不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节
 * 计算 mid 时需要防止溢出，代码中 left + (right - left) / 2 就和 (left + right) / 2 的结果相同，
 * 但是有效防止了 left 和 right 太大直接相加导致溢出
 **/
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 5};
        System.out.println(binarySearch(nums, 2));
    }

    /**
    * 寻找一个数（基本的二分搜索）
     * 搜索一个数，如果存在，返回其索引，否则返回 -1
     * 采用[left, right] 两端都闭的区间。这个区间其实就是每次进行搜索的区间。
     * --缺点：
     * 有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 2；
     * 想得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3，这样的话此算法是无法处理的。
     */
    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                //右边
                left = mid + 1;
            } else if (target < nums[mid]) {
                //左边
                right = mid - 1;
            }
        }
        return -1;
    }
}
