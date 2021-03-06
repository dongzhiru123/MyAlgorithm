package leetcode.problem494;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例：
 * 输入：nums: [1, 1, 1, 1, 1], S: 3
 * 输出：5
 *
 * 解释：
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *  
 * 提示：
 * 数组非空，且长度不会超过 20 。
 * 初始的数组的和不会超过 1000 。
 * 保证返回的最终结果能被 32 位整数存下。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = sum(nums);
        int target = sum + S;
        if (target % 2 == 1 || sum < S) {
            return 0;
        }
        target = target / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int temp : nums) {
            for (int i = target; i >= temp; i--) {
                dp[i] = dp[i] + dp[i - temp];
            }
        }
        return dp[target];
    }
    private int sum(int[] nums) {
        int num = 0;
        for (int temp : nums) {
            num += temp;
        }
        return num;
    }
}
