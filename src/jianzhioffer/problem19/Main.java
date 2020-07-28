package jianzhioffer.problem19;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[][] a = {{1,2},
                     {3,4}};
        ArrayList list = printMatrix(a);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int left = 0, top = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int temp = 0;
        ArrayList<Integer> list = new ArrayList<>((right+1) * (down+1));
        while (left <= right && top <= down) {
            for (int i = left; i <= right; i++) list.add(matrix[temp][i]);
            top++;
            temp = right;
            for (int i = top; i <= down; i++) list.add(matrix[i][temp]);
            right--;
            temp = down;
            if (left > right || top > down) break;
            for (int i = right; i >= left; i--) list.add(matrix[temp][i]);
            down--;
            temp = left;
            for (int i = down; i >= top; i--) list.add(matrix[i][temp]);
            left++;
            temp = top;
        }
        return list;
    }
}
