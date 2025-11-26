package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question10 extends JFrame {
    public Question10() {
        setTitle("그래픽 이미지 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new ImagePanel());

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class ImagePanel extends JPanel {
        Image img;

        public ImagePanel() {
            // 이미지를 단 한 번만 로딩
            img = new ImageIcon("back.jpg").getImage(); 
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int w = getWidth();
            int h = getHeight();

            int gap = 10;  // 10px 간격

            // 4등분 크기 계산
            int pw = (w - gap) / 2;   // 패널에서 각 이미지의 폭
            int ph = (h - gap) / 2;   // 패널에서 각 이미지의 높이

            int imgW = img.getWidth(this);
            int imgH = img.getHeight(this);

            // 이미지의 4등분 영역
            int halfW = imgW / 2;
            int halfH = imgH / 2;

            // 상좌
            g.drawImage(img, 
                    0, 0, pw, ph,            // 목적지 영역
                    0, 0, halfW, halfH,      // 원본 이미지 영역
                    this);

            // 상우
            g.drawImage(img, 
                    pw + gap, 0, pw * 2 + gap, ph, 
                    halfW, 0, imgW, halfH, 
                    this);

            // 하좌
            g.drawImage(img, 
                    0, ph + gap, pw, ph * 2 + gap,
                    0, halfH, halfW, imgH,
                    this);

            // 하우
            g.drawImage(img, 
                    pw + gap, ph + gap, pw * 2 + gap, ph * 2 + gap,
                    halfW, halfH, imgW, imgH,
                    this);
        }
    }

    public static void main(String[] args) {
        new Question10();
    }
}
