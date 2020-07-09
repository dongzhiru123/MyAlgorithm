package leetcode.problem530;

/**
 *
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(main.getMinimumDifference(root));
    }
    private TreeNode pre = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }
    private void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null) min = Math.min(min, root.val - pre.val);
        pre = root;
        inOrder(root.right);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}