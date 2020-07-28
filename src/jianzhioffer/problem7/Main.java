package jianzhioffer.problem7;

public class Main {
    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }
    //方法一
//    public static int Fibonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//        return Fibonacci(n-1) + Fibonacci(n-2);
//    }
    //方法二
    public static int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int begin1 = 0, begin2 = 1, result = 0;
        for (int i = 1; i < n; i++) {
            result = begin1 + begin2;
            begin1 = begin2;
            begin2 = result;
        }
        return result;
    }
}
