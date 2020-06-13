package leetcode.problem95;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
public class Main {
    public static void main(String[] args) {
        
    }
    public static List<TreeNode> generateTrees(int n) {
        if (n < 1) return new LinkedList<>();
        return generateSubtree(1, n);
    }
    private static List<TreeNode> generateSubtree(int s, int e) {
        List<TreeNode> result = new LinkedList<>();
        if (s > e) {
            result.add(null);
            return result;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = generateSubtree(s, i - 1);
            List<TreeNode> right = generateSubtree(i + 1, e);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    result.add(treeNode);
                }
            }
        }
        return result;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}