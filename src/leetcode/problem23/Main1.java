package leetcode.problem23;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);
        ListNode end = new ListNode(1);
        end.next = new ListNode(3);
        end.next.next = new ListNode(4);
        ListNode mid = new ListNode(2);
        mid.next = new ListNode(6);
//        mid.next.next = new ListNode(9);
//        ListNode listNode = merge2List(head, end);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        ListNode[] lists = {head, mid, end};
        Main1 main = new Main1();
        ListNode listNode = main.mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (ListNode listNode : lists) if (listNode != null) queue.add(listNode);
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            tail.next = minNode;
            if (minNode.next != null) queue.add(minNode.next);
            tail = tail.next;
        }
        return dummy.next;
    }
}
