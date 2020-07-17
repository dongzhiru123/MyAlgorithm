package leetcode.problem501;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(2);
        int[] mode = main.findMode(root);
        for (int temp : mode) System.out.print(temp + " ");
    }

    private List<Integer> result = new ArrayList<>();
    private TreeNode pre = null;
    private int count = 1;
    private int maxCount = 1;

    public int[] findMode(TreeNode root) {
        getMode(root, result);
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
    public void getMode(TreeNode treeNode, List<Integer> result) {
        if (treeNode == null) return;
        getMode(treeNode.left, result);
        if (pre != null) {
            if (pre.val == treeNode.val) count++;
            else count = 1;
        }
        pre = treeNode;
        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(treeNode.val);
        }
        else if (count == maxCount) result.add(treeNode.val);
        getMode(treeNode.right, result);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}