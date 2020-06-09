package leetcode.problem88;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = {3,3,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int subscript = nums1.length - 1;
        int index1 = m - 1, index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums2[index2] > nums1[index1]) {
                nums1[subscript] = nums2[index2];
                index2--;
            } else {
                nums1[subscript] = nums1[index1];
                index1--;
            }
            subscript--;
        }
        if (index1 < 0) {
            for (int i = index2; i >= 0; i--) {
                nums1[subscript] = nums2[i];
                subscript--;
            }
        }
    }
}
