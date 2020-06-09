package leetcode.problem22;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
    public static List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new ArrayList<String>(){{
           add("");
        }};
        dp.add(dp0);
        for (int i = 1; i <= n; i++) {
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String s : dp.get(j)) {
                    for (String x : dp.get(i - j - 1)) temp.add("(" + s + ")" + x);
                }
            }
            dp.add(temp);
        }
        return dp.get(n);
    }
}
