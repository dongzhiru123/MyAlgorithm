package leetcode.problem169;

/**
 *给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.majorityElement(new int[]{6, 5, 5}));
    }
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        int num = nums[0];
        int numCount = 1;
        for (int i = 1; i < nums.length; i++) {
            num = (numCount == 0) ? nums[i] : num;
            numCount = (num == nums[i]) ? numCount+1 : numCount-1;
        }
        return num;
    }
}
