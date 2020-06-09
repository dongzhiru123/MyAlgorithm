package leetcode.problem25;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
//        ListNode[] a = reverse(listNode, 3);
////        System.out.println(a[0].val);
////        System.out.println(a[1].val);
////        System.out.println("-------");
        ListNode result = reverseKGroup(listNode, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(0);
        result.next = head;

        ListNode pre = result;
        ListNode end = result;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode[] a = reverse(pre, k);
            pre.next = a[0];
            pre = a[1].next;
            end = a[1].next;
            System.out.println(a[1].val);
        }
        return result.next;
    }
    public static ListNode[] reverse(ListNode begin, int k) {
        ListNode first = begin;
        ListNode temp = begin.next;
        first.next = null;
        ListNode next = null;
        while (k > 0) {
            next = temp.next;
            temp.next = first;
            first = temp;
            k--;
        }
        ListNode[] result = new ListNode[]{first, next};
        return result;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}