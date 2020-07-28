package jianzhioffer.problem8;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(JumpFloor(4));
    }
    public static int JumpFloor(int target) {
        if (target < 0) return 0;
        if (target <= 2) return target;
        Map<Integer, Integer> map = new HashMap<>(target);
        if (map.containsKey(target)) {
            return map.get(target);
        } else {
            int ways = JumpFloor(target-1) + JumpFloor(target-2);
            map.put(target, ways);
            return ways;
        }
    }
}
