package leetcode.problem572;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *
 * 给定的树 t：
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 *
 * 给定的树 s：
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 *
 * 给定的树 t：
 *    4
 *   / \
 *  1   2
 * 返回 false。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode t = new TreeNode(2);
        t.left = new TreeNode(1);
        t.right = new TreeNode(3);
        System.out.println(main.isSubtree(root, t));
    }
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return formSameRoot(s, t)
                || isSubtree(s.left, t)
                || isSubtree(s.right, t);
    }
    public boolean formSameRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val == t.val) {
            return formSameRoot(s.left, t.left) && formSameRoot(s.right, t.right);
        } else return false;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}