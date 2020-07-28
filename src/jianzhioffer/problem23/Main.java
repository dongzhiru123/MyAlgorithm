package jianzhioffer.problem23;

public class Main {
    public static void main(String[] args) {
        int[] a = {4,8,6,12,16,14,10};
        VerifySquenceOfBST(a);
    }
    public static boolean VerifySquenceOfBST(int [] sequence) {
        int length = sequence.length;
        if (length == 0) return false;
        int i = 0;
        while ((--length) > 0) {
            while (sequence[i] < sequence[length]) i++;
            while (sequence[i] > sequence[length]) i++;
            if (i < length - 1) return false;
            i = 0;
        }
        return true;
    }
}
