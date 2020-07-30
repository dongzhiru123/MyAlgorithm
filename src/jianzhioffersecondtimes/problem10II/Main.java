package jianzhioffersecondtimes.problem10II;

/**
 *一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 提示：
 * 0 <= n <= 100
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numWays(5));
    }
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int res = 0, oneStep = 1, twoStep = 2;
        for (int i = 3; i <= n; i++) {
            res = (oneStep + twoStep) % 1000000007;
            oneStep = twoStep;
            twoStep = res;
        }
        return res;
    }
}
