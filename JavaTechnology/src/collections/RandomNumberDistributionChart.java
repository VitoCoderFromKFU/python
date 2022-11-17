package collections;

import java.util.HashMap;
import java.util.Random;

public class RandomNumberDistributionChart {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Random random = new Random();
        int min = -100;
        int max = 100;
        int n;
        for (int i = 0; i < 100000; i++) {
            n = random.nextInt(max - min + 1);
            if (hashMap.containsKey(n)) {
                int t = hashMap.get(n);
                t++;
                hashMap.replace(n,t);
            }else{
                hashMap.put(n,1);
            }

        }
        System.out.println(hashMap);
    }

}
