package leetcode.problem646;

import java.util.Arrays;

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 * 示例 :
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 *
 * 注意：
 * 给出数对的个数在 [1, 1000] 范围内。
 */
public class Main {
    public static void main(String[] args) {
        int[][] pairs = {{1, 2},
                {2, 3},
                {3, 4}};
        Main main = new Main();
        System.out.println(main.findLongestChain(pairs));
    }
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        int length = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int maxSize = 1;
        int temp = pairs[0][1];
        for (int i = 1; i < length; i++) {
            if (pairs[i][0] > temp) {
                maxSize++;
                temp = pairs[i][1];
            }
        }
        return maxSize;
    }
}
