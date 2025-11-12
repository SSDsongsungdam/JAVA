package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question3 extends JFrame {
    public Question3() {
        setTitle("GridLayout으로 10개의 버튼을 배치한 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridLayout(행, 열)
        setLayout(new GridLayout(1, 10));

        // 버튼 0~9 추가
        for (int i = 0; i < 10; i++) {
            add(new JButton(Integer.toString(i)));
        }

        // 프레임 크기 및 표시
        setSize(500, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question3();
    }
}
