package gui;

import javax.swing.*;
import java.awt.*;

import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/*
Часть 1. Нарисовать телевизор, на экране изображение в виде смайлика
 */
public class TVWithSmile {

    public static void main(String[] args) {
        Frame frame = new Frame();
    }
}

class Frame extends JFrame {
    public Frame() {
        setSize(1420, 920);
        setTitle("TV");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(new MyComponent());
        setVisible(true);

    }

    class MyComponent extends JComponent {
        public void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            RoundRectangle2D.Double tv = new RoundRectangle2D.Double(40, 40, 1300, 800,10,10);
            RoundRectangle2D.Double tv1 = new RoundRectangle2D.Double(50, 50, 1280, 780,0,0);

            /*
            graphics2D.setColor(Color.black);
            graphics2D.fill(tv);

            graphics2D.setColor(Color.white);
            graphics2D.fill(tv1);
            */
            graphics2D.fillRect(40, 40, 10, 800);
            graphics2D.fillRect(40, 40, 1300, 10);
            graphics2D.fillRect(1330, 40, 10, 800);
            graphics2D.fillRect(40, 830, 1300, 10);
            graphics2D.draw(tv);
            graphics2D.draw(tv1);

            Ellipse2D ellipse2D = new Ellipse2D.Double(tv1.getCenterX()- 250, tv1.getCenterY()- 250, 500, 500);
            graphics2D.draw(ellipse2D);

            Ellipse2D eye1 = new Ellipse2D.Double(tv1.getCenterX() - 130, tv1.getCenterY()-80, 60, 100);
            graphics2D.draw(eye1);
            Ellipse2D eye2 = new Ellipse2D.Double(tv1.getCenterX() + 80, tv1.getCenterY()-80, 60, 100);
            graphics2D.draw(eye2);
            graphics2D.drawArc((int)tv1.getCenterX()-40,(int)tv1.getCenterY()+30,80,40,0,-180);

        }

    }
}

