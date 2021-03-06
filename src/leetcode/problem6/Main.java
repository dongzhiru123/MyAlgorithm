package leetcode.problem6;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(convert("abcdefghi", 3));
    }
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) list.add(new StringBuilder());
        int temp = 0, direction = -1;
        for (char x : s.toCharArray()) {
            list.get(temp).append(x);
            if (temp == 0 || temp == numRows - 1) direction = -direction;
            temp = temp + direction;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder str : list) {
            result.append(str);
        }
        return result.toString();
    }
}
