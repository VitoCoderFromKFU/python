package socketTry2;

import java.io.*;
import java.net.*;
import java.util.*;


public class Server {

    public static void main(String[] args) {

        ServerSocket ser = null;
        Socket soc = null;
        TvWithButton tvWithButton = null;

        try {
            ser = new ServerSocket(8020);
            soc = ser.accept();
            InputStream o = soc.getInputStream();
            ObjectInput s = new ObjectInputStream(o);
            //str = (String) s.readObject();
            tvWithButton = (TvWithButton) s.readObject();
            s.close();
            tvWithButton.setVisible(true);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error during serialization");
            System.exit(1);
        }
    }
}