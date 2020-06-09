package leetcode.problem14;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class Main {
    public static void main(String[] args) {
        String[] strings = {};
        System.out.println(longestCommonPrefix(strings));
    }
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (strs == null || length == 0) return "";
        if (length == 1) return strs[0];
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) minLength = Math.min(minLength, s.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            if (isEqual(strs, i)) sb.append(strs[0].charAt(i));
            else break;
        }
        return sb.toString();
    }
    private static boolean isEqual(String[] strings, int index) {
        boolean result = false;
        char temp = strings[0].charAt(index);
        for (int i = 1; i < strings.length; i++) {
            if (strings[i].charAt(index) == temp) result = true;
            else return false;
        }
        return result;
    }
}
