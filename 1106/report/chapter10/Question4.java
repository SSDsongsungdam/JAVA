package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question4 extends JFrame {
    private JLabel[][] labels = new JLabel[5][5]; // 5x5 격자
    private int x = 2, y = 2; // 초기 위치 (가운데)

    public Question4() {
        setTitle("상하좌우 키로 블록 이동하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // ----- NORTH 영역 -----
        JLabel msgLabel = new JLabel("상하좌우 키로 블록이 이동시킬 수 있습니다.");
        add(msgLabel, BorderLayout.NORTH);

        // ----- CENTER 영역 -----
        JPanel gridPanel = new JPanel(new GridLayout(5, 5, 1, 1));
        gridPanel.setBackground(Color.PINK);
        add(gridPanel, BorderLayout.CENTER);

        // JLabel 25개 생성
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                labels[i][j] = new JLabel();
                labels[i][j].setOpaque(true);
                labels[i][j].setBackground(Color.WHITE);
                gridPanel.add(labels[i][j]);
            }
        }

        // 초기 파란색 블록 표시
        labels[y][x].setBackground(Color.BLUE);

        // 키 리스너 추가
        gridPanel.setFocusable(true);
        gridPanel.requestFocus();
        gridPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                labels[y][x].setBackground(Color.WHITE); // 기존 위치 흰색으로

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (y > 0) y--;
                        break;
                    case KeyEvent.VK_DOWN:
                        if (y < 4) y++;
                        break;
                    case KeyEvent.VK_LEFT:
                        if (x > 0) x--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (x < 4) x++;
                        break;
                }

                labels[y][x].setBackground(Color.BLUE); // 새로운 위치 파란색으로
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question4();
    }
}
