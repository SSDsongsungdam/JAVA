package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel {

    private Image bgImage;
    private int x = -100; // 원의 초기 위치 (화면에 안 보이도록)
    private int y = -100;
    private final int R = 20; // 반지름 20

    public MyPanel() {
        bgImage = new ImageIcon("images/back.jpg").getImage();

        // 마우스 드래그 이벤트
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();  // 원 새 위치로 그리기
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 배경 이미지 채우기
        g.drawImage(bgImage, 0, 0, getWidth(), getHeight(), this);

        // 원 그리기 (초록색)
        g.setColor(Color.GREEN);
        g.fillOval(x - R, y - R, R * 2, R * 2);
    }
}

public class Question2 extends JFrame {

    public Question2() {
        setTitle("이미지 위에 원 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel panel = new MyPanel();
        setContentPane(panel);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question2();
    }
}