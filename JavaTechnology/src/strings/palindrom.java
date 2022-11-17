package strings;

import java.util.Scanner;

public class palindrom {
    public static void main(String[] args) {
        boolean result = true;
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                result = false;
            }
        }
        System.out.println(result);
    }
}
