package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question4 extends JFrame {

    public Question4() {
        setTitle("숫자가 아닌 키가 입력되면 경고창 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 120);

        // ─────────────────────────────
        // 1. ToolBar 생성
        // ─────────────────────────────
        JToolBar toolBar = new JToolBar();
        toolBar.add(new JLabel("학번: "));

        // 텍스트필드 생성
        JTextField tf = new JTextField(20);

        // ─────────────────────────────
        // 2. 숫자만 입력되도록 KeyListener 구현
        // ─────────────────────────────
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                // 숫자가 아닐 경우
                if (!Character.isDigit(c)) {
                    e.consume(); // 입력된 문자 무효화

                    JOptionPane.showMessageDialog(
                            null,
                            "숫자 키가 아닙니다.\n숫자를 입력하세요.",
                            "경고",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        toolBar.add(tf);

        // 프레임에 툴바 부착
        add(toolBar, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question4();
    }
}
