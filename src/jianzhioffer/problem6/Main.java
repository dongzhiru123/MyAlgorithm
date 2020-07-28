package jianzhioffer.problem6;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,1,0,1,1};
        System.out.println(minNumberInRotateArray(a));
    }
    public static int minNumberInRotateArray(int [] array) {
        int length = array.length;
        if (length == 0) return 0;
        int num = 0;
        for (int i = 0; i < length; i++) {
            num += array[i];
        }
        if (length * array[0] == num) return array[0];
        int result = 0;
        for (int i = 0; i < length-1; i++) {
            if (array[i] > array[i+1]) {
                result = array[i+1];
                break;
            }
        }
        return result;
//        if(array.length==0){
//            return 0;
//        }
//        else{
//            int min=array[0];
//            for(int i=1;i<array.length;i++){
//                if(array[i]<min){
//                    min=array[i];
//                }
//            }
//
//            return min;
//        }
    }
}
