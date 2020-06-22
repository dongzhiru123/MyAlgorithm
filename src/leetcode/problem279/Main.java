package leetcode.problem279;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numSquares(12));
    }
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> listForN = getListForN(n);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int temp : listForN) {
                if (temp > i) {
                    break;
                }
                min = Math.min(min, dp[i - temp] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }
    private List<Integer> getListForN(int n) {
        List<Integer> result = new ArrayList<>();
        int temp = 1, flag = 3;
        while (temp <= n) {
            result.add(temp);
            temp += flag;
            flag += 2;
        }
        return result;
    }
}
