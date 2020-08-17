package jianzhioffersecondtimes.problem39;

/**
 *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *  
 * 限制：
 * 1 <= 数组长度 <= 50000
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 1, 1, 1, 1, 2, 3, 4, 5}));
    }
    public static int majorityElement(int[] nums) {
        int num = 0, count = 0;
        for (int temp : nums) {
            if (count == 0) num = temp;
            count = (num == temp) ? count+1 : count-1;
        }
        return num;
    }
}
