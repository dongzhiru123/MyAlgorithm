package jianzhioffersecondtimes.problem25;

/**
 *输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 限制：
 * 0 <= 链表长度 <= 1000
 */
public class Main {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(2);
        head2.next.next.next = new ListNode(3);

        Main main = new Main();
        ListNode listNode = main.mergeTwoLists(head1, head2);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0), temp = pre;

        while (l1 !=  null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = (l1 == null) ? l2 : l1;
        return pre.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}