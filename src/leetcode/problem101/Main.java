package leetcode.problem101;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(2);
        root.left.right = null;
        root.right.left = null;
        Main main = new Main();
        System.out.println(main.isSymmetric(root));
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }
    public boolean check(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        if (leftTree == null || rightTree == null) return false;
        return leftTree.val == rightTree.val && check(leftTree.left, rightTree.right) && check(leftTree.right, rightTree.left);
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}