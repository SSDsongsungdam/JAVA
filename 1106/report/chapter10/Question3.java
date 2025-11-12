package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question3 extends JFrame {
    private JLabel label = new JLabel("Love Java", SwingConstants.CENTER);
    private String text = "Love Java";

    public Question3() {
        setTitle("Left 키로 문자열 회전");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        label.setFont(new Font("Gulim", Font.BOLD, 24));
        c.add(label, BorderLayout.CENTER);

        // 🔹 JLabel이 키 이벤트를 받을 수 있도록 포커스 설정
        label.setFocusable(true);
        label.requestFocus();

        // 🔹 키 이벤트 리스너 등록
        label.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    // 문자열을 왼쪽으로 한 칸 회전
                    text = text.substring(1) + text.charAt(0);
                    label.setText(text);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question3();
    }
}
