package leetcode.problem451;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 * 输入:
 * "tree"
 * 输出:
 * "eert"
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * 示例 2:
 * 输入:
 * "cccaaa"
 * 输出:
 * "cccaaa"
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 *
 * 示例 3:
 * 输入:
 * "Aabb"
 * 输出:
 * "bbAa"
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(frequencySort("eert"));
    }
    public static String frequencySort(String s) {
        char[] chars = s.toCharArray();
        int[] letters = new int[128];
        for (char c : chars) letters[c]++;
        Queue<Character> queue = new PriorityQueue<>(128, (a, b) -> Integer.compare(letters[b], letters[a]));
        for (int i = 0; i < letters.length; i++) {
            if (!(letters[i] == 0)) queue.offer((char)i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            int i = letters[c];
            while (i > 0) {
                stringBuilder.append(c);
                i--;
            }
        }
        return stringBuilder.toString();
    }
}
