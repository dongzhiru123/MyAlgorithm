package leetcode.problem697;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 *
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 * 注意:
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
    }
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 1) + 1);
            last.put(nums[i], i);
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            maxCount = Math.max(maxCount, count.get(nums[i]));
        }
        int result = Integer.MAX_VALUE;
        for (int key : count.keySet()) {
            if (count.get(key) != maxCount) {
                continue;
            }
            result = Math.min(result, last.get(key) - first.get(key) + 1);
        }
        return result;
    }
}
