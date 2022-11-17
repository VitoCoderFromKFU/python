package arrays;

public class longerOfOne {


    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 1, 1, 1, 5, 6, 1, 7, 5, 4, 7, 1, 0, 1, 5, 7, 2, 3, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int index = 0;
        int index1 = 0;
        int count = 0;
        int count1 = -1;
        for (int i = 0; i < a.length; i++) {

            if (a[i] == 1) {
                index = i;
                while (i < a.length && a[i] == 1) {
                    count++;
                    i++;
                }
                if (count1 < count) {
                    index1 = index;
                    count1 = count;
                }
                index = 0;
                count = 0;
            } else {
                index = 0;
                count = 0;
            }

        }
        if (count > count1)
            System.out.println(index + " " + count);
        else
            System.out.println(index1 + " " + count1);
    }

}
