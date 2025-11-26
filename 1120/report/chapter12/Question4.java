package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel {

    private Image img;
    private int imgX = 50;  // 이미지 시작 위치
    private int imgY = 50;

    private int width;   // 이미지 폭
    private int height;  // 이미지 높이

    private int offsetX; // 마우스 클릭 시 이미지 내 상대 좌표
    private int offsetY;
    private boolean dragging = false;

    public MyPanel() {

        img = new ImageIcon("images/back.jpg").getImage();

        // 이미지 원본 크기 얻기
        width = img.getWidth(this);
        height = img.getHeight(this);

        // 마우스를 클릭하면 이미지 내부인지 확인하고 드래그 시작
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int mx = e.getX();
                int my = e.getY();

                // 이미지 영역 안에서 눌렀는지 확인
                if (mx >= imgX && mx <= imgX + width &&
                    my >= imgY && my <= imgY + height) {

                    dragging = true;
                    offsetX = mx - imgX;
                    offsetY = my - imgY;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
            }
        });

        // 드래그 중이면 이미지 위치 이동
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging) {
                    imgX = e.getX() - offsetX;
                    imgY = e.getY() - offsetY;
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 이미지 그리기
        g.drawImage(img, imgX, imgY, this);
    }
}


public class Question4 extends JFrame {

    public Question4() {
        setTitle("이미지 드래그 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyPanel panel = new MyPanel();
        setContentPane(panel);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question4();
    }
}