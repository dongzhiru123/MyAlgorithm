package leetcode.problem687;

/**
 *给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 * 2
 *
 * 示例 2:
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 * 2
 *
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(1);
        System.out.println(main.longestUnivaluePath(root));
    }
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxPath;
    }
    int maxPath = 0;
    private int dfs(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = dfs(treeNode.left);
        int right = dfs(treeNode.right);
        int leftPath = treeNode.left != null && treeNode.left.val == treeNode.val ? left + 1 : 0;
        int rightPath = treeNode.right != null && treeNode.right.val == treeNode.val ? right + 1 : 0;
        maxPath = Math.max(maxPath, leftPath + rightPath);
        return Math.max(leftPath, rightPath);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}