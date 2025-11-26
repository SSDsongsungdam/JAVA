package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ImagePanel extends JPanel {
    private Image img;
    private int clipX = 0; // 클리핑 영역 시작 X
    private int clipY = 0; // 클리핑 영역 시작 Y
    private final int CLIP_SIZE = 50; // 50x50 크기

    public ImagePanel() {
        img = new ImageIcon("images/penguin.jpg").getImage(); // 이미지 경로 수정 가능

        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                switch (key) {
                    case KeyEvent.VK_UP:
                        clipY -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        clipY += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        clipX -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        clipX += 10;
                        break;
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 이미지 전체 그리기
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        // 클리핑 영역 설정
        g.setClip(clipX, clipY, CLIP_SIZE, CLIP_SIZE);

        // 클리핑된 영역 안에 이미지 다시 그리기
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

public class OpenChallenge extends JFrame {
    public OpenChallenge() {
        setTitle("Open Challenge 12");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel panel = new ImagePanel();
        add(panel);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        panel.requestFocus(); // 패널이 키 입력을 받을 수 있게 함
    }

    public static void main(String[] args) {
        new OpenChallenge();
    }
}
