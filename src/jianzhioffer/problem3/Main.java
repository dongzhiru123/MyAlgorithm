package jianzhioffer.problem3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);
        ArrayList<Integer> arrayList = printListFromTailToHead(listNode);
        arrayList.forEach(System.out::println);
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            ListNode listNode1 = listNode;
            listNode = listNode.next;
            listNode1.next = null;
            list.add(0, listNode1.val);
        }
        return (ArrayList<Integer>) list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
