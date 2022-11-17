package exceptions;
/*
Задача 2. Написать функцию вычисления модуля разности двух чисел.
При появлении отрицательного значения, стоящего под модулем, выбросить собственное исключение.
 */

import java.io.IOException;
import java.util.Scanner;
class InputException extends IOException{
    @Override
    public String toString() {
        return "negative";
    }
}
public class task2 {
    static double abs(double a, double b){
        try {
            if (a - b >= 0) {
                return a - b;
            }
            else{
                throw new InputException();
            }
        }catch (InputException inputException){
            System.out.println(inputException.toString());
            return -1;
        }
    }

    public static void main(String[] args) throws InputException {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            System.out.println(abs(a,b));
        }


    }
}
