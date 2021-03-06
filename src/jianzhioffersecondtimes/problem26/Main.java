package jianzhioffersecondtimes.problem26;

/**
 *输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 *
 * 示例 2：
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * 限制：
 * 0 <= 节点个数 <= 10000
 */
public class Main {
    public static void main(String[] args) {

    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == B) return false;
        if (null == A) return false;
        return isChildTreeS(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    private boolean isChildTreeS(TreeNode treeNode1, TreeNode treeNode2) {
        if (null == treeNode2) return true;
        if (null == treeNode1) return false;
        return treeNode1.val == treeNode2.val ?
                (isChildTreeS(treeNode1.left, treeNode2.left) && isChildTreeS(treeNode1.right, treeNode2.right))
                : false;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}