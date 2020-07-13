package leetcode.problem513;

import java.util.LinkedList;
import java.util.Queue;

/**
 *给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 * 示例 2:
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        System.out.println(main.findBottomLeftValue(root));
    }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.right != null) queue.add(temp.right);
            if (temp.left != null) queue.add(temp.left);
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