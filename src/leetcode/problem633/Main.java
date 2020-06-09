package leetcode.problem633;

/**
 *给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 *
 * 示例1:
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *
 * 示例2:
 * 输入: 3
 * 输出: False
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
    }
    public static boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            if (Math.pow(i, 2) + Math.pow(j, 2) > c) j--;
            else if (Math.pow(i, 2) + Math.pow(j, 2) < c) i++;
            else return true;
        }
        return false;
    }
}
