package leetcode.problem90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Main main = new Main();
        List<List<Integer>> subsets = main.subsetsWithDup(nums);
        for (List<Integer> list : subsets) {
            System.out.println(list);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        for (int size = 0; size <= nums.length; size++) {
            backTracking(0, result, temp, size, nums, isVisited);
        }
        return result;
    }
    private void backTracking(int start, List<List<Integer>> result, List<Integer> temp, int size, int[] nums, boolean[] isVisited) {
        if (temp.size() == size) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !isVisited[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            isVisited[i] = true;
            backTracking(i + 1, result, temp, size, nums, isVisited);
            temp.remove(temp.size() - 1);
            isVisited[i] = false;
        }
    }
}
