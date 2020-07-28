package jianzhioffer.problem22;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(8);
        Main main = new Main();
        ArrayList<Integer> arrayList = main.PrintFromTopToBottom(treeNode);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null) return arrayList;
        linkedList.addFirst(root);
        while (!linkedList.isEmpty()) {
            TreeNode temp = linkedList.pollFirst();
            arrayList.add(temp.val);
            if (temp.left != null) linkedList.addLast(temp.left);
            if (temp.right != null) linkedList.addLast(temp.right);
        }
        return arrayList;
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