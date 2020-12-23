package com.wyx.algo.exampl;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @ClassName NSumDemo
 * @Description 解决TwoSum等NSum问题
 * @Author yuxiang
 * @Date 2020/12/18
 * @Version 1.0
 **/
public class NSumDemo {

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 6};
//        int target = 9;
//        int[] ints = twoSum(nums, target);
//        System.out.println(Arrays.toString(ints));
//        int[] nums = {1, 3, 1, 2, 2, 3};
//        int target = 4;
//        List<int[]> list = twoSumPlus(nums, target);
//        list.forEach(ints -> System.out.println(Arrays.toString(ints)));
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;
        List<List<Integer>> list = threeSumPlus(nums, target);
        System.out.println(list);

    }

    /*
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = target ？找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * target=0
     * nums = [-1, 0, 1, 2, -1, -4]
     * [[-1, 0, 1],[-1, -1, 2]]
     *
    **/
    private static List<List<Integer>> threeSumPlus(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return new ArrayList<>();
        }
        //数组排序
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>(10);
        // 穷举第一个数，后两个求和
        for (int i = 0; i < length; i++) {

            List<List<Integer>> twoSumList = twoSum(nums, i + 1, target - nums[i]);
            //如果存在满足条件的二元数组，再加上nums[i]就是结果
            for (List<Integer> list : twoSumList) {
                list.add(nums[i]);
                res.add(list);
            }
            //跳过第一个数字重复的情况，否则有重复结果
            while (i < length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        if (Objects.isNull(nums)) {
            return new ArrayList<>();
        }
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>(10);
        //左右指针
        int left = start, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            //记录左右指针对应的值
            int leftValue = nums[left], rightValue = nums[right];
            if (sum < target) {
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            } else {
                List<Integer> tmpList = new ArrayList<>(10);
                tmpList.add(leftValue);
                tmpList.add(rightValue);
                res.add(tmpList);
                //需要跳过所有重复的元素
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            }
        }
        return res;
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

    /*
     * nums 中可能有多对儿元素之和都等于 target，请你的算法返回所有和为 target 的元素对儿，其中不能出现重复
     * 比如说输入为 nums = [1,3,1,2,2,3], target = 4，那么算法返回的结果就是：[[1,3],[2,2]]
     **/
    private static List<int[]> twoSumPlus(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return new ArrayList<>();
        }
        //先排序
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>(10);
        //左右指针
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            //记录左右指针对应的值
            int leftValue = nums[left], rightValue = nums[right];
            if (sum < target) {
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            } else {
                res.add(new int[]{leftValue, rightValue});
                //需要跳过所有重复的元素
                while (left < right && nums[left] == leftValue) {
                    left++;
                }
                while (left < right && nums[right] == rightValue) {
                    right--;
                }
            }
        }
        return res;
    }

    /*
     * 高效的运行效率
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    **/
    public static int[] twoSumHashMap(int[] nums, int target) {
        if(Objects.isNull(nums)){
            return new int[]{};
        }
        int[] index = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>(16);
        for(int i = 0; i < nums.length; i++){
            if(hashMap.containsKey(nums[i])){
                //找到啦
                index[0] = hashMap.get(nums[i]);
                index[1] = i;
                break;
            }else{
                hashMap.put(target - nums[i], i);
            }
        }
        return index;

    }
}
