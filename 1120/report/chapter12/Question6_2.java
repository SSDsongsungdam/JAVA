package sungdam;

import javax.swing.*;
import java.awt.*;

class DiamondPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth();
        int h = getHeight();

        int cx = w / 2;   // 중심점
        int cy = h / 2;

        int size = Math.min(w, h) / 20; // 첫 마름모의 반지름 크기

        for (int i = 0; i < 10; i++) {
            int r = size + i * (size);  // 점점 커지는 마름모 반경

            int[] x = {cx, cx + r, cx, cx - r};
            int[] y = {cy - r, cy, cy + r, cy};

            g.drawPolygon(x, y, 4);
        }
    }
}

public class Question6_2 extends JFrame {

    public Question6_2() {
        setTitle("그래픽 다각형 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new DiamondPanel());

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question6_2();
    }
}