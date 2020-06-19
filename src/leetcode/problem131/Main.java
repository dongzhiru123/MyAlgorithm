package leetcode.problem131;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<List<String>> lists = main.partition("aab");
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        doPart(s, result, temp);
        return result;
    }
    private void doPart(String s, List<List<String>> result, List<String> temp) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)){
                temp.add(s.substring(0, i + 1));
                doPart(s.substring(i + 1), result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s, int begin, int end) {
        while (begin < end) {
            if (s.charAt(begin) == s.charAt(end)) {
                begin++;
                end--;
            } else return false;
        }
        return true;
    }
}
