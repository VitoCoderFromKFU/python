package exceptions;

import java.io.IOException;
import java.util.Scanner;

/*
Задача 1. Задаются границы диапазона в виде целых или вещественных чисел.
Вводим с консоли некоторое целое или вещественное число. Если вводимое
число не попадает в заданный интервал, то выбрасываем исключение.
При этом создаются собственные классы  исключений  на оба случая непопадания (меньше или больше).
Предусмотреть ввод 10 чисел в цикле с перехватом исключения.
 */
class BiggerException extends IOException {
    @Override
    public String toString() {
        return "number is bigger than max";
    }
}

class LowerException extends IOException {
    @Override
    public String toString() {
        return "number is lower than min";
    }
}

public class task1 {
    public static void main(String[] args) throws BiggerException, LowerException {
        double min = -10;
        double max = 10;
        Scanner in = new Scanner(System.in);
        double n = min + max / 2;
        for (int i = 0; i < 10; i++) {
            n = in.nextDouble();
            try {
                if (n > max) {
                    throw new BiggerException();
                } else if (n < min) {
                    throw new LowerException();
                }
            } catch (BiggerException bexc ) {
                System.out.println(bexc.toString());
            } catch (LowerException lexc) {
                System.out.println(lexc.toString());
            }
        }
    }
}
