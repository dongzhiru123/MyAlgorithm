package jianzhioffersecondtimes.problem07;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 *输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode treeNode = main.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                size--;
            }
            System.out.println();
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> subscriptMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            subscriptMap.put(inorder[i], i);
        }
        return buildTree(preorder, subscriptMap, 0, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(
            int[] preorder,
            HashMap<Integer,Integer> subscriptMap,
            int pre_index,
            int in_left,
            int in_right) {
        if (in_left > in_right) return null;
        TreeNode root = new TreeNode(preorder[pre_index]);
        int root_subscript = subscriptMap.get(preorder[pre_index]);
        root.left = buildTree(preorder, subscriptMap, pre_index + 1, in_left, root_subscript - 1);
        root.right = buildTree(preorder, subscriptMap, pre_index + (root_subscript - in_left) + 1, root_subscript + 1, in_right);
        return root;
    }
}
class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}