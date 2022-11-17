package arrays;

import java.util.Scanner;

public class MagicSquare {
    //возвращать суммы и в отдельной функции проверить, равны ли они

    static boolean checkMagic(int[][] m) {
        int sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        int sum1 = 0;
        for (int i = 0; i < m.length; i++) {
            sum1 += m[i][m.length - i - 1];
        }
        if (sum != sum1)
            return false;

        int rowSum = 0;
        for (int i = 0; i < m.length; i++) {
            rowSum = 0;
            for (int j = 0; j < m.length; j++) {
                rowSum += m[i][j];
            }
            if (rowSum != sum)
                return false;
        }
        int colSum = 0;
        for (int j = 0; j < m.length; j++) {
            colSum = 0;
            for (int i = 0; i < m.length; i++) {
                colSum += m[i][j];
            }
            if (colSum != sum)
                return false;
        }

        return true;
    }

    static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void rotateMatrix(int[][] m) {
        int temp = 0;
        for (int i = 0; i < m.length / 2; i++) {
            for (int j = i; j < m.length - i - 1; j++) {
                temp = m[i][j];
                m[i][j] = m[j][m.length - i - 1];
                m[j][m.length - i - 1] = m[m.length - i - 1][m.length - j - 1];
                m[m.length - i - 1][m.length - j - 1] = m[m.length - j - 1][i];
                m[m.length - j - 1][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = in.nextInt();
        }
/*
4
4 5 14 11
1 15 8 10
16 2 9 7
13 12 3 6
 */
        printMatrix(matrix);
        if (checkMagic(matrix)) {
            rotateMatrix(matrix);
            printMatrix(matrix);
        }


    }
}


