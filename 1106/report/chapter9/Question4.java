package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question4 extends JFrame {
    public Question4() {
        setTitle("배경색을 가진 10개의 버튼");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1행 10열 GridLayout
        setLayout(new GridLayout(1, 10));

        // 서로 다른 색상 10개 배열로 지정
        Color[] color = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
            Color.PINK, Color.LIGHT_GRAY
        };

        // 버튼 10개 생성 및 배경색 설정
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(Integer.toString(i));
            btn.setOpaque(true); // 배경색 표시를 위해 필요
            btn.setBackground(color[i]);
            add(btn);
        }

        // 프레임 설정
        setSize(600, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question4();
    }
}
