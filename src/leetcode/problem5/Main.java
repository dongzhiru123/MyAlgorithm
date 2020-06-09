package leetcode.problem5;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Main {
    public static void main(String[] args) {
        //System.out.println("abv".substring(0,4));
        System.out.println(longestPalindrome("ababa"));
    }
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        int begin = 0;
        int maxSize = 1;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] != chars[j]) { // s.charAt(i) != s.charAt(j)
                    dp[j][i] = false;
                } else {
                    if (i - j < 3) dp[j][i] = true;
                    else dp[j][i] = dp[j+1][i-1];
                }
                if (dp[j][i] == true && i - j + 1 > maxSize) {
                    maxSize = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxSize);
    }
}
