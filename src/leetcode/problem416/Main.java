package leetcode.problem416;

/**
 *给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 *
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 *
 * 解释: 数组不能分割成两个元素和相等的子集.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.canPartition(new int[]{1, 5, 11, 17}));
    }
    public boolean canPartition(int[] nums) {
        int sum = sum(nums);
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[] canLoad = new boolean[sum + 1];
        canLoad[0] = true;
        for (int temp : nums) {
            for (int i = sum; i >= temp; i--) {
                canLoad[i] = canLoad[i] || canLoad[i - temp];
            }
        }
        return canLoad[sum];
    }
    private int sum(int[] nums) {
        int sum = 0;
        for (int temp : nums) {
            sum += temp;
        }
        return sum;
    }
}
