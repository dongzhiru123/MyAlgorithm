package leetcode.problem230;

import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Main main = new Main();
        System.out.println(main.kthSmallest(root, 4));
    }
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                temp = stack.pop();
                if ((--k) == 0) {
                    break;
                }
                root = temp.right;
            }
        }
        return temp.val;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}