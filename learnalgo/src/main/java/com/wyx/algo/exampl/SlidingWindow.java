package com.wyx.algo.exampl;

import com.sun.java.swing.plaf.windows.resources.windows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SlidingWindow
 * @Description 滑动窗口解题框架套路
* 滑动窗口算法框架
    void slidingWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for (char c : t) need[c]++;

        int left = 0, right = 0;
        int valid = 0;
        while (right < s.size()) {
        // c 是将移入窗口的字符
        char c = s[right];
        // 右移窗口
        right++;
        // 进行窗口内数据的一系列更新
        ...

        // debug 输出的位置
        printf("window: [%d, %d)\n", left, right);
        // 判断左侧窗口是否要收缩
        while (window needs shrink) {
        // d 是将移出窗口的字符
        char d = s[left];
        // 左移窗口
        left++;
        // 进行窗口内数据的一系列更新
        ...
        }
        }
        }
    ... 表示的更新窗口数据的地方
    unordered_map 就是哈希表（字典），它的一个方法 count(key) 相当于 Java 的 containsKey(key) 可以判断键 key 是否存在。
    使用方括号访问键对应的值 map[key]。需要注意的是，如果该 key 不存在，C++ 会自动创建这个 key，并把 map[key] 赋值为 0。
    map[key]++ 相当于 Java 的 map.put(key, map.getOrDefault(key, 0) + 1)
 **/
public class SlidingWindow {
    public static void main(String[] args) {
//        String s = "ADOBECODEBANC";
//        String t = "ABC";
//        System.out.println(slidingWindow1(s, t));
//        String s1 = "ab";
//        String s2 = "eidbaooo";
//        System.out.println(slidingWindow2(s1, s2));
//        String s = "cbaebabacd";
//        String t = "abc";
//        System.out.println(slidingWindow3(s, t));
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 给一个字符串S，一个字符串T，在字符串S中找出：包含T所有字母的最小字串
     * 示例：S="ADOBECODEBANC" ; T="ABC" 输出：“BANC”
     * 如果S中不存在这样的字串返回空串"",如果存在，确保答案的唯一
     **/
    @SuppressWarnings("all")
    private static String slidingWindow1(String s, String t) {
        //初始化 window 和 need 两个哈希表，记录窗口中的字符和需要凑齐的字符
        //need:需要凑齐的字符
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        char[] chars = t.toCharArray();
        for (char aChar : chars) {
            need.put(aChar, need.getOrDefault(aChar, 0) + 1);
        }
        //使用 left 和 right 变量初始化窗口的两端，不要忘了，区间 [left, right) 是左闭右开的，所以初始情况下窗口没有包含任何元素
        //valid 变量表示窗口中满足 need 条件的字符个数
        //如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T
        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        char[] chars1 = s.toCharArray();
        while (right < s.length()) {
            //c 是将移入窗口的字符
            char c = chars1[right];
            //右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c,0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            //当 valid == need.size() 时，说明 T 中所有字符已经被覆盖，已经得到一个可行的覆盖子串，现在应该开始收缩窗口了，以便得到「最小覆盖子串」
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = chars1[left];
                //左移窗口
                left++;
                //进行窗口内一系列更新
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start + len);
    }

    /**
     * 给定两个字符串s1和s2，写一个函数来判断s2是否包含s1的排列 ，换句话说，第一个字符串的排列之一是第二个字符串的子串
     * 实例： s1="ab", s2="eidbaooo" 输出：true s2包含s1的排列之一（ba）
     * s1="ab", s2="eidboaoo" 输出：false
     * 输入的 s1 是可以包含重复字符的
     **/
    @SuppressWarnings("all")
    private static boolean slidingWindow2(String s1, String s2) {
        //初始化need和windows窗口
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        char[] chars = s1.toCharArray();
        for (char aChar : chars) {
            need.put(aChar, need.getOrDefault(aChar, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] chars1 = s2.toCharArray();
        while (right < s2.length()) {
            //c 是将移入窗口的字符
            char c = chars1[right];
            //右移窗口
            right++;
            //// 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c,0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = chars1[left];
                left++;
                //进行窗口内一系列更新
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;
    }

    /**
     * 找出所有字母异位词
     * 给定一个字符串S和一个非空字符串P，找到S中所有是P的字母异位词的子串，返回这些子串的起始索引，
     * 字符串只包含小写英文字母，并且字符串S和P的长度不超过20100
     * 说明：字母异位词指字母相同，但排列不同的字符串
     *      不考虑答案输出的顺序
     * 例：
     * S="cbaebabacd" ; P="abc"
     * 输出：[0,6]
     * 起始位置为0的字串“cba”，它是字符串“abc”的字母异位词
     * 起始位置为6的子串“bac”，它是字符串“abc”的字母异位词
     * -----
     * 相当于：输入一个串 S，一个串 T，找到 S 中所有 T 的排列，返回它们的起始索引。
     **/
    @SuppressWarnings("all")
    private static List<Integer> slidingWindow3(String s, String t) {
        //初始化need和windows窗口
        Map<Character, Integer> need = new HashMap<Character, Integer>();
        Map<Character, Integer> windows = new HashMap<Character, Integer>();
        List<Integer> res = new ArrayList<Integer>();//记录结果
        char[] chars = t.toCharArray();
        for (char aChar : chars) {
            need.put(aChar, need.getOrDefault(aChar, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        char[] chars1 = s.toCharArray();
        while (right < s.length()) {
            //c 是将移入窗口的字符
            char c = chars1[right];
            //右移窗口
            right++;
            //// 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c,0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                if (valid == need.size()) {
                    // 当窗口符合条件时，把起始索引加入 res
                    res.add(left);
                }
                char d = chars1[left];
                left++;
                //进行窗口内一系列更新
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.get(d) - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return res;
    }

    /**
     * 最长无重复子串
     * 给定一个字符串，请找出其中不含有重复字符的最长子串的长度
     * 示例： s="abcabcbb" 输出3，最长无重复子串abc，长度3
     * s="bbb" ,输出1，最长无重复子串b，长度1
     * 输入的 s1 是可以包含重复字符的
     **/
    @SuppressWarnings("all")
    private static int lengthOfLongestSubstring(String s) {
        //初始化need和windows窗口
        Map<Character, Integer> windows = new HashMap<Character, Integer>();

        int left = 0;
        int right = 0;
        int res = 0;//记录结果
        char[] chars1 = s.toCharArray();
        while (right < s.length()) {
            //c 是将移入窗口的字符
            char c = chars1[right];
            //右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            windows.put(c, windows.getOrDefault(c, 0) + 1);
            // 判断左侧窗口是否要收缩
            while (windows.get(c) > 1) {
                //窗口中存在重复字符
                char d = chars1[left];
                left++;
                //进行窗口内的数据的更新
                windows.put(d, windows.get(d) - 1);
            }
            res = res > right - left ? res : right - left;
        }
        return res;
    }
}
