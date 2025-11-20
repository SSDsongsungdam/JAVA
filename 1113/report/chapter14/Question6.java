package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question6 extends JFrame {

    private JLabel resultLabel;   // 결과 출력 레이블

    public Question6() {
        setTitle("다이얼로그 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        JButton btn = new JButton("calculate");
        resultLabel = new JLabel("  ");  // 결과 출력 부분

        add(btn);
        add(resultLabel);

        // 버튼 클릭 → 다이얼로그 실행
        btn.addActionListener(e -> {
            CalcDialog dialog = new CalcDialog(this);
            dialog.setVisible(true);

            // 모달 다이얼로그가 닫힌 뒤 결과 꺼내오기
            int result = dialog.getResult();
            resultLabel.setText(Integer.toString(result));
        });

        setSize(300, 150);
        setVisible(true);
    }

    // ------------------------
    //   CalcDialog 클래스
    // ------------------------
    class CalcDialog extends JDialog {

        private JTextField tf1, tf2;
        private int result = 0;   // 계산 값 저장

        public CalcDialog(JFrame owner) {
            super(owner, "Calculation Dialog", true); // 모달 다이얼로그

            setLayout(new FlowLayout());
            setSize(250, 200);

            add(new JLabel("두 수를 더합니다."));

            tf1 = new JTextField(10);
            tf2 = new JTextField(10);

            add(tf1);
            add(tf2);

            JButton addBtn = new JButton("Add");
            add(addBtn);

            addBtn.addActionListener(e -> {
                try {
                    int a = Integer.parseInt(tf1.getText());
                    int b = Integer.parseInt(tf2.getText());
                    result = a + b;      // 계산
                    dispose();           // 다이얼로그 닫기
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "정수를 입력하세요.");
                }
            });
        }

        public int getResult() {
            return result;
        }
    }

    public static void main(String[] args) {
        new Question6();
    }
}
