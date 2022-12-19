
package socket;

import gui.TvWithButton;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private static final String host = "localhost";
    private static final int port = 8081;
    static TvWithButton tv = new TvWithButton();

    public static void main(String[] args) throws Exception {
        try (DatagramSocket socket = new DatagramSocket()) {
            tv.imageOne();
            DatagramPacket packet1 = createPacket();
            socket.send(packet1);

            tv.imageTwo();
            DatagramPacket packet2 = createPacket();
            socket.send(packet2);
        }

    }
    public static BufferedImage getScreenShot(
            Component component) {
        component.setPreferredSize(new Dimension(1400,950));

        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        component.paint(image.getGraphics());
        return image;
    }
    private static DatagramPacket createPacket() {
        try {
            BufferedImage img = getScreenShot(tv.getContentPane());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            ImageIO.write(img, "jpeg", baos);
            baos.flush();

            byte[] buffer = baos.toByteArray();
            InetAddress IPAddress = InetAddress.getByName(host);

            return new DatagramPacket(buffer, buffer.length, IPAddress, port);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}


