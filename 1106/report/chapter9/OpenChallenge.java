package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class OpenChallenge extends JFrame {
    private JPanel centerPanel;
    private String text = "I can't help falling in love with you";
    private String[] words;
    private Random rand = new Random();

    public OpenChallenge() {
        setTitle("Open Challenge 9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // ✅ NORTH 영역 (상단)
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.LIGHT_GRAY);
        northPanel.add(new JLabel("단어 조합 게임!"));

        JButton newTextBtn = new JButton("New Text");
        northPanel.add(newTextBtn);
        add(northPanel, BorderLayout.NORTH);

        // ✅ CENTER 영역 (가운데)
        centerPanel = new JPanel();
        centerPanel.setLayout(null); // 절대 위치 배치
        add(centerPanel, BorderLayout.CENTER);

        // ✅ SOUTH 영역 (하단)
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.YELLOW);
        southPanel.add(new JLabel("이름"));
        JTextField nameField = new JTextField(10);
        southPanel.add(nameField);
        add(southPanel, BorderLayout.SOUTH);

        // 문장 단어 분리
        words = text.split(" ");
        makeLabels();

        // 버튼 클릭 시 단어 새로 배치
        newTextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                makeLabels();
                centerPanel.repaint();
            }
        });

        setVisible(true);
    }

    // ✅ CENTER 패널에 랜덤하게 단어 배치
    private void makeLabels() {
        for (String word : words) {
            JLabel label = new JLabel(word);
            int x = rand.nextInt(350); // 폭
            int y = rand.nextInt(180); // 높이
            label.setSize(80, 20);
            label.setLocation(x, y);
            centerPanel.add(label);
        }
    }

    public static void main(String[] args) {
        new OpenChallenge();
    }
}
