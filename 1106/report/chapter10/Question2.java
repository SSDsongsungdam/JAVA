package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question2 extends JFrame {
    private JLabel label = new JLabel("드래깅 중");

    public Question2() {
        setTitle("드래깅동안 배경색 변경");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        Container c = getContentPane();
        c.setBackground(Color.GREEN); // 기본 배경색

        c.setLayout(new FlowLayout());
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        c.add(label);

        // 🔹 마우스 드래그 이벤트 처리
        c.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                c.setBackground(Color.YELLOW); // 드래깅 중 노란색
            }
        });

        // 🔹 마우스 릴리즈 이벤트 처리 (드래그 끝났을 때)
        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                c.setBackground(Color.GREEN); // 원래 색으로 복귀
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question2();
    }
}
