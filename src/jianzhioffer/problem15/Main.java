package jianzhioffer.problem15;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode1 = ReverseList(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
    public static ListNode ReverseList(ListNode head) {
        ListNode first = null;
        while (head != null) {
            ListNode second = head.next;
            head.next = null;
            head.next = first;
            first = head;
            head = second;
        }
        return first;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}