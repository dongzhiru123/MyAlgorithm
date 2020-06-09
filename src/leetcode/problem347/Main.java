package leetcode.problem347;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * 提示：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。

 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1};
        List<Integer> list = topKFrequent(nums, 1);

        for (int x : list) System.out.print(x + " ");
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x)) map.put(x, map.get(x) + 1);
            else map.put(x, 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<>();
            }
            list[i].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = list.length - 1; i >= 0 && result.size() < k; i--) {
            if (list[i] == null) continue;
            result.addAll(list[i]);
        }

        return result;
    }
}
