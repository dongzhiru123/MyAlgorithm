package leetcode.problem345;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 * 示例 1:
 *
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 *
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class Main {
    private final static HashSet<Character> set = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.reverseVowels("helloei"));
    }
    public String reverseVowels(String s) {
        if (s == null) return null;
        char[] chars = s.toCharArray();
        if (chars.length < 2) return s;
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (!set.contains(chars[i])) {
                if (i >= j) break;
                i++;
            }
            while (!set.contains(chars[j])) {
                if (i >= j) break;
                j--;
            }
            changeTwoNum(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }
    private void changeTwoNum(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
