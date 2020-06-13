package leetcode.problem241;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * 示例 2:
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = diffWaysToCompute("20-1-1");
        for (int result : list) {
            System.out.print(result + " ");
        }
    }
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int leftNum : left) {
                    for (int rightNum : right) {
                        switch (c) {
                            case '+' :
                                result.add(leftNum + rightNum);
                                break;
                            case '-' :
                                result.add(leftNum - rightNum);
                                break;
                            case '*' :
                                result.add(leftNum * rightNum);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) result.add(Integer.valueOf(input));
        return result;
    }
}
