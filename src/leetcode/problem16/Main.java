package leetcode.problem16;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {2,4,1,6,4,33,7,4,5,8};
        System.out.println(threeSumClosest(a, 12));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                int temp = nums[i] + nums[begin] + nums[end];
                if (Math.abs(temp - target) < Math.abs(result - target)) result = temp;
                if (temp < target) begin++;
                else if (temp > target) end--;
                else return result;
            }
        }
        return result;
    }
}
