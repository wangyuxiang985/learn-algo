package com.wyx.algo.exampl;/**
 * ParenthesesString
 *
 * @author wyx
 * @date 2021/7/27 9:57 下午
 **/

import java.util.Stack;

/**
 *@ClassName ParenthesesString
 *@Description TODO
 *@Author yuxiang
 *@Date 2021/7/27
 *@Version 1.0
 **/
public class ParenthesesString {
    public static void main(String[] args) {
        String str = "(())(){[(])}";
//        System.out.println(whetherLicit(str));
        System.out.println(whetherLicitMuch(str));
    }

    private static boolean whetherLicitMuch(String str){
        Stack<Character> stack = new Stack<>();
        for(char ch : str.toCharArray()){
            if('(' == ch || '{' == ch || '[' == ch){
                //左括号直接加入
                stack.push(ch);
            }else {
                //字符是又括号
                //卡看栈顶元素是不是对应的左括号
                if(!stack.empty() && stack.peek() == getTrueChar(ch)){
                    //符合则剔除
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private static Character getTrueChar(char ch) {

        if (')' == ch) {
            return '(';
        }
        if(']' == ch){
            return '[';
        }
        return '{';

    }

    private static boolean whetherLicit(String str){
        if(str == null || str.length() < 2){
            return false;
        }
        //记录左括号个数
        int left = 0;
        for(int i = 0; i < str.length(); i++){
            if('(' == str.charAt(i)){
                left++;
            }else {
                left--;
            }
            if(left == -1){
                return false;
            }
        }
        return left == 0;
    }

}
