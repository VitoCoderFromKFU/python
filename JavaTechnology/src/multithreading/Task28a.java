package multithreading;

import java.util.Arrays;
import java.util.Random;


public class Task28a {
    //endregion
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(array));
        new Task1(array).start();
        new Task1(array).start();

    }
}

class Task1 extends Thread {
    int[] array;
    int resultSum = 0;

    Task1(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        sum(array);
        System.out.println(resultSum + " " + Thread.currentThread().getName());
    }

    public void sum(int[] array) {
        for (int i = 0; i < array.length; i++) {
            resultSum += array[i];
        }
    }
}
