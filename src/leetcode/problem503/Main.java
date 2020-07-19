package leetcode.problem503;

import java.util.Arrays;
import java.util.Stack;

/**
 *给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] ints = main.nextGreaterElements(new int[]{1, 2, 3, 2, 5, 4});
        for (int temp : ints) {
            System.out.print(temp + " ");
        }
    }
    public int[] nextGreaterElements(int[] nums) {
        int[] result;
        if (nums == null || nums.length == 0) {
            result = new int[nums.length];
            return result;
        }
        int length = nums.length;
        result = new int[length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length * 2; i++) {
            int subscript = i % length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[subscript]) {
                result[stack.pop()] = nums[subscript];
            }
            if (i < length) {
                stack.push(i);
            }
        }
        return result;
    }
}
