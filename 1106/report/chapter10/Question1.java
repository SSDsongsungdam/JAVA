package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question1 extends JFrame {
    private JLabel label;

    public Question1() {
        setTitle("마우스 올리기 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        label = new JLabel("Love Java");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        add(label);

        // 🔹 마우스 이벤트 추가
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("사랑해 자바");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Love Java");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question1();
    }
}
