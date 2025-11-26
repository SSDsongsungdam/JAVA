package sungdam;

import javax.swing.*;
import java.awt.*;

class GridPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        int cellW = w / 10;
        int cellH = h / 10;

        // 세로선 11개
        for (int i = 0; i <= 10; i++) {
            int x = i * cellW;
            g.drawLine(x, 0, x, h);
        }

        // 가로선 11개
        for (int i = 0; i <= 10; i++) {
            int y = i * cellH;
            g.drawLine(0, y, w, y);
        }
    }
}

public class Question6_1 extends JFrame {

    public Question6_1() {
        setTitle("격자 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new GridPanel());

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question6_1();
    }
}