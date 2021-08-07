package com.wyx.algo.exampl;

/**
 *@ClassName ReverseString
 *@Description 反转字符串
 *@Author yuxiang
 *@Date 2021/7/27
 *@Version 1.0
 **/
public class ReverseString {
    public static void main(String[] args) {
        String str = "abcde";
        String rever = rever(str);
        System.out.println(rever);

    }

    private static String rever(String str){
        if(str == null || str.length() <= 0){
            return "";
        }
        char[] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;
        char tmp;
        while (j > i){
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            j--;
            i++;
        }
        return new String(chars);
    }
}
