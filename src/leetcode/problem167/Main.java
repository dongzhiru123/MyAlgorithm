package leetcode.problem167;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。

 */
public class Main {
    public static void main(String[] args) {
        int[] a = {0,0,0,0,0,
                   0,0,0,0,0,
                   0,0,0,0,0,
                   2,3,9,9,9,
                   9,9,9,9,9,
                   9,9,9,9,9,
                   9,9,9,9,9};
        int[] ints = twoSum(a, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2
                || target > numbers[numbers.length - 1] + numbers[numbers.length - 2]
                || numbers[0] + numbers[1] > target) return null;
        int end = numbers.length - 1;
        if (numbers[numbers.length - 1] + numbers[0] > target) {
            int i = 0, j = numbers.length - 1, temp = target - numbers[0];
            while (i <= j) {
                end = i + (j - i) / 2;
                if (numbers[end] > temp) j = end - 1;
                else if (numbers[end] < target) i = end + 1;
                else break;
            }
        }
        int[] result = new int[2];
        System.out.println("end = " + end);
        for (int i = 0, j = end; i < j; ) {
            if (numbers[i] + numbers[j] < target) i++;
            else if (numbers[i] + numbers[j] > target) j--;
            else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
}
