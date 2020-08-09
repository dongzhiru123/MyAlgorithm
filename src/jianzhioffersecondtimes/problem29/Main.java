package jianzhioffersecondtimes.problem29;

/**
 *输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 *
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * 限制：
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class Main {
    public static void main(String[] args) {
        int[] ints = spiralOrder(new int[][]{{1 , 2, 3},{4, 5, 6},{7, 8, 9}});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
    public static int[] spiralOrder(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int beginColumn = 0, endColumn = matrix[0].length - 1,
                beginRow = 0, endRow = matrix.length - 1;
        int[] res = new int[matrix.length * matrix[0].length];
        int count = 0;
        while (true) {
            for (int i = beginColumn; i <= endColumn; i++) res[count++] = matrix[beginRow][i];
            if (++beginRow > endRow) break;
            for (int i = beginRow; i <= endRow; i++) res[count++] = matrix[i][endColumn];
            if (--endColumn < beginColumn) break;
            for (int i = endColumn; i >= beginColumn; i--) res[count++] = matrix[endRow][i];
            if (--endRow < beginRow) break;
            for (int i = endRow; i >= beginRow; i--) res[count++] = matrix[i][beginColumn];
            if (++beginColumn > endColumn) break;
        }
        return res;
    }
}
