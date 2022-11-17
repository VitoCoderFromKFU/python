package bigNumbers;

import java.math.BigInteger;

public class Factorial {
    static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else
            return n.multiply(factorial((n.subtract(BigInteger.ONE))));
    }


    public static void main(String[] args) {
        String s = "500";
        BigInteger n = new BigInteger(s);
        System.out.println(factorial(n));
    }

}
