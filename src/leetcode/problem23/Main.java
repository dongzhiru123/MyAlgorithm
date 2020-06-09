package leetcode.problem23;

import jdk.nashorn.internal.runtime.ListAdapter;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode end = new ListNode(2);
        end.next = new ListNode(4);
        end.next.next = new ListNode(5);
        ListNode mid = new ListNode(2);
        mid.next = new ListNode(3);
        mid.next.next = new ListNode(7);
//        ListNode listNode = merge2List(head, end);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ListNode[] lists = {head, mid, end};
        Main main = new Main();
        ListNode listNode = main.mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i];
        int mid = i + (j - i) / 2;
        ListNode l1 = merge(lists, i, mid);
        ListNode l2 = merge(lists, mid + 1, j);
        return merge2List(l1, l2);
    }
    private static ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge2List(l1.next, l2);
            return l1;
        }
        l2.next = merge2List(l1, l2.next);
        return l2;
    }
}
class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}