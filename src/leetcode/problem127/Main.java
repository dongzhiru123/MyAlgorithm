package leetcode.problem127;

import java.util.*;

/**
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 示例 1:
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 输出: 5
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *      返回它的长度 5。
 *
 * 示例 2:
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 输出: 0
 *
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 */
public class Main {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dog", "dot");
        System.out.println(ladderLength("hot", "dog", wordList));
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!isHasString(wordList, endWord)) return 0;
        int changeNum = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            changeNum++;
            while ((size--) > 0) {
                String temp = queue.poll();
                List<String> list = getNeighbors(temp, wordList);
                if (isHasString(list, endWord)) {
                    changeNum++;
                    return changeNum;
                }
                for (String str : list) {
                    queue.add(str);
                }
            }
        }
        return 0;
    }
    private static boolean isHasString(List<String> list, String string) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (string.equals(list.get(i))) {
                return true;
            }
        }
        return false;
    }
    private static HashSet<String> hashSet = new HashSet<>();
    private static List<String> getNeighbors(String string, List<String> wordList) {
        if (hashSet.size() == wordList.size()) {
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        for (String str : wordList) {
            if (hashSet.contains(str)) {
                continue;
            } else {
                if (isConnect(string, str)) {
                    list.add(str);
                    hashSet.add(str);
                }
            }
        }
        return list;
    }
    private static boolean isConnect(String str1, String str2) {
        int length = str1.length();
        int changeNum = 0;
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                continue;
            } else changeNum++;
            if (changeNum >= 2) return false;
        }
        return changeNum == 1;
    }
}
