package jianzhioffer.problem17;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(8);
        treeNode.right = new TreeNode(7);
        treeNode.left.left = new TreeNode(9);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(4);
        treeNode.left.right.right = new TreeNode(7);

        TreeNode treeNode1 = new TreeNode(8);
        treeNode1.left = new TreeNode(9);
        treeNode1.right = new TreeNode(2);
        System.out.println(main.isChildTree(treeNode.left, treeNode1));
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null) return false;
        getEqualNode(root1, root2);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).val);
            if (isChildTree(list.get(i), root2)) return true;
        }
        return false;
    }
    List<TreeNode> list = new ArrayList<>();
    public void getEqualNode(TreeNode treeNode, TreeNode treeNode1) {
        if (treeNode == null) return;
        TreeNode temp = treeNode;
        if (temp.val == treeNode1.val) list.add(temp);
        getEqualNode(temp.left, treeNode1);
        getEqualNode(temp.right, treeNode1);
    }
    public boolean isChildTree(TreeNode root1,TreeNode root2) {
        Queue<TreeNode> queue1 = new LinkedList();
        Queue<TreeNode> queue2 = new LinkedList();
        queue1.add(root1);
        queue2.add(root2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode temp1 = queue1.poll();
            TreeNode temp2 = queue2.poll();
            if (temp1.left == null && temp2.left == null);
            else {
                if ((temp1.left != null && temp2.left != null)) {
                    if (temp1.left.val == temp2.left.val) {
                        queue1.add(temp1.left);
                        queue2.add(temp2.left);
                    } else return false;
                } else if (temp1.left == null) return false;
            }
            if (temp1.right == null && temp2.right == null);
            else {
                if (((temp1.right != null && temp2.right != null))) {
                    if (temp1.right.val == temp2.right.val) {
                        queue1.add(temp1.right);
                        queue2.add(temp2.right);
                    } else return false;
                } else if (temp1.right == null) return false;
            }
        }
        return true;
    }
}
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}