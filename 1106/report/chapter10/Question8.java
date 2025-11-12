package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question8 extends JFrame {
    private JLabel[] cards = new JLabel[12];
    private JLabel firstCard = null; // 첫 번째로 클릭된 카드
    private Color defaultColor = Color.YELLOW;
    private Color selectColor = Color.MAGENTA;

    public Question8() {
        setTitle("카드 스위치 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(3, 4, 5, 5)); // 3행 4열 카드 배치

        Font font = new Font("Dialog", Font.BOLD, 20);

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new JLabel(Integer.toString(i + 1), SwingConstants.CENTER);
            cards[i].setOpaque(true);
            cards[i].setBackground(defaultColor);
            cards[i].setFont(font);
            cards[i].setBorder(BorderFactory.createLineBorder(Color.GRAY));

            // 카드 클릭 이벤트
            cards[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel clicked = (JLabel) e.getSource();

                    // 첫 번째 카드 선택
                    if (firstCard == null) {
                        firstCard = clicked;
                        firstCard.setBackground(selectColor);
                    } else if (firstCard == clicked) {
                        // 같은 카드를 다시 클릭한 경우 선택 취소
                        firstCard.setBackground(defaultColor);
                        firstCard = null;
                    } else {
                        // 두 번째 카드 클릭 → 숫자 교환
                        String temp = firstCard.getText();
                        firstCard.setText(clicked.getText());
                        clicked.setText(temp);

                        // 색상 초기화
                        firstCard.setBackground(defaultColor);
                        firstCard = null;
                    }
                }
            });

            add(cards[i]);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question8();
    }
}
