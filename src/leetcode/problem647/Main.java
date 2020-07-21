package leetcode.problem647;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 *
 * 示例 2:
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.countSubstrings("abc"));
    }

    private int numSubstring = 0;

    public int countSubstrings(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            countSubstrings(s, i, i);
            countSubstrings(s, i, i + 1);
        }
        return numSubstring;
    }

    private void countSubstrings(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            numSubstring++;
        }
    }
}
