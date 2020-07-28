package jianzhioffer.problem13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] a = {5,5,3,4,8,6,7,4,5,1};
        Main main = new Main();
        main.reOrderArray(a);
    }
    public void reOrderArray(int [] array) {
        if (array.length <= 1) return;
        List<Integer> list = new ArrayList<>();
        int substript = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) array[substript++] = array[i];
            else list.add(array[i]);
        }
        for (int i = 0; i < list.size(); i++) array[substript++] = list.get(i);
    }
}
