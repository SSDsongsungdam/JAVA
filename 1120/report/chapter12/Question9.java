package sungdam;

import javax.swing.*;
import java.awt.*;

class BlueLabel extends JLabel {

    public BlueLabel(String text) {
        super(text);
        super.setOpaque(true);
        super.setBackground(Color.BLUE);  // 기본 파란색
        setForeground(Color.YELLOW);      // 글씨는 잘 보이도록 노란색
    }

    // 외부에서 배경색을 바꾸려고 해도 무시되도록 한다.
    @Override
    public void setBackground(Color bg) {
        // 강제로 항상 파란색
        super.setBackground(Color.BLUE);
    }
}

public class Question9 extends JFrame {

    public Question9() {
        setTitle("Blue Label 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null);  // 문제에서 예시가 위치 기반이므로 null 레이아웃 사용

        // 작은 BlueLabel (hello)
        BlueLabel smallLabel = new BlueLabel("hello");
        smallLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        smallLabel.setBounds(10, 10, 60, 20);
        add(smallLabel);

        // 큰 BlueLabel (Big Hello)
        BlueLabel bigLabel = new BlueLabel("Big Hello");
        bigLabel.setFont(new Font("Arial", Font.ITALIC, 50));
        bigLabel.setBounds(80, 50, 400, 100);
        add(bigLabel);

        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question9();
    }
}
