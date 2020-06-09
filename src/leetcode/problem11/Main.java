package leetcode.problem11;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,5,25,24,5};
        System.out.println(maxArea(nums));
    }
    public static int maxArea(int[] height) {
        int nums = height.length;
        int i = 0, j = nums - 1, maxHave = (j - i) * Math.min(height[i], height[j]);
        if (nums == 2) return maxHave;
        while (i < j) {
            if (height[i] < height[j]){
                while (i + 1 < j && !(height[i + 1] > height[i++]));
            } else while (i < j - 1 && !(height[j - 1] > height[j--]));
            maxHave = Math.max(maxHave, (j - i) * Math.min(height[i], height[j]));
            if (i == j - 1) break;
        }
        return maxHave;
    }
}
