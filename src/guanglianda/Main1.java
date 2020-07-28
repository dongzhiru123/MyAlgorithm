package guanglianda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        String[] ints = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(ints[i]);
        }

        Main1 main1 = new Main1();
        System.out.println(main1.countTimes(nums));
    }
    public int countTimes(int[] ints) {
        int length = ints.length;
        int count = 0;
        Map<Integer, Boolean> isCount = new HashMap<>();
        Map<Integer, Integer> numberNum = new HashMap<>();
        Map<Integer, Integer> treeMap = new TreeMap<>();

        for (int i = 0; i < length; i++) {
            treeMap.put(ints[i], i);
            numberNum.put(ints[i], numberNum.getOrDefault(ints[i], 1));
            isCount.put(ints[i], false);
        }

        for (int key : treeMap.keySet()) {
            // 下标
            int temp = treeMap.get(key);
            for (int i = temp; i < length; i++) {
                if (!isCount.get(key) && key > ints[i]) {
                    count++;
                    if (numberNum.get(key) == 1) {
                        isCount.put(key, true);
                    } else numberNum.put(key, numberNum.get(key) - 1);
                }
            }
        }

        return count;
    }
}
