package jianzhioffer.problem18;

public class Main {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(8);
        treeNode1.left = new TreeNode(9);
        treeNode1.left.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(4);
        treeNode1.right = new TreeNode(2);

        Main main = new Main();
        main.Mirror(treeNode1);
        System.out.println(treeNode1.left.val);
        System.out.println(treeNode1.right.val);
        System.out.println(treeNode1.right.left.val);
        System.out.println(treeNode1.right.right.val);
    }
    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        Mirror(root.left);
        Mirror(root.right);
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