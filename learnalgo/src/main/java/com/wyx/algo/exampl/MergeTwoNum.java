package com.wyx.algo.exampl;/**
 * MergeTwoNum
 *
 * @author wyx
 * @date 2021/7/27 9:16 下午
 **/

/**
 *@ClassName MergeTwoNum
 *@Description TODO
 *@Author yuxiang
 *@Date 2021/7/27
 *@Version 1.0
 **/
public class MergeTwoNum {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,7,9};
        int[] arr2 = new int[]{0,2,4,6,8,9,10};
        int[] meger = megerOrderArr(arr1, arr2);
        for(int tmp : meger){
            System.out.println(tmp);
        }

    }

    private static int[] megerOrderArr(int[] arr1, int[] arr2) {
        if(arr1 == null){
            return arr2;
        }
        if(arr2 == null){
            return arr1;
        }
        int[] res = new int[arr1.length + arr2.length];

        int len1 = 0, len2 = 0, lenRes = 0;

        while (len1 < arr1.length && len2 < arr2.length) {
            if(arr1[len1] <= arr2[len2]){
                res[lenRes++] = arr1[len1++];
            }else {
                res[lenRes++] = arr2[len2++];
            }
        }
        while (len1 < arr1.length){
            res[lenRes++] = arr1[len1++];
        }
        while (len2 < arr2.length){
            res[lenRes++] = arr2[len2++];
        }
        return res;

    }
}
