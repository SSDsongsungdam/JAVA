package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question9 extends JFrame {
    public Question9() {
        setTitle("랜덤한 별을 가진 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout(5, 5));

        // 🔹 NORTH 패널
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("별 개수"));
        JTextField textField = new JTextField(5);
        northPanel.add(textField);
        JButton makeButton = new JButton("별 만들기");
        northPanel.add(makeButton);
        add(northPanel, BorderLayout.NORTH);

        // 🔹 CENTER 패널 (별 표시 영역)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null); // 배치관리자 없음
        centerPanel.setBackground(Color.WHITE);

        // 15개의 별(*) JLabel을 랜덤한 위치에 생성
        for (int i = 0; i < 15; i++) {
            JLabel star = new JLabel("*");
            int x = (int)(Math.random() * 280);
            int y = (int)(Math.random() * 180);
            star.setSize(20, 20);
            star.setLocation(x, y);
            centerPanel.add(star);
        }

        add(centerPanel, BorderLayout.CENTER);

        // 🔹 SOUTH 패널
        JPanel southPanel = new JPanel();
        JButton refreshButton = new JButton("Refresh");
        JButton exitButton = new JButton("Exit");
        southPanel.add(refreshButton);
        southPanel.add(exitButton);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question9();
    }
}
