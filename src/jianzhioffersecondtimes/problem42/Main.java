package jianzhioffersecondtimes.problem42;

/**
 *输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *  
 * 提示：
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 */
public class Main {
    public static void main(String[] args) {

    }
    public static int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(nums[i], res);
        }
        return res;
    }
}
