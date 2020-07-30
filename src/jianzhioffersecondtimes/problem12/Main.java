package jianzhioffersecondtimes.problem12;

/**
 *请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.exist(new char[][]{{'s', 'a', 'b', 'c'},
                                                   {'s', 'v', 'e', 'r'},
                                                   {'s', 'v', 'e', 'r'}}, "savveec"));
    }
    public boolean exist(char[][] board, String word) {
        if (null == board || board.length == 0 || board[0].length == 0) return false;
        int rowLength = board.length, colLength = board[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (dfs(board, 1, word, row, col, rowLength, colLength)) return true;
            }
        }
        return false;
    }
    int[][] positions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean dfs(char[][] board, int subscript, String word, int row, int col, int rowLength, int colLenght) {
        if (board[row][col] == word.charAt(subscript - 1) && subscript == word.length()) {
            return true;
        }
        if (board[row][col] != word.charAt(subscript - 1)) return false;
        char temporary = board[row][col];
        board[row][col] = '#';
        for (int[] position : positions) {
            int abscissa = row + position[0], ordinate = col + position[1];
            if (abscissa < 0
                    || abscissa >= rowLength
                    || ordinate < 0
                    || ordinate >= colLenght
                    || board[abscissa][ordinate] == '#') continue;

            if (dfs(board, subscript + 1, word, abscissa, ordinate, rowLength, colLenght))
                return true;
        }
        board[row][col] = temporary;
        return false;
    }
}
