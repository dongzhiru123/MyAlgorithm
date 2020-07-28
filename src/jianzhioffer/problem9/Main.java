package jianzhioffer.problem9;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.pow(2,1));
        //System.out.println(JumpFloorII(5));
    }
    public static int JumpFloorII(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) dp[i] = 2 * dp[i-1];
        return dp[n];
    }
//    if(target <= 0)
//            return 0;
//
//        return (int)Math.pow(2, target - 1);
}
