package com.wyx.algo.exampl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 解决区间问题常见的排序方法就是按照区间起点排序，或者先按照起点升序排序，若起点相同，则按照终点降序排序
 * 1. 按照区间的起点进行升序排序
 * 2. 排序之后，两个相邻区间可能有如下三种相对位置：覆盖、相交、不相关
 *
 * 起点升序排列，终点降序排列的目的:
 *  对于两个起点相同的区间，需要保证长的那个区间在上面（按照终点降序），这样才会被判定为覆盖，否则会被错误地判定为相交，少算一个覆盖区间。
 **/
public class QuJianDemo {

    public static void main(String[] args) {
        int[][] intvs = {{1, 4}, {3, 6}, {2, 8}};
        int i = removeCoveredIntervals(intvs);
        System.out.println(i);

        int[][] mergeInts = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        List<int[]> merge = merge(mergeInts);
        System.out.println(merge);

        int[][] a = {{0, 2}, {5, 10}, {12, 23}, {24, 25}};
        int[][] b = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        List<int[]> list = intervalIntersection(a, b);
        System.out.println(list);

    }

    //区间交集问题
    private static List<int[]> intervalIntersection(int[][] a, int[][] b) {
        /*
         * 对于两个区间，我们用 [a1,a2] 和 [b1,b2] 表示在 A 和 B 中的两个区间
         * 只有两种情况两个区间没有交集
         * if b2 < a1 or a2 < b1:
         *      [a1,a2] 和 [b1,b2] 无交集
         * 所以上面命题的否命题就是两个集合存在交集
         * if b2 >= a1 and a2 >= b1:
         *      [a1,a2] 和 [b1,b2] 存在交集
         * 如果交集区间是 [c1,c2]，那么 c1=max(a1,b1)，c2=min(a2,b2)
        **/
        //默认两个集合是排好序的
        //用两个索引指针在 a 和 b 中游走，把交集找出来 ,i在a中；j在b中
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>(10);
        while (i < a.length && j < a.length) {
            //如果交集区间是 [c1,c2]，那么 c1=max(a1,b1)，c2=min(a2,b2)
            int a1 = a[i][0], a2 = a[i][1];
            int b1 = b[i][0], b2 = b[i][1];
            if (b2 >= a1 && a2 >= b1) {
                res.add(new int[]{Math.max(a1, b1), Math.min(a2, b2)});
            }
            //启动指针
            //只取决于 a2 和 b2 的大小关系
            if (b2 < a2) {
                j += 1;
            } else {
                i += 1;
            }
        }
        return res;
    }


    //区间合并问题 解决区间问题的一般思路是先排序，然后观察规律
    //对于几个相交区间合并后的结果区间 x，x.start 一定是这些相交区间中 start 最小的，x.end 一定是这些相交区间中 end 最大的
    private static List<int[]> merge(int[][] ints) {
        if (Objects.isNull(ints)) {
            return new ArrayList<>(10);
        }
        //按区间start排序
        Arrays.sort(ints, (x, y) -> x[0] - y[0]);
        List<int[]> intList = new ArrayList<>(10);
        intList.add(ints[0]);

        for (int i = 1; i < ints.length; i++) {
            int[] curr = ints[i];

            //取出res中最后一个元素
            int[] last = intList.get(intList.size() - 1);
            if (curr[0] <= last[1]) {
                //找到最大的end
                last[1] = Math.max(curr[1], last[1]);
            } else {
                //处理下一个待合并区间
                intList.add(curr);
            }
        }
        return intList;


    }


    //区间覆盖问题
    private static int removeCoveredIntervals(int[][] intvs) {
        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(intvs,(x,y)->{
            if (x[0] == y[0]) {
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });
        // 记录合并区间的起点和终点，默认为排完序第一个区间
        int left = intvs[0][0];
        int right = intvs[0][1];

        int res = 0;
        for (int i = 1; i < intvs.length; i++) {
            int[] intv = intvs[i];
            //情况一：找到覆盖区间
            if (intv[0] >= left && right >= intv[1]) {
                res++;
            }
            //情况二：找到相交的区间进行合并
            if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }
            //情况三：完全不相交，更新起点和终点
            if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }
        return intvs.length - res;
    }
}
