package jianzhioffer.problem24;

import java.util.ArrayList;

public class Main {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) return result;
        path.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) result.add(new ArrayList<>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return result;
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