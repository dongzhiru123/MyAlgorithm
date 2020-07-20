package leetcode.problem242;

/**
 *给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 *
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isAnagram("abc", "bca"));
    }
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        int length1 = s.length();
        int length2 = t.length();
        if (length1 != length2) return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[] ints = new int[26];
        for (char c : chars1) {
            ints[c - 'a']++;
        }
        for (char c : chars2) {
            ints[c - 'a']--;
        }
        for (int temp : ints) {
            if (temp != 0) return false;
        }
        return true;
    }
}
