package sungdam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Question10 extends JFrame {

    public Question10() {
        setTitle("블록 생성 및 드래깅 배치");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // 절대 위치 지정
        setSize(600, 500);
        setLocationRelativeTo(null);

        // 키 리스너 추가 (m 키 누를 때마다 블록 생성)
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                    createBlock();
                }
            }
        });

        setVisible(true);
        setFocusable(true);
        requestFocus();
    }

    // 블록 생성 메소드
    private void createBlock() {
        JLabel block = new JLabel();
        block.setOpaque(true);
        block.setBackground(randomColor());
        block.setBounds(100, 100, 80, 80);

        // 마우스로 드래그할 수 있도록 리스너 추가
        MouseAdapter ma = new MouseAdapter() {
            Point prevPt = null;

            @Override
            public void mousePressed(MouseEvent e) {
                prevPt = e.getPoint();
                block.getParent().setComponentZOrder(block, 0); // 클릭한 블록을 맨 위로
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                Point currPt = e.getLocationOnScreen();
                SwingUtilities.convertPointFromScreen(currPt, block.getParent());

                int dx = currPt.x - (block.getX() + prevPt.x);
                int dy = currPt.y - (block.getY() + prevPt.y);

                block.setLocation(block.getX() + dx, block.getY() + dy);
            }
        };

        block.addMouseListener(ma);
        block.addMouseMotionListener(ma);

        add(block);
        repaint();
    }

    // 랜덤 색상 생성
    private Color randomColor() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    public static void main(String[] args) {
        new Question10();
    }
}
