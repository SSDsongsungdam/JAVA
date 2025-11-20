package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question3 extends JFrame {

    public Question3() {
        setTitle("Toolbar Exit Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --- 툴바 만들기 ---
        JToolBar toolBar = new JToolBar();

        // 종료 버튼 추가
        JButton exitBtn = new JButton("종료");
        toolBar.add(exitBtn);

        add(toolBar, BorderLayout.NORTH);

        // --- 종료 버튼 리스너 ---
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        Question3.this,
                        "정말 종료하시겠습니까?",
                        "종료 확인",
                        JOptionPane.YES_NO_OPTION
                );

                // YES(=0)을 선택했을 경우 종료
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question3();
    }
}
