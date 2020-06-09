package leetcode.problem19;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        Main main = new Main();
        ListNode listNode = main.removeNthFromEnd(head, 6);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        ListNode second = head;
        while ((n--) > 0 && second != null) second = second.next;
        if (n >= 0) return dummy.next;
        if (second == null) {
            dummy.next = dummy.next.next;
            return dummy.next;
        } else {
            while (second.next != null) {
                second = second.next;
                first = first.next;
            }
            first.next = first.next.next;
        }
        return dummy.next;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}