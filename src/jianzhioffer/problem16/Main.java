package jianzhioffer.problem16;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(5);

        ListNode result = Merge(listNode, listNode1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode result = null;
        if (list1.val < list2.val) {
            result = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            result = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode temp = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
                temp = temp.next;
            } else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if (list1 == null) temp.next = list2;
        if (list2 == null) temp.next = list1;
        return result;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}