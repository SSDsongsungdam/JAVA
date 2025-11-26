package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ImagePanel2 extends JPanel {
    private Image img;
    private boolean isVisible = true; // 이미지 보임/숨김 제어 변수

    public ImagePanel2() {
        setLayout(new FlowLayout());
        img = new ImageIcon("images/back.jpg").getImage();

        JButton btn = new JButton("Hide/Show");
        add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isVisible = !isVisible;  // 보임/숨김 토글
                repaint();               // 화면 갱신
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (isVisible) {
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

public class Question1_2 extends JFrame {

    public Question1_2() {
        setTitle("이미지 그리기 연습 (2)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel2 panel = new ImagePanel2();
        add(panel);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question1_2();
    }
}