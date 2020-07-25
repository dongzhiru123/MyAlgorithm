package leetcode.problem268;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *  
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.missingNumber(new int[]{1, 2, 3, 5, 0}));
    }
    public int missingNumber(int[] nums) {
        if (null == nums || nums.length == 0) return -1;
        int result = 0, i = 0;
        for (int temp : nums) result ^= (i++) ^ temp;
        return result ^ nums.length;
    }
}
