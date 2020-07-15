package leetcode.problem669;

import java.util.LinkedList;

/**
 * 给定一个二叉搜索树，同时给定最小边界L 和最大边界 R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
 *
 * 示例 1:
 * 输入:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * 输出:
 *     1
 *       \
 *        2
 *
 * 示例 2:
 * 输入:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * 输出:
 *       3
 *      /
 *    2
 *   /
 *  1
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        Main main = new Main();
        TreeNode treeNode = main.trimBST(root, 2, 3);
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return root.right;
        if (root.val > R) return root.left;
        TreeNode temp = root;
        temp.left = trimBST(root.left, L, R);
        temp.right = trimBST(root.right, L, R);
        return temp;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}