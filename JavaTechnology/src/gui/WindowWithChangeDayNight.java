package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class WindowWithChangeDayNight extends JFrame implements ActionListener {

    Day day = new Day();
    Night night = new Night();
    JPanel cardPanel = new JPanel();
    JButton dayButton = new JButton("Set Day");
    JButton nightButton = new JButton("Set Night");

    public WindowWithChangeDayNight() {
        cardPanel.setLayout(new CardLayout(10, 10));
        cardPanel.setBackground(new Color(176, 107, 3));
        //cardPanel.add("Day", new JLabel("Day", JLabel.CENTER));
        JPanel buttons = new JPanel();
        buttons.setBackground(new Color(190, 0, 0));
        buttons.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttons.add(dayButton);
        dayButton.addActionListener(this);
        buttons.add(nightButton);
        nightButton.addActionListener(this);
        getContentPane().add("Center", cardPanel);
        getContentPane().add("South", buttons);
        setBounds(0, 0, 1420, 1000);
        //cardPanel.add(new Day());
    }

    public static void main(String[] args) {
        WindowWithChangeDayNight windowWithChangeDayNight = new WindowWithChangeDayNight();
        windowWithChangeDayNight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowWithChangeDayNight.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dayButton) {
            cardPanel.remove(night);
            cardPanel.add(day);
            cardPanel.setBackground(new Color(243, 207, 0));
        }
        if (e.getSource() == nightButton) {
            cardPanel.remove(day);
            cardPanel.add(night);
            cardPanel.setBackground(new Color(176, 107, 3));
        }
    }

    static final class Day extends JComponent {
        public void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            RoundRectangle2D.Double window1 = new RoundRectangle2D.Double(40, 40, 1300, 800, 10, 10);
            RoundRectangle2D.Double window2 = new RoundRectangle2D.Double(50, 50, 1280, 780, 0, 0);
            graphics2D.setColor(new Color(176, 74, 0));
            Rectangle2D.Double m = new Rectangle2D.Double(1280 / 2 + 50, 50, 20, 780);
            graphics2D.fill(m);
            Line2D.Double line = new Line2D.Double(1280 / 2 + 50 + 10, 50 - 10, 1280 / 2 + 50 + 10, 780 + 60);
            graphics2D.fillRect(40, 40, 10, 800);
            graphics2D.fillRect(40, 40, 1300, 10);
            graphics2D.fillRect(1330, 40, 10, 800);
            graphics2D.fillRect(40, 830, 1300, 10);
            graphics2D.draw(window1);
            graphics2D.draw(window2);
            graphics2D.draw(m);
            graphics2D.setColor(Color.black);
            graphics2D.draw(line);

            graphics2D.setColor(new Color(122, 182, 255));
            graphics2D.fillRect(50, 50, 1280 / 2, 780);
            graphics2D.fillRect(50 + 1280 / 2 + 20, 50, 1280 / 2 - 20, 780);

            graphics2D.setColor(Color.yellow);
            graphics2D.drawArc(-200, -200, 500, 500, 0, -90);
            graphics2D.fillArc(-200, -200, 500, 500, 0, -90);

            graphics2D.setColor(new Color(133, 53, 0, 255));
            Rectangle2D.Double g1 = new Rectangle2D.Double(1280 - 1280 / 4, 780 - 120, 120, 170);
            graphics2D.draw(g1);
            graphics2D.fill(g1);


            graphics2D.setColor(new Color(45, 162, 5, 255));
            Rectangle2D.Double g2 = new Rectangle2D.Double(1280 - 1280 / 4 + 60, 780 - 200, 8, 80);
            graphics2D.draw(g2);
            graphics2D.fill(g2);

            graphics2D.setColor(new Color(211, 14, 14, 255));
            Ellipse2D s = new Ellipse2D.Double(1280 - 1280 / 4 + 60 - 21, 780 - 200 - 30, 50, 50);
            graphics2D.draw(s);
            graphics2D.fill(s);
        }

    }

    static final class Night extends JComponent {
        public void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            RoundRectangle2D.Double window1 = new RoundRectangle2D.Double(40, 40, 1300, 800, 10, 10);
            RoundRectangle2D.Double window2 = new RoundRectangle2D.Double(50, 50, 1280, 780, 0, 0);
            graphics2D.setColor(new Color(176, 74, 0));
            Rectangle2D.Double m = new Rectangle2D.Double(1280 / 2 + 50, 50, 20, 780);
            graphics2D.fill(m);
            Line2D.Double line = new Line2D.Double(1280 / 2 + 50 + 10, 50 - 10, 1280 / 2 + 50 + 10, 780 + 60);
            graphics2D.fillRect(40, 40, 10, 800);
            graphics2D.fillRect(40, 40, 1300, 10);
            graphics2D.fillRect(1330, 40, 10, 800);
            graphics2D.fillRect(40, 830, 1300, 10);
            graphics2D.draw(window1);
            graphics2D.draw(window2);
            graphics2D.draw(m);
            graphics2D.setColor(Color.black);
            graphics2D.draw(line);

            graphics2D.setColor(new Color(13, 0, 143));
            graphics2D.fillRect(50, 50, 1280 / 2, 780);
            graphics2D.fillRect(50 + 1280 / 2 + 20, 50, 1280 / 2 - 20, 780);
            graphics2D.setColor(new Color(138, 138, 138));
            graphics2D.drawArc(-200, -200, 500, 500, 0, -90);
            graphics2D.fillArc(-200, -200, 500, 500, 0, -90);

            graphics2D.setColor(new Color(133, 53, 0, 255));
            Rectangle2D.Double g1 = new Rectangle2D.Double(1280 - 1280 / 4, 780 - 120, 120, 170);
            graphics2D.draw(g1);
            graphics2D.fill(g1);

            graphics2D.setColor(new Color(45, 162, 5, 255));
            Rectangle2D.Double g2 = new Rectangle2D.Double(1280 - 1280 / 4 + 60, 780 - 200, 8, 80);
            graphics2D.draw(g2);
            graphics2D.fill(g2);

            graphics2D.setColor(new Color(141, 9, 9, 255));
            Ellipse2D s = new Ellipse2D.Double(1280 - 1280 / 4 + 60 - 21, 780 - 200 - 30, 50, 50);
            graphics2D.draw(s);
            graphics2D.fill(s);
        }
    }
}