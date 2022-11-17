package arrays;

import java.util.*;

public class PermutationElemntsVector {

    static boolean isSimpleNum(int num) {
        if (num == 1)
            return true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        boolean found = false;
        int ind = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            if (isSimpleNum(a[i])) {
                if (!found) {
                    found = true;
                    ind = i;
                } else if (found) {
                    temp = a[i];
                    a[i] = a[ind];
                    a[ind] = temp;

                }
            }
        }
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + ", ");
    }
}
