package leetcode.problem15;

import test.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-4,-1,-1,-1,0,2,3,4});
        for (int i = 0; i < lists.size(); i++) {
            int length = lists.get(i).size();
            for (int j = 0; j < length; j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int begin = i + 1, end = length - 1;
            while (begin < end) {
                int num = nums[i] + nums[begin] + nums[end];
                if (num == 0) {
                    result.add(Arrays.asList(nums[i], nums[begin], nums[end]));
                    while (begin < end && nums[begin] == nums[++begin]);
                    while (begin < end && nums[end] == nums[--end]);
                }
                else if (num > 0) end--;
                else begin++;
            }
        }
        return result;
    }
}
