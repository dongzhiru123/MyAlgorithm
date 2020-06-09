package leetcode.problem22;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        generate(0, 0, new char[2 * n], result);
        return result;
    }
    private void generate(int left, int right, char[] track, List<String> result) {
        if (left > track.length / 2) return;
        if (left + right == track.length) {
            if (left == right) {
                result.add(new String(track));
            }
            return;
        }
        if (left < right) return;
        track[left + right] = '(';
        generate(left + 1, right, track, result);
        track[left + right] = ')';
        generate(left, right + 1, track, result);
    }
}
