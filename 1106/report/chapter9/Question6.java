package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question6 extends JFrame {
    public Question6() {
        setTitle("배치관리자 없는 컨테이너");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);

        // 배치관리자 제거 (직접 위치 설정 가능)
        Container c = getContentPane();
        c.setLayout(null);

        // JLabel 20개 생성
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel();
            label.setSize(10, 10); // 크기 10x10

            // 랜덤한 RGB 색상 생성
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);
            label.setOpaque(true); // 배경색이 보이도록 설정
            label.setBackground(new Color(r, g, b));

            // 랜덤한 위치 설정 (10~250 범위 내)
            int x = (int)(Math.random() * 240) + 10;
            int y = (int)(Math.random() * 240) + 10;
            label.setLocation(x, y);

            c.add(label);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question6();
    }
}
