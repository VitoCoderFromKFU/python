package multithreading;

import java.util.Scanner;

public class Task28b extends Thread {
    static int sum;
    static int[] array;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter count threads: ");
        int countThreads = scanner.nextInt();
        System.out.print("Enter length array: ");
        int arraySize = scanner.nextInt();
        System.out.print("Enter array: ");
        array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int m;
        m = (int)(Math.ceil((double)arraySize / (double) countThreads));
        for (int i = 0; i < countThreads; i++) {
            MeanArrayThread mat= new MeanArrayThread(i*m,(i+1)*m);
            mat.start();
            mat.join();
        }
        System.out.println("General sum: "+sum);
    }

}

class MeanArrayThread extends Thread {
    int from;
    int to;
    MeanArrayThread(int from, int to) {
        this.from = from;
        this.to = to;
    }
    @Override
    public void run() {
        sum();
    }

    public void sum() {
        int localSum=0;
        for (int i = this.from; i < this.to; i++) {
            if(i<Task28b.array.length) {
                Task28b.sum += Task28b.array[i];
                localSum += Task28b.array[i];
            }
        }
        System.out.println("Local sum of "+Thread.currentThread().getName()+" = "+localSum);
    }
}