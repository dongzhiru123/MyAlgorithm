package leetcode.problem404;

/**
 *计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(main.sumOfLeftLeaves(root));
    }
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
    private boolean isLeaf(TreeNode treeNode) {
        if (treeNode == null) return false;
        if (treeNode.left == null && treeNode.right == null) return true;
        return false;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}