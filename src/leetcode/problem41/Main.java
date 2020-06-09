package leetcode.problem41;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 *
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 *
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 *  
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] < length && (nums[i] != i + 1) && (nums[nums[i] - 1] != nums[i])) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (i + 1 != nums[i]) return i + 1;
        }
        return length + 1;
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
