package leetcode.problem260;

/**
 *给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 *
 * 示例 :
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 *
 * 注意：
 * 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
 * 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] ints = main.singleNumber(new int[]{1, 1, 2, 22, 3, 2, 3, 5});
        for (int temp : ints) System.out.println(temp);
    }
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        if (null == nums || nums.length == 0) return result;
        int diff = 0;
        for (int temp : nums) diff ^= temp;
        diff &= -diff;
        for (int tmep : nums) {
            if ((tmep & diff) == 0) result[0] ^= tmep;
            else result[1] ^= tmep;
        }
        return result;
    }
}
