package com.wyx.algo.exampl;

/**
 * @ClassName BinarySearch
 * @Description 二分查找解题套路框架
 * 分析二分查找的一个技巧是：不要出现 else，而是把所有情况用 else if 写清楚，这样可以清楚地展现所有细节
 * 计算 mid 时需要防止溢出，代码中 left + (right - left) / 2 就和 (left + right) / 2 的结果相同，
 * 但是有效防止了 left 和 right 太大直接相加导致溢出
 **/
public class BinarySearch {

    /**
     * 三种二分查找区别细节点
     * 一：最基本的二分查找算法：
     *      因为我们初始化 right = nums.length - 1
     *      所以决定了我们的「搜索区间」是 [left, right]
     *      所以决定了 while (left <= right)
     *      同时也决定了 left = mid+1 和 right = mid-1
     *      因为我们只需找到一个 target 的索引即可
     *      所以当 nums[mid] == target 时可以立即返回
     * 二：寻找左侧边界的二分查找
     *      因为我们初始化 right = nums.length
     *      所以决定了我们的「搜索区间」是 [left, right)
     *      所以决定了 while (left < right)
     *      同时也决定了 left = mid + 1 和 right = mid
     *      因为我们需找到 target 的最左侧索引
     *      所以当 nums[mid] == target 时不要立即返回
     *      而要收紧右侧边界以锁定左侧边界
     * 三：寻找右侧边界的二分查找
     *      因为我们初始化 right = nums.length
     *      所以决定了我们的「搜索区间」是 [left, right)
     *      所以决定了 while (left < right)
     *      同时也决定了 left = mid + 1 和 right = mid
     *      因为我们需找到 target 的最右侧索引
     *      所以当 nums[mid] == target 时不要立即返回
     *      而要收紧左侧边界以锁定右侧边界
     *      又因为收紧左侧边界时必须 left = mid + 1
     *      所以最后无论返回 left 还是 right，必须减一
    **/

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 5};
        System.out.println(right_bound(nums, 2));
    }

    /**
     * 普通二分查找
     * 根据逻辑将「搜索区间」全都统一成了两端都闭，便于记忆，只要修改两处即可变化出三种写法
    **/
    private static int binary_search(int[] nums, int target) {
        int left = 0 ;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;//直接返回命中索引
            }
        }
        return -1;
    }

    /**
     * 寻找一个数（寻找左侧边界）
     * 搜索一个数，如果存在，返回其索引，否则返回 -1
     * 采用[left, right] 这个区间其实就是每次进行搜索的区间。
     * 有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 1；
     */
    private static int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;//不要直接返回，缩小右边界，继续锁定最左侧边界
            }
        }
        //检擦left是否越界
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /**
     * 寻找一个数（寻找右侧边界）
     * 搜索一个数，如果存在，返回其索引，否则返回 -1
     * 采用[left, right] 这个区间其实就是每次进行搜索的区间。
     * 有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 3；
     */
    private static int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                //不要直接返回，锁定右侧边界
                left = mid + 1;
            }
        }
        //检擦right是否越界
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
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

    /**
     * 寻找一个数（寻找左侧边界）
     * 搜索一个数，如果存在，返回其索引，否则返回 -1
     * 采用[left, right) 这个区间其实就是每次进行搜索的区间。
     * 有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 1；
     */
    private static int binarySearch2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                //右边
                left = mid + 1;
            } else if (target < nums[mid]) {
                //左边
                right = mid;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 寻找一个数（寻找右侧边界）
     * 搜索一个数，如果存在，返回其索引，否则返回 -1
     * 采用（left, right] 这个区间其实就是每次进行搜索的区间。
     * 有序数组 nums = [1,2,2,2,3]，target 为 2，此算法返回的索引是 3；
     */
    private static int binarySearch3(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                left = mid +1;
            } else if (target > nums[mid]) {
                //右边
                left = mid + 1;
            } else if (target < nums[mid]) {
                //左边
                right = mid;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
