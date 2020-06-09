package leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{2, 7, 11, 15};
        int[] a = main.twoSum(nums, 9);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        int[] result = new int[2];
        for (int i = 0; i < length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                result[0] = map.get(temp);
                result[1] = i;
                break;
            } else map.put(nums[i], i);
        }
        return result;
    }
}
