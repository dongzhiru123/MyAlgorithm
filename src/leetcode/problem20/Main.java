package leetcode.problem20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 *
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 *
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 *
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isValid("()]"));
    }
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};

    public static boolean isValid(String s) {
        if (s == null) return true;
        //if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        char[] chars = s.toCharArray();
//        Stack<Character> stack = new Stack<Character>(){{
//
//        }};
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                else {
                    if (map.get(stack.pop()) != c) return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
