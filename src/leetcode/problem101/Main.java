package leetcode.problem101;

/**
 *给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 进阶：
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
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