package leetcode.problem79;

/**
 *给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Main {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
    }
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isCan(i, j, 0, isVisited, board, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean isCan(int i, int j, int length, boolean[][] isVisited, char[][] board, String word) {
        if (length == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || isVisited[i][j] || board[i][j] != word.charAt(length)) {
            return false;
        }
        isVisited[i][j] = true;
        if (isCan(i - 1, j, length + 1, isVisited, board, word)
                || isCan(i + 1, j, length + 1, isVisited, board, word)
                || isCan(i, j - 1, length + 1, isVisited, board, word)
                || isCan(i, j + 1, length + 1, isVisited, board, word)) {
            return true;
        }
        isVisited[i][j] = false;
        return false;
    }
}
