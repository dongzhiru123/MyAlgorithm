package leetcode.problem524;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1:
 * 输入:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 输出:
 * "apple"
 *
 * 示例 2:
 * 输入:
 * s = "abpcplea", d = ["a","b","c"]
 * 输出:
 * "a"
 *
 * 说明:
 * 所有输入的字符串只包含小写字母。
 * 字典的大小不会超过 1000。
 * 所有输入的字符串长度不会超过 1000。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findLongestWord("wordgoodgoodgoodbestword", Arrays.asList("word","good","best","good")));
    }
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String p : d) {
            if (isHasSubstr(s, p) && ((result.length() < p.length() ||
                    result.length() == p.length() && (p.compareTo(result) < 0)))) {
                result = p;
            }
        }
        return result;
    }
    private boolean isHasSubstr(String s, String p) {
        if (p == null) return false;
        int index1 = 0, index2 = 0;
        while (index1 < s.length() && index2 < p.length()) {
            if (s.charAt(index1) == p.charAt(index2)) index2++;
            index1++;
        }
        return index2 == p.length();
    }
}
