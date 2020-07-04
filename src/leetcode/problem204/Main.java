package leetcode.problem204;

/**
 *统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.countPrimes(10));
    }
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        int count = 0;
        boolean[] isPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                continue;
            }
            count++;
            for (long j = (long) (i) * i; j < n; j += i) {
                isPrimes[(int) j] = true;
            }
        }
        return count;
    }
}
