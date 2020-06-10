package leetcode.problem763;

import java.util.ArrayList;
import java.util.List;

/**
 *字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例 1：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = partitionLabels("ababcbacadefegdehijhklij");
        for (int x : list) System.out.print(x + " ");
    }
    public static List<Integer> partitionLabels(String S) {
        int[] letters = new int[26];
        for (int i = 0; i < S.length(); i++) {
            letters[S.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int maxIndex = 0, tempHead = 0;
        for (int i = 0; i < S.length(); i++) {
            maxIndex = Math.max(maxIndex, letters[S.charAt(i) - 'a']);
            if (i == maxIndex) {
                result.add(maxIndex - tempHead + 1);
                tempHead = maxIndex + 1;
            }
        }
        return result;
    }
}
