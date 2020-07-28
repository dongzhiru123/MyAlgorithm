package jianzhioffer.problem20;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
    int minValue = Integer.MAX_VALUE;
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int node) {
        if (node < minValue) {
            minValue = node;
            stack1.push(minValue);
            stack2.push(minValue);
        } else {
            stack1.push(node);
            stack2.push(minValue);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
