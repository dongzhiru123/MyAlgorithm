package jianzhioffersecondtimes.problem46;

/**
 *给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * 提示：
 * 0 <= num < 231
 */
public class Main {
    public static void main(String[] args) {

    }
    public static int translateNum (int num) {
        // write code here
        String string = String.valueOf(num);
        char[] chars = string.toCharArray();
        int[] ints = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - '0';
        }

        int[] dp = new int[ints.length + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < ints.length; i++) {
            int temp1 = ints[i - 1];
            int temp2 = ints[i];
            int temp = temp1 * 10 + temp2;
            if (temp <= 25 && temp1 != 0) {
                dp[i + 1] = dp[i - 1] + dp[i];
            }
            else dp[i + 1] = dp[i];
        }

        return dp[ints.length];
    }
}
