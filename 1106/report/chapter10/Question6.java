package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Question6 extends JFrame {
    private JPanel westPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private JLabel[] numbers = new JLabel[10];
    private Color selectedColor = Color.BLACK;
    private Random rand = new Random();

    public Question6() {
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // ===== WEST 영역 =====
        westPanel.setLayout(new GridLayout(11, 1)); // 11개의 버튼 세로 배치
        add(westPanel, BorderLayout.WEST);

        // 다양한 색상 배열
        Color[] colors = {Color.RED, Color.GRAY, Color.BLUE, Color.YELLOW, Color.CYAN,
                          Color.DARK_GRAY, Color.PINK, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.LIGHT_GRAY};

        // 11개 버튼 생성
        for (Color c : colors) {
            JButton btn = new JButton();
            btn.setBackground(c);
            btn.addActionListener(e -> {
                selectedColor = c; // 클릭한 버튼의 색상 저장
                for (JLabel num : numbers) {
                    num.setForeground(selectedColor); // 숫자 글자색 변경
                }
            });
            westPanel.add(btn);
        }

        // ===== CENTER 영역 =====
        centerPanel.setLayout(null); // 절대 위치 배치
        centerPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                randomizeNumbers(); // CENTER 클릭 → 숫자 재배치
            }
        });
        add(centerPanel, BorderLayout.CENTER);

        // 0~9 JLabel 생성
        for (int i = 0; i < 10; i++) {
            numbers[i] = new JLabel(Integer.toString(i));
            numbers[i].setSize(20, 20);
            numbers[i].setForeground(selectedColor);
            centerPanel.add(numbers[i]);
        }

        randomizeNumbers(); // 초기 배치

        setVisible(true);
    }

    // 숫자 랜덤 배치 메서드
    private void randomizeNumbers() {
        for (JLabel num : numbers) {
            int x = rand.nextInt(150) + 50; // x: 50~200
            int y = rand.nextInt(150) + 50; // y: 50~200
            num.setLocation(x, y);
        }
        centerPanel.repaint();
    }

    public static void main(String[] args) {
        new Question6();
    }
}
