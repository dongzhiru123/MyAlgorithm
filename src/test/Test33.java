package test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 * 题目描述：有 N 个 信 和 信封，它们被打乱，求错误装信方式的数量。
 *
 * 定义一个数组 dp 存储错误方式数量，dp[i] 表示前 i 个信和信封的错误方式数量。假设第 i 个信装到第 j 个信封里面，而第 j 个信装到第 k 个信封里面。根据 i 和 k 是否相等，有两种情况：
 *
 * i==k，交换 i 和 j 的信后，它们的信和信封在正确的位置，但是其余 i-2 封信有 dp[i-2] 种错误装信的方式。由于 j 有 i-1 种取值，因此共有 (i-1)*dp[i-2] 种错误装信方式。
 * i != k，交换 i 和 j 的信后，第 i 个信和信封在正确的位置，其余 i-1 封信有 dp[i-1] 种错误装信方式。由于 j 有 i-1 种取值，因此共有 (i-1)*dp[i-1] 种错误装信方式。
 * 综上所述，错误装信数量方式数量为：
 */
public class Test33 {
    public static void main(String[] args) {
//        Test33 test33 = new Test33();
//        System.out.println(test33.hasNumber(4));
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        Queue<Integer> queue = new PriorityQueue<>((a, b) -> (a - b));
//        LinkedList<Integer> queue1 = new LinkedList<>();
//        queue1.addFirst(5);
//        queue1.addLast(4);
//        System.out.println(queue1.pollFirst());
//        System.out.println(queue1.pollFirst());
//        Executors.newCachedThreadPool();
//        int a = 100, b = 50, c = a---b, d = a---b;
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
        Integer a = 1;
        Integer b = 1;
        Integer c = 500;
        Integer d = 500;
        System.out.println(a == b);
        System.out.println(c == d);
    }
    public int hasNumber(int n) {
        if (n <= 0) return 0;
        int result = 1;
        for (int i = 1; i <= n - 1; i++) {
            result *=  i;
        }
        return result;
    }
}
