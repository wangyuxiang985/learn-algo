package com.wyx.algo.exampl;

import java.util.Arrays;

/**
 * @ClassName MergeSortDemo
 * @Description 归并排序 参考链接：https://mp.weixin.qq.com/s/xAXVAdzEsTSAkxx46mAhCg
 * @Author yuxiang
 * @Date 2020/7/23
 * @Version 1.0
 **/
public class MergeSortDemo {
    public static void main(String[] args) {
        MergeSortDemo mergeSortDemo = new MergeSortDemo();
        int[] arr = {5,1,4,2,8,4};
        mergeSortDemo.mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    //归并排序包含两个过程，分和治
    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            //求数组的中点
            int mid = (left + right) / 2;
            //对中点左右递归[left,mid],[mid+1,right]
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            //对拆分完的两部分进行合并
            merge(arr, left, mid, right);
        }
    }

    //合并
    private void merge(int[] arr, int left, int mid, int right) {
//        System.out.println(Arrays.toString(arr));
//        System.out.println(left);
//        System.out.println(mid);
//        System.out.println(right);
        //计算合并的两个子数组的大小
        int m = mid - left + 1;
        int n = right - mid;
        //依据长度创建两个子数组并拷贝数据
        int[] mLeft = new int[m];
        int[] nRight = new int[n];
        for (int i = 0; i < m; i++) {
            mLeft[i] = arr[left + i];
        }
        for (int i = 0; i < n; i++) {
            nRight[i] = arr[mid + 1 + i];
        }
//        System.out.println(Arrays.toString(mLeft));
//        System.out.println(Arrays.toString(nRight));

        // 合并临时数组
        // 初始化两个临时子数组的下标
        int i = 0, j = 0;
        // 初始化合并后数组的下标k为 left
        int k = left;
        while (i < m && j < n) {
            if (mLeft[i] <= nRight[j]) {
                arr[k] = mLeft[i];
                i++;
            } else {
                arr[k] = nRight[j];
                j++;
            }
            k++;
        }
        //处理数组剩余
        while (i < m) {
            arr[k] = mLeft[i];
            i++;
            k++;
        }
        while (j < n) {
            arr[k] = nRight[j];
            j++;
            k++;
        }
    }
}
