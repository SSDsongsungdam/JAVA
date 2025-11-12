package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question7 extends JFrame {
    private JButton[] buttons = new JButton[5];
    private int[] counts = new int[5]; // 각 버튼의 클릭 횟수 저장

    public Question7() {
        setTitle("클릭 횟수 카운트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);

        // 버튼 5개를 가로로 배치
        setLayout(new GridLayout(1, 5, 10, 10));

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("0"); // 초기값 0
            final int index = i; // 람다식/익명클래스용 인덱스 저장
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    counts[index]++; // 클릭 횟수 증가
                    buttons[index].setText(Integer.toString(counts[index])); // 버튼에 표시
                }
            });
            add(buttons[i]);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question7();
    }
}
