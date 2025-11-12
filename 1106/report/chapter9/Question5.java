package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question5 extends JFrame {
    public Question5() {
        setTitle("4x4 Color 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridLayout(4행 4열)
        setLayout(new GridLayout(4, 4));

        // 16가지 색상 배열 생성
        Color[] colors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY,
            Color.PINK, Color.LIGHT_GRAY, Color.WHITE, Color.DARK_GRAY,
            Color.BLACK, Color.YELLOW, Color.BLUE, Color.MAGENTA
        };

        // JLabel 16개 생성 및 배경색 설정
        for (int i = 0; i < 16; i++) {
            JLabel label = new JLabel(Integer.toString(i), SwingConstants.CENTER);
            label.setOpaque(true); // 배경색이 보이도록 설정
            label.setBackground(colors[i]);
            add(label);
        }

        // 프레임 설정
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question5();
    }
}
