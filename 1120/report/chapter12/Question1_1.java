package sungdam;

import javax.swing.*;
import java.awt.*;

class ImagePanel1 extends JPanel {
    private Image img;

    public ImagePanel1() {
        setLayout(new FlowLayout());
        img = new ImageIcon("images/back.jpg").getImage();  // 프로젝트 images 폴더

        JButton btn = new JButton("Hide/Show"); // 기능 없음. 단순히 버튼만 표시
        add(btn);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 패널 크기에 맞춰 이미지 출력
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

public class Question1_1 extends JFrame {

    public Question1_1() {
        setTitle("이미지 그리기 연습 (1)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel1 panel = new ImagePanel1();
        add(panel);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question1_1();
    }
}