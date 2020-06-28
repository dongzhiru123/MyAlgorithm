package leetcode.problem209;

/**
 *给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例: 
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 *
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.minSubArrayLen(3, new int[]{1, 1}));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int start = 0, end = 0;
        int minLength = Integer.MAX_VALUE;
        int temp = 0;
        while (end < length) {
            temp += nums[end];
            while (temp >= s) {
                minLength = Math.min(minLength, end - start + 1);
                temp -= nums[start];
                start++;
            }
            end++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
