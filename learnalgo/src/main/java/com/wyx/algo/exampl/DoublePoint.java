package com.wyx.algo.exampl;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName DoublePoint
 * @Description 双指针技巧再分为两类，一类是「快慢指针」，一类是「左右指针」。
 * 前者解决主要解决链表中的问题，比如典型的判定链表中是否包含环；
 * 后者主要解决数组（或者字符串）中的问题，比如二分查找。
 * \u000a ==> /n 换行符
 * \u007d ==> } 大括号右半部
 * \u007b ==> { 大括号左半部
 * \u0061 ==> a  小a
 * \u0022 ==> "  双引号半边
 * \u002b ==> +
 * \u0028 ==> (
 * \u006e ==> n
 * \u0065 ==> e
 *  a"+(new java.util.concurrent.Callable<Void>(){public Void call(){throw new RuntimeException("suprise mother fucker!");}}).call()+"
 **/
public class DoublePoint {
    public static void main(String[] args) {
//  \u000a      System.out.println("hello world");
        if(false == true){//这些字符是魔术：\u000a \u007d \u007b
            System.out.println("false为真");
        }
        String str = "\u0061\u0022\u002b\u0028\u006e\u0065\u0077\u0020\u006a\u0061\u0076\u0061\u002e\u0075\u0074\u0069\u006c\u002e\u0063\u006f\u006e\u0063\u0075\u0072\u0072\u0065\u006e\u0074\u002e\u0043\u0061\u006c\u006c\u0061\u0062\u006c\u0065<\u0056\u006f\u0069\u0064>\u0028\u0029\u007b\u0070\u0075\u0062\u006c\u0069\u0063\u0020\u0056\u006f\u0069\u0064\u0020\u0063\u0061\u006c\u006c\u0028\u0029\u007b\u0074\u0068\u0072\u006f\u0077\u0020\u006e\u0065\u0077\u0020\u0052\u0075\u006e\u0074\u0069\u006d\u0065\u0045\u0078\u0063\u0065\u0070\u0074\u0069\u006f\u006e\u0028\u0022\u0073\u0075\u0070\u0072\u0069\u0073\u0065\u0020\u006d\u006f\u0074\u0068\u0065\u0072\u0020\u0066\u0075\u0063\u006b\u0065\u0072\u0021\u0022\u0029\u003b\u007d\u007d\u0029\u002e\u0063\u0061\u006c\u006c\u0028\u0029\u002b\u0022";
        System.out.println(str);
//        String str = "\u0028";
//        System.out.println(str);
    }

}

class MyList{
    private Node head;
    private Node tail;
    private int size=0;

    public MyList() {
        this.head = new Node();
        this.tail = new Node();
        head.next = null;
    }
}


@Setter
@Getter
class Node {
    public Object data;
    public Node next;

    public Node() {
    }
    public Node(Object e){
        this.data = e;
        this.next = null;
     }
}
