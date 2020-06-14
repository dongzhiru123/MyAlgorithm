package leetcode.problem1091;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
 *
 * 一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
 *
 * 相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
 * C_1 位于 (0, 0)（即，值为 grid[0][0]）
 * C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
 * 如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
 * 返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
 *
 * 示例 1：
 * 输入：[[0,1],[1,0]]
 * 输出：2
 *
 * 示例 2：
 * 输入：[[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 为 0 或 1
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        if (grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        queue.add(new Pair<>(0, 0));
        int minLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            minLength++;
            while ((size--) > 0) {
                Pair<Integer, Integer> pair = queue.poll();
                int abscissa = pair.getKey();
                int ordinate = pair.getValue();
                if (grid[abscissa][ordinate] == 1) {
                    continue;
                }
                if (abscissa == m - 1 && ordinate == n - 1) {
                    return minLength;
                }
                grid[pair.getKey()][pair.getValue()] = 1;
                for (int[] direction : directions) {
                    int abscissaTemp = abscissa + direction[0];
                    int ordinateTemp = ordinate + direction[1];
                    if (abscissaTemp < 0 || abscissaTemp >= m || ordinateTemp < 0 || ordinateTemp >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(abscissaTemp, ordinateTemp));
                }
            }
        }
        return -1;
    }
}
