package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question7 extends JFrame {
    public Question7() {
        setTitle("자바 스윙 계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(new BorderLayout(5, 5));

        // 🔹 상단 패널 (NORTH)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("수식"));
        JTextField tf = new JTextField(15);
        topPanel.add(tf);
        add(topPanel, BorderLayout.NORTH);

        // 🔹 중앙 패널 (CENTER)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5행 4열 버튼 배치

        String[] buttonNames = {
            "C", "UN", "BK", "/", 
            "7", "8", "9", "x", 
            "4", "5", "6", "-", 
            "1", "2", "3", "+", 
            "0", ".", "=", "%"
        };

        for (String name : buttonNames) {
            JButton btn = new JButton(name);
            centerPanel.add(btn);
        }

        add(centerPanel, BorderLayout.CENTER);

        // 🔹 하단 패널 (SOUTH)
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setBackground(new Color(230, 230, 180));
        bottomPanel.add(new JLabel("계산 결과"));
        JTextField resultField = new JTextField(15);
        bottomPanel.add(resultField);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question7();
    }
}
