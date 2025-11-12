package sungdam;

import javax.swing.*;
import java.awt.*;

public class Question1 extends JFrame {
    public Question1() {
        // 프레임 제목 설정
        setTitle("Make a Window using Swing");

        // 프레임 크기 설정
        setSize(400, 150);

        // 닫기 버튼 누르면 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 컨텐트팬 가져오기
        Container c = getContentPane();

        // 배경색 노란색으로 설정
        c.setBackground(Color.YELLOW);

        // 프레임 보이기
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question1();
    }
}
