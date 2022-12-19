package socket;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    private static final int port = 8081;
    static BufferedImage img;
    static MyFrame frame;
    static DatagramPacket packet;
    static int id = 0;
    static boolean p = false;

    public static void main(String[] args) throws Exception {

        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buf = new byte[100000];

            packet = new DatagramPacket(buf, buf.length);
            frame = new MyFrame();

            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            while (true) {
                socket.receive(packet);
                decodePacket(packet);
            }
        }


    }

    private static void decodePacket(DatagramPacket packet) {
        try {
            img = ImageIO.read(new ByteArrayInputStream(packet.getData()));
            ImageIO.write(img, "jpeg", new File("src/socket/resources/result" + p + ".jpeg"));
            p = !p;

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
        //frame.update();

    }

    static class MyFrame extends JFrame implements ActionListener {
        static JLabel panel = new JLabel();

        MyFrame() {
            setPreferredSize(new Dimension(1400, 950));
            setSize(new Dimension(1400, 950));
            JButton button = new JButton("chanel");
            button.addActionListener(this);
            add("South",button);

            //setVisible(true);

            //pack();

        }

        public void update() {
            panel.setIcon(new ImageIcon("src/socket/resources/result" + p + ".jpeg"));
            add(panel);

            repaint();
            revalidate();
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (p) {
                p = false;
                update();
            } else {
                p = true;
                update();
            }
        }
    }
}


