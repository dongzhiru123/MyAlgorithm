package leetcode.problem494;

public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        System.out.println(main1.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return trackRoad(0, nums, S);
    }
    private int trackRoad(int start, int[] nums, int S) {
        if (start == nums.length) {
            return S == 0 ? 1 : 0;
        }
        return trackRoad(start + 1, nums, S - nums[start])
                + trackRoad(start + 1, nums, S + nums[start]);
    }
}
