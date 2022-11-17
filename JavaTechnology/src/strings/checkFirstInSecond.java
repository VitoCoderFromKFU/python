package strings;

import java.util.Scanner;

public class checkFirstInSecond {

    static boolean check(String s1, String s2) {

        if (s1.length() < s2.length())
            return false;
        for (int i = 0; i <= s1.length() - s2.length(); i++) {
            if (s2.charAt(0) == s1.charAt(i)) {
                char[] eq = new char[s2.length()];
                for (int j = 0; j < s2.length() && i < s1.length(); i++, j++) {
                    eq[j] = s1.charAt(i);
                }
                String eq1 = new String(eq);
                if (equalsString.equal(eq1, s2))
                    return true;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(check(s1, s2));

    }

}
