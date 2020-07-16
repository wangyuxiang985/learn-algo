package com.wyx.algo.exampl;

import java.util.Arrays;

/**
 * 堆的定义：
 * 1. 堆是一颗完全二叉树，这样实现的堆也被称为二叉堆
 * 2. 堆中节点的值都大于等于（或小于等于）其子节点的值，
 * 堆中如果节点的值都大于等于其子节点的值，我们把它称为大顶堆，如果都小于等于其子节点的值，我们将其称为小顶堆。
 *
 * 完全二叉树: 它的叶子节点都在最后一层，并且这些叶子节点都是靠左排序的。
 */
public class HeapDemo {

    public static void main(String[] args) {
        Heap heap = new Heap(8);
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        System.out.println(Arrays.toString(heap.getArr()));
        heap.removeTopElement();
        System.out.println(Arrays.toString(heap.getArr()));

    }

}

/**
 * 构建一个堆，堆的底层采用数组存储 我们构建的是一个大顶堆
 * 一个元素如果它在数组中的位置为 i，则它的左右子节点在数组中的位置为 2i，2i + 1，通过这种方式可以定位到树中的每一个节点，从而串起整颗树。
 */
class Heap{
    private int[] arr;       // 堆是完全二叉树，底层用数组存储
    private int capacity;    // 堆中能存储的最大元素数量
    private int n;          // 当前堆中元素数量

    public int[] getArr() {
        return arr;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getN() {
        return n;
    }

    public Heap(int count) {
        capacity = count;
        arr = new int[capacity + 1];
        n = 0;
    }

    /**
     * 先把元素插到堆的最后，然后自下而上不断比较子节点与父节点的值，我们称之为由下而上的堆化
     * @param value 待插入元素
     */
    public void insert(int value) {
        if (n >= capacity) {
            //超过堆大小直接结束
            return;
        }
        n++;
        //将元素插到尾部
        arr[n] = value;

        // 由于我们构建的是一个大顶堆，所以需要不断调整以让其满足大顶堆的条件
        int i = n;

        while (i / 2 > 0 && arr[i] >= arr[i / 2]) {
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    /**
     * 移除堆顶元素
     */
    public void removeTopElement() {
        //为避免移除堆顶元素产生数组空洞，需要先将数组末尾元素移至堆顶，然后在重构堆
        if (n <= 0) {
            //空堆直接结束
            return;
        }
        //移动末尾元素至堆顶
        int count = n;

        arr[1] = arr[count];

        --count;
        heapify(1, count);

    }

    /**
     * 自上而下堆化以满足大顶堆的条件
     * @param index
     * @param n
     */
    private void heapify(int index, int n) {
        while (true) {
            int maxValueIndex = index;
            //左节点是否比其父节点大
            if (2 * index <= n && arr[index] < arr[2 * index]) {
                //左节点大于父节点
                maxValueIndex = 2 * index;
            }
            //右节点是否比其父节点大
            if (2 * index + 1 <= n && arr[index] < arr[2 * index + 1]) {
                maxValueIndex = 2 * index + 1;
            }
            //两个节点都比父节点小时，则退出循环
            if (maxValueIndex == index) {
                break;
            }
            //交换两个节点的值
            swap(arr, index, maxValueIndex);
            index = maxValueIndex;
        }
    }

    /**
     * 交换数组中两个下标位置的值
     * @param arr 待交换数组
     * @param i 下标1
     * @param i1 下标2
     */
    private void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
