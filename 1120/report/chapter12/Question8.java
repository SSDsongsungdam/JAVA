package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

// 원 정보를 저장하는 클래스
class Circle {
    int x, y;   // 중심 좌표
    int r;      // 반지름

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

class CirclePanel extends JPanel {

    private Vector<Circle> v = new Vector<>();
    private int startX, startY;   // 마우스를 처음 누른 지점 (중심)
    private int tempR = 0;        // 드래그 중 임시 반지름
    private boolean dragging = false;

    public CirclePanel() {

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
                dragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
                int endX = e.getX();
                int endY = e.getY();

                int r = (int) Math.sqrt(Math.pow(endX - startX, 2) +
                        Math.pow(endY - startY, 2));

                v.add(new Circle(startX, startY, r));
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    int curX = e.getX();
                    int curY = e.getY();
                    tempR = (int) Math.sqrt(Math.pow(curX - startX, 2) +
                            Math.pow(curY - startY, 2));
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.MAGENTA);

        // 저장된 모든 원 그리기
        for (Circle c : v) {
            g.drawOval(c.x - c.r, c.y - c.r, c.r * 2, c.r * 2);
        }

        // 드래그 중이면 임시 원 그리기
        if (dragging) {
            g.drawOval(startX - tempR, startY - tempR, tempR * 2, tempR * 2);
        }
    }
}

public class Question8 extends JFrame {

    public Question8() {
        setTitle("마우스로 원 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new CirclePanel());

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question8();
    }
}