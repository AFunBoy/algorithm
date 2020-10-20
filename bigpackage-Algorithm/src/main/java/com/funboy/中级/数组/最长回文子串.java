package com.funboy.中级.数组;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设  s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-medium/xvn3ke/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


public class 最长回文子串 {

    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        String newStr = addBoundaries(s, "#");
        int newLen = newStr.length();
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < newLen; i++) {
            int curLen = centerSpread(newStr, i);
            if (curLen > maxLen) {
                maxLen = curLen;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int centerSpread(String s, int center) {
        int len = s.length();
        int left = center - 1;
        int right = center + 1;
        int step = 0;
        while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            step++;
        }
        return step;
    }

    private static String addBoundaries(String s, String divide) {
        //构造辅助串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("#").append(s.charAt(i));
        }
        sb.append("#");
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("sfdseesdfsfese"));
    }
}


