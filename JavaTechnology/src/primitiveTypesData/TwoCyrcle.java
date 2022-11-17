package primitiveTypesData;

public class TwoCyrcle {

    public static void main(String[] args) {
        int n = 5, m = 5;
        double s = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s *= 1.0 / (i + (j * j));
            }
        }
        System.out.println(s);
    }

}
