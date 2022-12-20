package socketTry2;

import java.io.*;
import java.net.*;
import java.util.*;


public class Client {

    public static void main(String[] args) {


        try {
            Socket soc = new Socket(InetAddress.getLocalHost(), 8020);

            OutputStream o = soc.getOutputStream();
            ObjectOutput s = new ObjectOutputStream(o);

            s.writeObject(new TvWithButton());
            s.flush();
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        }
    }
}