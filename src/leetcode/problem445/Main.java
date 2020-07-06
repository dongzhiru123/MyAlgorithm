package leetcode.problem445;

import java.util.Stack;

/**
 *给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(6);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode listNode = main.addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = listToStack(l1);
        Stack<Integer> l2Stack = listToStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int num1 = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int num2 = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = num1 + num2 + carry;
            ListNode temp = new ListNode(sum % 10);
            temp.next = head.next;
            head.next = temp;
            carry = sum / 10;
        }
        return head.next;
    }
    public Stack<Integer> listToStack(ListNode listNode) {
        Stack<Integer> result = new Stack<>();
        while (listNode != null) {
            result.add(listNode.val);
            listNode = listNode.next;
        }
        return result;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}