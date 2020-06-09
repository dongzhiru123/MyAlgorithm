package leetcode.problem4;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,4,5,6};
        int[] nums2 = new int[]{7,8,9,10};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int left = (length1 + length2 + 1) / 2;
        int right = (length1 + length2 + 2) / 2;
        return (getKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, left) +
                getKth(nums1, 0, length1 - 1, nums2, 0, length2 - 1, right)) / 2.0;
    }
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        else return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
    }
}
