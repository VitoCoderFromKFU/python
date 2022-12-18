package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;


public class TvWithButton extends JFrame implements ActionListener {
    ChangeImage1 changeImage1 = new ChangeImage1();
    ChangeImage2 changeImage2 = new ChangeImage2();
    JPanel cardPanel = new JPanel();
    JButton button = new JButton("chanel");

    public TvWithButton() {
        cardPanel.setLayout(new CardLayout(10, 10));
        cardPanel.setBackground(new Color(176, 107, 3));
        //cardPanel.add("Day", new JLabel("Day", JLabel.CENTER));
        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(255, 75, 0));
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttons.add(button);
        button.addActionListener(this);
        getContentPane().add("Center", cardPanel);
        getContentPane().add("South", buttons);
        setBounds(0, 0, 1420, 1000);
        //cardPanel.add(new Day());
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
                cardPanel.setBackground(new Color(0, 0, 0));
                flag=false;
            }
            else{
                cardPanel.remove(changeImage1);
                cardPanel.add(changeImage2);
                cardPanel.setBackground(new Color(255, 255, 255, 255));
                flag = true;
            }

        }
    }

    static class ChangeImage1 extends JComponent {
        public void paintComponent(Graphics graphics) {
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
        }

    }
    static class ChangeImage2 extends JComponent {
        public void paintComponent(Graphics graphics) {
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
