package jianzhioffersecondtimes.problem40;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 *
 * 示例 2：
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Main {
    public static void main(String[] args) {
        int[] leastNumbers = getLeastNumbers(new int[]{0, 1, 2, 3, 1, 5, 6}, 3);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.print(leastNumbers[i] + " ");
        }
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (null == arr || arr.length == 0 || k == 0) return new int[0];
        Queue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int temp : arr) {
            if (priorityQueue.size() != k) {
                priorityQueue.add(temp);
            } else {
                if (temp < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.add(temp);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
