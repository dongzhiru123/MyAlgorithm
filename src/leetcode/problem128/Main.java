package leetcode.problem128;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : nums) set.add(a);
        int longLength = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {
                int tempLength = 1;
                x++;
                while (set.contains(x)) {
                    tempLength++;
                    x++;
                }
                if (tempLength > longLength) longLength = tempLength;
            }
        }
        return longLength;
    }
}
