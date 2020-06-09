package leetcode.problem17;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<String> list = main.letterCombinations("23");
        for(String s : list) {
            System.out.println(s);
        }
    }
    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        iterStr(digits, "", 0);
        return list;
    }
    void iterStr(String str, String letter, int index) {
        if (index == str.length()) {
            list.add(letter);
            return;
        }
        String temp = letter_map[str.charAt(index) - '0'];
        for (int i = 0; i < temp.length(); i++) {
            iterStr(str, letter+temp.charAt(i), index+1);
        }
    }
}
