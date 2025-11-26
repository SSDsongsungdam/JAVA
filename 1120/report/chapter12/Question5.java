package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel {

    private Image img;
    private int imgX = 10;
    private int imgY = 10;

    private int width;   // 원본 이미지 폭
    private int height;  // 원본 이미지 높이

    private double scale = 1.0; // 확대/축소 비율

    public MyPanel() {
        img = new ImageIcon("images/apple.jpg").getImage();

        // 이미지 원본 크기 구하기 (문제의 힌트 #4)
        width = img.getWidth(this);
        height = img.getHeight(this);

        // KeyListener 등록
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                // '+' 입력 → 10% 확대
                if (e.getKeyChar() == '+') {
                    scale += 0.1;
                }

                // '-' 입력 → 10% 축소
                else if (e.getKeyChar() == '-') {
                    scale -= 0.1;

                    // 너무 작아지는 것 방지
                    if (scale < 0.1) {
                        scale = 0.1;
                    }
                }

                repaint(); // 다시 그리기
            }
        });

        setFocusable(true); // 키 이벤트를 받을 수 있도록
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 현재 비율로 이미지 크기 조정하여 그리기
        int newW = (int)(width * scale);
        int newH = (int)(height * scale);

        g.drawImage(img, imgX, imgY, newW, newH, this);
    }
}

public class Question5 extends JFrame {

    public Question5() {
        setTitle("그래픽 이미지 확대 축소 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel panel = new MyPanel();
        setContentPane(panel);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);

        panel.requestFocus(); // key 이벤트를 받기 위해 포커스 요청
    }

    public static void main(String[] args) {
        new Question5();
    }
}