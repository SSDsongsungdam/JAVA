package sungdam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Question9 extends JFrame {

    private JLabel label;
    private int fontSize = 20; // 기본 폰트 크기

    public Question9() {
        setTitle("마우스 휠을 굴려 폰트 크기 조절하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Love Java");
        label.setFont(new Font("Arial", Font.BOLD, fontSize));
        add(label);

        // 마우스 휠 리스너 추가
        label.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int n = e.getWheelRotation(); // 위로 굴리면 음수, 아래로 굴리면 양수
                if (n < 0) { // 위로 굴렸을 때 - 글자 작아짐
                    fontSize = Math.max(5, fontSize - 5); // 5 이하로는 줄어들지 않음
                } else { // 아래로 굴렸을 때 - 글자 커짐
                    fontSize += 5;
                }
                label.setFont(new Font("Arial", Font.BOLD, fontSize));
            }
        });

        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question9();
    }
}
