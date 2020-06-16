package leetcode.problem417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
 *
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 *
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：
 *
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 *  
 * 示例：
 *
 * 给定下面的 5x5 矩阵:
 *
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 *
 * 返回:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        List<List<Integer>> lists = pacificAtlantic(matrix);
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 0; j < lists.get(i).size(); j++) {
                System.out.print(lists.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    private static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] canB = new boolean[m][n];
        boolean[][] canW = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(canB, i, 0, matrix);
            dfs(canW, i, n - 1, matrix);
        }
        for (int i = 0; i < n; i++) {
            dfs(canB, 0, i, matrix);
            dfs(canW, m - 1, i, matrix);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canB[i][j] && canW[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    private static void dfs(boolean[][] canReach, int i, int j, int[][] matrix) {
        if (canReach[i][j]) {
            return;
        }
        canReach[i][j] = true;
        for (int[] direction : directions) {
            int nextc = i + direction[0];
            int nextx = j + direction[1];
            if (nextc < 0 || nextc >= matrix.length || nextx < 0
                    || nextx >= matrix[0].length || matrix[i][j] > matrix[nextc][nextx]) {
                continue;
            }
            dfs(canReach, nextc, nextx, matrix);
        }
    }
}
