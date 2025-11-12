package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question2 extends JFrame {
    public Question2() {
        setTitle("BorderLayout 배치 관리자 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // BorderLayout 생성 (수평간격 5픽셀, 수직간격 7픽셀)
        setLayout(new BorderLayout(5, 7));

        // 각 영역에 버튼 추가
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("East"), BorderLayout.EAST);
        add(new JButton("West"), BorderLayout.WEST);
        add(new JButton("Center"), BorderLayout.CENTER);

        // 프레임 크기 설정 및 표시
        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question2();
    }
}
