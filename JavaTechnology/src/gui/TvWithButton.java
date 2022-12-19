package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.Arrays;


public class TvWithButton extends JFrame implements ActionListener {
    public  ChangeImage1 changeImage1 = new ChangeImage1();
    public  ChangeImage2 changeImage2 = new ChangeImage2();
    public  JPanel cardPanel = new JPanel();
    JButton button = new JButton("chanel");

    public TvWithButton() {
       // setSize(new Dimension(1920,1080));
        getContentPane().setBackground(new Color(204, 0, 0));
        getContentPane().add("Center", cardPanel);
        setPreferredSize(new Dimension(1400,950));


        cardPanel.setLayout(new CardLayout(10, 10));
        cardPanel.setBackground(new Color(176, 107, 3));
        //cardPanel.add("Day", new JLabel("Day", JLabel.CENTER));
        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(255, 75, 0));
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttons.add(button);
        button.addActionListener(this);
        this.imageTwo();
        //add("South", buttons);
        //setBounds(0, 0, 1400,100);
        //cardPanel.add(changeImage1);

        //cardPanel.add(new Day());
    }
    public  void imageOne(){
        cardPanel.add(changeImage1);
        cardPanel.setBackground(new Color(150, 96, 25));
        pack();
    }
    public  void imageTwo(){
        cardPanel.add(changeImage2);
        cardPanel.setBackground(new Color(5, 41, 91, 255));
        pack();
    }

    public static void main(String[] args) {
        TvWithButton tvWithButton = new TvWithButton();
        tvWithButton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tvWithButton.setVisible(true);
    }
    boolean flag = true;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == button) {
            if(flag){
                cardPanel.remove(changeImage2);
                cardPanel.add(changeImage1);
                cardPanel.setBackground(new Color(92, 255, 0));
                flag=false;
                //System.out.println(changeImage1.getComponents());

            }
            else{
                cardPanel.remove(changeImage1);
                cardPanel.add(changeImage2);
                cardPanel.setBackground(new Color(0, 42, 255, 255));
                flag = true;
            }

        }
    }

    public static class ChangeImage1 extends JComponent {
        public void paintComponent(Graphics graphics) {
            setSize(new Dimension(1920,1080));
            Graphics2D graphics2D = (Graphics2D) graphics;

            graphics2D.setColor(Color.WHITE);
            RoundRectangle2D.Double tv = new RoundRectangle2D.Double(40, 40, 1300, 800, 10, 10);
            RoundRectangle2D.Double tv1 = new RoundRectangle2D.Double(50, 50, 1280, 780, 0, 0);

            graphics2D.fillRect(40, 40, 10, 800);
            graphics2D.fillRect(40, 40, 1300, 10);
            graphics2D.fillRect(1330, 40, 10, 800);
            graphics2D.fillRect(40, 830, 1300, 10);
            graphics2D.draw(tv);
            graphics2D.draw(tv1);

            Ellipse2D ellipse2D = new Ellipse2D.Double(tv1.getCenterX() - 250, tv1.getCenterY() - 250, 500, 500);
            graphics2D.draw(ellipse2D);

            Ellipse2D eye1 = new Ellipse2D.Double(tv1.getCenterX() - 130, tv1.getCenterY() - 80, 60, 100);
            graphics2D.draw(eye1);
            Ellipse2D eye2 = new Ellipse2D.Double(tv1.getCenterX() + 80, tv1.getCenterY() - 80, 60, 100);
            graphics2D.draw(eye2);
            graphics2D.drawArc((int) tv1.getCenterX() - 40, (int) tv1.getCenterY() + 30, 80, 40, 0, -180);
            System.out.println(graphics2D.toString());
        }

    }
    public static class ChangeImage2 extends JComponent {
        public void paintComponent(Graphics graphics) {
            setSize(new Dimension(1920,1080));
            Graphics2D graphics2D = (Graphics2D) graphics;

            RoundRectangle2D.Double tv = new RoundRectangle2D.Double(40, 40, 1300, 800, 10, 10);
            RoundRectangle2D.Double tv1 = new RoundRectangle2D.Double(50, 50, 1280, 780, 0, 0);

            graphics2D.fillRect(40, 40, 10, 800);
            graphics2D.fillRect(40, 40, 1300, 10);
            graphics2D.fillRect(1330, 40, 10, 800);
            graphics2D.fillRect(40, 830, 1300, 10);
            graphics2D.draw(tv);
            graphics2D.draw(tv1);

            Ellipse2D ellipse2D = new Ellipse2D.Double(tv1.getCenterX() - 250, tv1.getCenterY() - 250, 500, 500);
            graphics2D.draw(ellipse2D);

            Ellipse2D eye1 = new Ellipse2D.Double(tv1.getCenterX() - 130, tv1.getCenterY() - 80, 60, 100);
            graphics2D.draw(eye1);
            Ellipse2D eye2 = new Ellipse2D.Double(tv1.getCenterX() + 80, tv1.getCenterY() - 80, 60, 100);
            graphics2D.draw(eye2);
            graphics2D.drawArc((int) tv1.getCenterX() - 40, (int) tv1.getCenterY() + 30, 80, 40, 0, -180);
        }

    }
}
