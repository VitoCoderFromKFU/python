package collections;

import java.util.HashMap;
import java.util.Scanner;

public class CountWordInText {
    public static void main(String[] args) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                int t = hashMap.get(s.charAt(i));
                t++;
                hashMap.replace(s.charAt(i), t);
            } else {
                hashMap.put(s.charAt(i), 1);
            }
        }
        System.out.println(hashMap);

    }
}