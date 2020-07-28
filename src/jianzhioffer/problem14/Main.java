package jianzhioffer.problem14;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next = new ListNode(6);
        ListNode listNode1 = FindKthToTail(listNode, 6);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
    public static ListNode FindKthToTail(ListNode head,int k) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && (k--) > 0) quick = quick.next;
        if (k > 0 && quick == null) return null;
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}