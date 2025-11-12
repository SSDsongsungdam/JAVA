package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OpenChallenge extends JFrame implements ActionListener {
    private JLabel numberLabel, messageLabel;
    private JButton oddBtn, evenBtn, checkBtn, resetBtn;
    private int hiddenNumber;   // 숨겨진 숫자
    private String userChoice;  // 사용자가 선택한 "홀" 또는 "짝"

    public OpenChallenge() {
        setTitle("홀짝 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 230);

        // 🔹 메인 패널 설정 (배치관리자 없음)
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        setContentPane(panel);

        // 🔹 숨겨진 숫자 표시 라벨
        numberLabel = new JLabel("?", SwingConstants.CENTER);
        numberLabel.setOpaque(true);
        numberLabel.setBackground(new Color(128, 0, 128)); // 보라색
        numberLabel.setForeground(Color.YELLOW);
        numberLabel.setFont(new Font("굴림", Font.BOLD, 40));
        numberLabel.setBounds(90, 20, 100, 80);
        panel.add(numberLabel);

        // 🔹 메시지 라벨
        messageLabel = new JLabel("무엇일까요?", SwingConstants.CENTER);
        messageLabel.setBounds(30, 110, 220, 20);
        panel.add(messageLabel);

        // 🔹 버튼 생성
        oddBtn = new JButton("홀");
        evenBtn = new JButton("짝");
        checkBtn = new JButton("확인");
        resetBtn = new JButton("다시");

        // 버튼 위치 설정
        oddBtn.setBounds(30, 140, 50, 30);
        evenBtn.setBounds(90, 140, 50, 30);
        checkBtn.setBounds(150, 140, 60, 30);
        resetBtn.setBounds(215, 140, 60, 30);

        // 버튼 추가
        panel.add(oddBtn);
        panel.add(evenBtn);
        panel.add(checkBtn);
        panel.add(resetBtn);

        // 버튼 리스너 연결
        oddBtn.addActionListener(this);
        evenBtn.addActionListener(this);
        checkBtn.addActionListener(this);
        resetBtn.addActionListener(this);

        // 🔹 초기 숫자 생성
        resetGame();

        setVisible(true);
    }

    // 게임 초기화
    private void resetGame() {
        hiddenNumber = (int)(Math.random() * 10) + 1; // 1~10
        numberLabel.setText("?");
        messageLabel.setText("무엇일까요?");
        userChoice = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == oddBtn) {
            userChoice = "홀";
        } else if (src == evenBtn) {
            userChoice = "짝";
        } else if (src == checkBtn) {
            if (userChoice == null) {
                messageLabel.setText("홀이나 짝 먼저 선택!");
                numberLabel.setText(Integer.toString(hiddenNumber));
                return;
            }

            numberLabel.setText(Integer.toString(hiddenNumber));
            boolean isOdd = (hiddenNumber % 2 == 1);

            if ((isOdd && userChoice.equals("홀")) ||
                (!isOdd && userChoice.equals("짝"))) {
                messageLabel.setText(userChoice + "! 맞았어요.");
            } else {
                messageLabel.setText(userChoice + "! 아쉽군요.");
            }

        } else if (src == resetBtn) {
            resetGame();
        }
    }

    public static void main(String[] args) {
        new OpenChallenge();
    }
}
