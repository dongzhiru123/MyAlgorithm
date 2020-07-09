package leetcode.problem109;

import java.util.LinkedList;

/**
 *给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        TreeNode treeNode = main.sortedListToBST(head);
        LinkedList<TreeNode> list = new LinkedList<>();
        if (treeNode != null) list.addLast(treeNode);
        while (!list.isEmpty()) {
            int n = list.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = list.poll();
                System.out.print(temp.val + " ");
                if (temp.left != null) list.add(temp.left);
                if (temp.right != null) list.add(temp.right);
            }
            System.out.println();
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        ListNode preMid = preMid(head);
        ListNode mid = preMid.next;
        preMid.next = null;
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
    public ListNode preMid(ListNode head) {
        ListNode slow = head, fast = head.next, preMid = head;
        while (fast != null && fast.next != null) {
            preMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return preMid;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}