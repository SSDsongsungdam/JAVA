package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Question5 extends JFrame {
    private JLabel label = new JLabel("C");
    private Random random = new Random();

    public Question5() {
        setTitle("클릭 연습 응용 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(null); // 배치관리자 제거 → 위치 지정 가능

        // JLabel 초기 설정
        label.setSize(20, 20);
        label.setLocation(100, 100);
        add(label);

        // JLabel 클릭 이벤트
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // 랜덤 위치 계산 (프레임 크기 고려)
                int x = random.nextInt(getWidth() - label.getWidth());
                int y = random.nextInt(getHeight() - label.getHeight() - 30); // 타이틀바 높이 보정
                label.setLocation(x, y);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question5();
    }
}
