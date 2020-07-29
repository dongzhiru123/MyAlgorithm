package jianzhioffersecondtimes.problem06;

import java.util.Stack;

/**
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
public class Main {
    public static void main(String[] args) {

    }
    public int[] reversePrint(ListNode head) {
        if (null == head) return new int[0];
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int length = stack.size();
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}