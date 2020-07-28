package guanglianda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        String[] ints = bufferedReader.readLine().split(" ");
        bufferedReader.close();

        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(ints[i]);
        }
        Main main = new Main();
        System.out.println(main.getArea(nums));
    }
    public long getArea(int[] sides) {
        if (null == sides || sides.length == 0) return -1;
        int length = sides.length;
        if (length < 4) return -1;
        Arrays.sort(sides);
        int side1 = -1, side2 = 1;
        boolean isGetSide2 = false;
        for (int i = length - 2; i >= 0; i--) {
            if (sides[i] == sides[i + 1]) {
                if (!isGetSide2) {
                    side2 = sides[i];
                    isGetSide2 = true;
                    i--;
                    continue;
                }
            } else continue;
            side1 = sides[i];
            break;
        }
        return side1 == -1 ? -1 : side1 * side2;
    }
}
