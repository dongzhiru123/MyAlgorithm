package jianzhioffersecondtimes.problem34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *  
 * 提示：
 * 节点总数 <= 10000
 */
public class Main {
    public static void main(String[] args) {

    }
    LinkedList<Integer> path = new LinkedList<>();
    LinkedList<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        transTreeFindRes(root, sum);
        return res;
    }
    public void transTreeFindRes(TreeNode root, int tar) {
        if (null == root) return;
        tar -= root.val;
        path.add(root.val);
        if (tar == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        transTreeFindRes(root.left, tar);
        transTreeFindRes(root.right, tar);
        path.removeLast();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}