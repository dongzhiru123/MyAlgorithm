package jianzhioffer.problem11;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.NumberOf12(3));
    }
    //fa 一
    public int NumberOf1(int n) {
        int num = 0;
        while (n != 0) {
            n = n & (n-1);
            num++;
        }
        return num;
    }
    //fa 二
    public int NumberOf12(int n) {
        int num = 0;
        char[] chars = Integer.toBinaryString(n).toCharArray();
        for (char c : chars) if (c == '1') num++;
        return num;
    }
}
