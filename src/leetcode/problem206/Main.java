package leetcode.problem206;

/**
 *反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Main main = new Main();
        ListNode listNode = main.reverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode temp = new ListNode(0);
        while (head != null) {
            ListNode second = temp.next;
            temp.next = head;
            head = head.next;
            temp.next.next = second;
        }
        return temp.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}