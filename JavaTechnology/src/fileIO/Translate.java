package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Translate {
    public static void main(String[] args) {
        String input1 = "src\\fileIO\\inputFile1.txt";
        String input2 = "src\\fileIO\\inputFile2.txt";
        FileReader fileReader1;
        FileReader fileReader2;
        BufferedReader bufferedReader1;
        BufferedReader bufferedReader2;
        List<String> words=new ArrayList<>();
        Map<String,String> vocabulary = new HashMap<>();

        try{
            fileReader1 = new FileReader(input1);
            fileReader2 = new FileReader(input2);
            bufferedReader1 = new BufferedReader(fileReader1);
            bufferedReader2 = new BufferedReader(fileReader2);
            String temp = bufferedReader1.readLine();
            String[]t= temp.split(" | .|: ");
            Collections.addAll(words, t);
            bufferedReader1.close();

            while((temp=bufferedReader2.readLine())!=null){
                String[]str=temp.split("=");
                vocabulary.put(str[0],str[1]);
            }
            bufferedReader2.close();

        }
        catch (IOException e){
            e.printStackTrace();

        }
        for (String s:words){
            System.out.print(vocabulary.get(s.toLowerCase())+" ");
        }
        System.out.println();
        /*System.out.println(vocabulary);
        System.out.println(words);*/
    }
}
