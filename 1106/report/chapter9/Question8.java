package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question8 extends JFrame {
    public Question8() {
        setTitle("16장의 카드의 뒷면에 숨겨진 이미지 찾기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 400);
        setLayout(new BorderLayout(5, 5));

        // 🔹 NORTH 패널
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.YELLOW);
        northPanel.add(new JLabel("숨겨진 이미지 찾기"));
        add(northPanel, BorderLayout.NORTH);

        // 🔹 WEST & EAST 빈 JLabel (초록색 영역의 좌우 여백용)
        add(new JLabel(" "), BorderLayout.WEST);
        add(new JLabel(" "), BorderLayout.EAST);

        // 🔹 CENTER 패널 (16개의 JLabel 카드)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(4, 4, 5, 5));
        centerPanel.setBackground(Color.GREEN);

        for (int i = 0; i < 16; i++) {
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            label.setOpaque(true);
            label.setBackground(Color.GREEN);
            label.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            centerPanel.add(label);
        }

        add(centerPanel, BorderLayout.CENTER);

        // 🔹 SOUTH 패널 (버튼)
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.YELLOW);
        JButton startButton = new JButton("실행 시작");
        southPanel.add(startButton);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question8();
    }
}
