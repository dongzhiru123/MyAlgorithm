package jianzhioffer.problem21;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {4,3,5,1,2};
        Main main = new Main();
        System.out.println(main.IsPopOrder(a, b));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int length = pushA.length;
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < length || j < length || !stack.empty()) {
            if (i < length && pushA[i] != popA[j]) {
                stack.push(pushA[i]);
                i++;
            }
            else if (i < length && pushA[i] == popA[j]) {
                i++;
                j++;
            }
            else if (stack.pop() == popA[j]) j++;
            else return false;
        }
        return true;
    }
}
