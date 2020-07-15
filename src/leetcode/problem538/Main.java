package leetcode.problem538;

import tree.TreeTest;

import java.util.LinkedList;

/**
 *给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        Main main = new Main();
        TreeNode treeNode = main.convertBST(root);
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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }
    public void traverse(TreeNode temp) {
        if (temp == null) return;
        convertBST(temp.right);
        sum += temp.val;
        temp.val = sum;
        convertBST(temp.left);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}