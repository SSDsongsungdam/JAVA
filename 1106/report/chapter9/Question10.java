package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question10 extends JFrame {

    public Question10() {
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // 🔹 WEST 패널 (GridLayout 사용)
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(10, 1)); // 10행 1열
        Color[] colors = {
            Color.RED, Color.GRAY, Color.BLUE, Color.YELLOW, Color.CYAN,
            Color.DARK_GRAY, Color.PINK, Color.GREEN, Color.LIGHT_GRAY, new Color(128, 0, 128)
        };
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton();
            btn.setBackground(colors[i]);
            westPanel.add(btn);
        }
        add(westPanel, BorderLayout.WEST);

        // 🔹 CENTER 패널 (배치관리자 없음)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.WHITE);

        // 0~9 숫자를 JLabel로 랜덤한 위치에 출력
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(Integer.toString(i));
            label.setSize(20, 20);
            label.setForeground(Color.RED);
            int x = (int)(Math.random() * 150) + 50;  // 50~200
            int y = (int)(Math.random() * 150) + 50;  // 50~200
            label.setLocation(x, y);
            centerPanel.add(label);
        }
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question10();
    }
}
