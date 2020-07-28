package jianzhioffer.problem29;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{1,6,4,8,9,5,1,2,4,7};
        ArrayList<Integer> arrayList = GetLeastNumbers_Solution(a, 3);
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i));
        }
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int length = input.length;
        ArrayList<Integer> result = new ArrayList<>();
        if (length < k) return result;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < input.length; i++) {
            priorityQueue.add(input[i]);
        }
        while ((k--) > 0) {
            result.add(priorityQueue.poll());
        }
        return result;
    }
}
