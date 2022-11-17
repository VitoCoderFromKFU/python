package bigNumbers;

import java.math.BigInteger;

public class Fibbonachi {

    static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.TWO))
            return BigInteger.ONE;
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    }

    public static void main(String[] args) {
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i <= 100; i++) {
            sum = sum.add(fib(BigInteger.valueOf(i)));
        }
        System.out.println(sum);
        System.out.println(fib(BigInteger.valueOf(10)));
    }


}