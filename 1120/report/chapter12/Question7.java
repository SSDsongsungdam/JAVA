package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class PolyPanel extends JPanel {

    private ArrayList<Point> points = new ArrayList<>();

    public PolyPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                points.add(e.getPoint());
                repaint();  // 새로운 선을 그리기 위해 갱신
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 점이 하나면 아무것도 그릴 필요 없음
        if (points.size() < 2)
            return;

        g.setColor(Color.MAGENTA);

        // 이전 점과 현재 점을 연결
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}

public class Question7 extends JFrame {

    public Question7() {
        setTitle("마우스로 페다각형 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new PolyPanel());

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question7();
    }
}