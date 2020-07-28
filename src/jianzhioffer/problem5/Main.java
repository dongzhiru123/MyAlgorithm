package jianzhioffer.problem5;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack1.empty()) {
            int temp = stack1.pop();
            stack2.push(temp);
        }
        stack1.push(node);
        while (!stack2.empty()) {
            int temp = stack2.pop();
            stack1.push(temp);
        }
    }

    public int pop() {
        return stack1.pop();
    }
}
