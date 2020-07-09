package leetcode.problem653;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 *
 * 案例 1:
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 9
 * 输出: True
 *  
 *
 * 案例 2:
 * 输入:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Target = 28
 * 输出: False
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        List<Integer> list = main.inOrder(root);
        for (int temp : list) System.out.print(temp + " ");
        System.out.println(main.findTarget(root, 3));
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> result = inOrder(root);
        int begin = 0, end = result.size() - 1;
        while (begin < end) {
            int temp = result.get(begin) + result.get(end);
            if (temp == k) return true;
            else if (temp < k) begin++;
            else end--;
        }
        return false;
    }
    private List<Integer> inOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                root = temp.right;
            }
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
