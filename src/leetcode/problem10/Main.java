package leetcode.problem10;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 *
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * 示例 2:
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(isMatch("aab", "a*ab"));
    }
    public static boolean isMatch(String text, String pattern) {
//        int length1 = s.length();
//        int length2 = s.length();
//        if (length1 == 0 && length2 == 0) return true;
//        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
//        dp[0][0] = true;
//        for (int i = 2; i <= length2; i++) dp[0][i] = (p.charAt(i - 1) == '*') && dp[0][i - 2];
//        for (int i = 0; i < length1; i++) {
//            for (int k = 0; k < length2; k++) {
//                if (p.charAt(k) == '*') {
//                    dp[i + 1][k + 1] = dp[i + 1][k - 1] ||
//                            (dp[i][k + 1] && headMatched(s, p, i, k - 1));
//                } else {
//                    dp[i + 1][k + 1] = dp[i][k] && headMatched(s, p, i, k);
//                }
//            }
//        }
//        return dp[length1][length2];
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
    //判断s第i个字符和p第j个字符是否匹配
    public static boolean headMatched(String s,String p,int i,int j){
        return s.charAt(i) == p.charAt(j) || p.charAt(j) == '.';
    }
}
