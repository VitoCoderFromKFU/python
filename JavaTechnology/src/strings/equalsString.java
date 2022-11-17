package strings;

import java.util.Scanner;

public class equalsString {
    public static boolean equal(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        System.out.print(equal(s1, s2));
    }

}
