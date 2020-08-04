package jianzhioffersecondtimes.problem24;

/**
 *定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * 限制：
 * 0 <= 节点个数 <= 5000
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        ListNode listNode = main.reverseList(head);

        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode(0);
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre.next;
            pre.next = head;
            head = temp;
        }
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