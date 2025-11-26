package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ImageDragPanel extends JPanel {

    private JLabel imageLabel;
    private ImageIcon icon;

    private int mouseX, mouseY;   // 마우스 클릭 시 위치 저장

    public ImageDragPanel() {
        setLayout(null);   // 절대 위치 배치

        icon = new ImageIcon("images/apple.jpg");
        imageLabel = new JLabel(icon);

        // 이미지 초기 위치 설정
        imageLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
        imageLabel.setLocation(150, 150);

        add(imageLabel);

        // 마우스 눌렀을 때 (클릭 위치 저장)
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();   // 라벨 내부에서 클릭한 x
                mouseY = e.getY();   // 라벨 내부에서 클릭한 y
            }
        });

        // 마우스 드래그 시 라벨 이동
        imageLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // 드래그한 현재 좌표 - 클릭한 위치 = 이동 좌표
                int x = e.getXOnScreen() - getLocationOnScreen().x - mouseX;
                int y = e.getYOnScreen() - getLocationOnScreen().y - mouseY;

                imageLabel.setLocation(x, y);
            }
        });
    }
}

public class Question3 extends JFrame {

    public Question3() {
        setTitle("이미지 레이블 드래깅 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageDragPanel p = new ImageDragPanel();
        setContentPane(p);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question3();
    }
}