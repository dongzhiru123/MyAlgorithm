package leetcode.problem406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 *
 * 注意：
 * 总人数少于1100人。
 *
 * 示例
 * 输入:
 * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出:
 * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class Main {
    public static void main(String[] args) {
        int[][] queue = {{7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}};
        int[][] result = reconstructQueue(queue);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i][0] + " " + result[i][1]);
            System.out.println();
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int[] temp : people) {
            list.add(temp[1], temp);
        }
        return list.toArray(new int[people.length][]);
    }
}
