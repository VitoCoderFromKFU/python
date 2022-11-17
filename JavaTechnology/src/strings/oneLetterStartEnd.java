package strings;

import java.util.Scanner;

public class oneLetterStartEnd {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String result = new String();
        String[] words = s.split(" ");
        for (String word : words) {
            if (word.charAt(0) == word.charAt(word.length() - 1)) {
                result += word + ", ";
            }
        }
        System.out.println(result);

    }
}
