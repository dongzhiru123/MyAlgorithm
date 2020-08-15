package jianzhioffersecondtimes.problem37;

import java.util.LinkedList;
import java.util.Queue;

/**
 *请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 示例: 
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);

        TreeNode node = deserialize(serialize(treeNode));

        System.out.println(serialize(node));
        System.out.println(serialize(treeNode));
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (null == root) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                queue.add(node.left);
                queue.add(node.right);
                sb.append(node.val);
                sb.append(",");
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if ("[]".equals(data)) return null;
        String[] strings = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{add(root);}};

        int subscript = 1;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if ("null".equals(strings[subscript])) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.valueOf(strings[subscript]));
                queue.add(node.left);
            }
            subscript++;

            if ("null".equals(strings[subscript])) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.valueOf(strings[subscript]));
                queue.add(node.right);
            }
            subscript++;
        }

        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}