package leetcode.problem108;

import java.util.LinkedList;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5

 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode treeNode = main.sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
        LinkedList<TreeNode> list = new LinkedList<>();
        if (treeNode != null) list.addLast(treeNode);
        while (!list.isEmpty()) {
            int n = list.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = list.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) list.add(temp.left);
                if (temp.right != null) list.add(temp.right);
            }
            System.out.println();
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return changeMidToRoot(nums, 0, nums.length - 1);
    }
    public TreeNode changeMidToRoot(int[] nums, int begin, int end) {
        if (begin > end) return null;
        int mid = begin + (end - begin) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = changeMidToRoot(nums, begin, mid - 1);
        root.right = changeMidToRoot(nums, mid + 1, end);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}