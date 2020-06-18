package leetcode.problem78;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Main main = new Main();
        List<List<Integer>> subsets = main.subsets(nums);
        for (List<Integer> list : subsets) {
            System.out.println(list);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        for (int size = 0; size <= nums.length; size++) {
            backTracking(0, result, temp, size, nums);
        }
        return result;
    }
    private void backTracking(int start, List<List<Integer>> result, List<Integer> temp, int size, int[] nums) {
        if (temp.size() == size) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backTracking(i + 1, result, temp, size, nums);
            temp.remove(temp.size() - 1);
        }
    }
}
