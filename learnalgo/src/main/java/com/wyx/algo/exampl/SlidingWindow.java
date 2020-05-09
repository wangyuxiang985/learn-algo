package com.wyx.algo.exampl;

import java.util.HashMap;
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
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(slidingWindow1(s, t));
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
}
