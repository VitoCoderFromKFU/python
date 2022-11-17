package bigNumbers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TwoCyrcle {
    public static void main(String[] args) {
        int n = 500, m = 500;
        BigDecimal s = new BigDecimal("1.000");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s = s.multiply(BigDecimal.ONE.divide(BigDecimal.valueOf(i + j * j), 4, RoundingMode.UP));
            }
        }
        System.out.println(s);
    }

}
