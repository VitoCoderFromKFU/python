package byteIO;

import java.io.*;

public class Task {
    public static void main(String[] args) throws IOException {
        byte[] buffer;
        FileInputStream fileInputStream;
        PrintWriter writerOutput;

        try {
            fileInputStream = new FileInputStream("E:\\git\\5 semestr\\5-semestr\\JavaTechnology\\src\\byteIO\\inputTask1.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new IOException(ex);
        }
        buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer, 0, buffer.length);

        try {
            writerOutput = new PrintWriter("E:\\git\\5 semestr\\5-semestr\\JavaTechnology\\src\\byteIO\\outputTask1.txt");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new IOException(ex);
        }

        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < buffer.length; i++) {
            System.out.print((char) buffer[i] + " \t");
        }

        int n = buffer.length;
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {

                if (buffer[j] == buffer[j + 1]) {
                    for (int k = j; k < buffer.length - 1; k++) {
                        buffer[k] = buffer[k + 1];
                    }
                    n--;
                }

                if (buffer[j] < buffer[j + 1]) {
                    byte temp = buffer[j + 1];
                    buffer[j + 1] = buffer[j];
                    buffer[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(buffer[i] + " ");
            writerOutput.print(buffer[i]);
            writerOutput.print(" ");
        }

        try {
            fileInputStream.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            throw new IOException(ex);
        }
        writerOutput.close();

    }

}
