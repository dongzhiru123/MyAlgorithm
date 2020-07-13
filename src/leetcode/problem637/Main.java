package leetcode.problem637;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 *
 * 示例 1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *  
 * 提示：
 * 节点值的范围在32位有符号整数范围内。
 */
public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        Main main = new Main();
        List<Double> doubles = main.averageOfLevels(root);
        for (double num : doubles) {
            System.out.println(num);
        }
    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        while (!linkedList.isEmpty()) {
            int size = linkedList.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode temp = linkedList.poll();
                sum += temp.val;
                if (temp.left != null) linkedList.add(temp.left);
                if (temp.right != null) linkedList.add(temp.right);
            }
            result.add(sum / size);
        }
        return result;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}