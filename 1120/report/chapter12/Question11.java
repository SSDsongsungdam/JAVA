package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question11 extends JFrame {

    JTextField tfApple, tfCherry, tfStrawberry, tfPrune;
    ChartPanel chartPanel;

    public Question11() {
        setTitle("파이 차트 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // ----- 상단 입력 패널 -----
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("apple"));
        tfApple = new JTextField(5);
        inputPanel.add(tfApple);

        inputPanel.add(new JLabel("cherry"));
        tfCherry = new JTextField(5);
        inputPanel.add(tfCherry);

        inputPanel.add(new JLabel("strawberry"));
        tfStrawberry = new JTextField(5);
        inputPanel.add(tfStrawberry);

        inputPanel.add(new JLabel("prune"));
        tfPrune = new JTextField(5);
        inputPanel.add(tfPrune);

        add(inputPanel, BorderLayout.NORTH);

        // ----- 파이 차트를 그릴 패널 -----
        chartPanel = new ChartPanel();
        add(chartPanel, BorderLayout.CENTER);

        // ----- 모든 입력창에 같은 ActionListener 연결 -----
        ActionListener listener = e -> calculateAndRepaint();
        tfApple.addActionListener(listener);
        tfCherry.addActionListener(listener);
        tfStrawberry.addActionListener(listener);
        tfPrune.addActionListener(listener);

        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // -------- 백분율 계산 후 다시 그리기 --------
    private void calculateAndRepaint() {
        try {
            int apple = Integer.parseInt(tfApple.getText());
            int cherry = Integer.parseInt(tfCherry.getText());
            int straw = Integer.parseInt(tfStrawberry.getText());
            int prune = Integer.parseInt(tfPrune.getText());

            int total = apple + cherry + straw + prune;

            if (total == 0) return;

            chartPanel.percent[0] = apple * 100.0 / total;
            chartPanel.percent[1] = cherry * 100.0 / total;
            chartPanel.percent[2] = straw * 100.0 / total;
            chartPanel.percent[3] = prune * 100.0 / total;

            chartPanel.repaint();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "숫자를 정확히 입력하세요.");
        }
    }

    // -------- 파이 차트를 그리는 패널 --------
    class ChartPanel extends JPanel {
        double[] percent = {0, 0, 0, 0};   // apple, cherry, strawberry, prune
        Color[] colors = { Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE };

        String[] labels = { "apple", "cherry", "strawberry", "prune" };

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int x = 150; 
            int y = 120;
            int width = 250;
            int height = 250;

            int startAngle = 0;

            // ----- 파이차트 원 부분 그리기 -----
            for (int i = 0; i < 4; i++) {
                int arcAngle = (int)(percent[i] * 360 / 100);

                g.setColor(colors[i]);
                g.fillArc(x, y, width, height, startAngle, arcAngle);

                startAngle += arcAngle;
            }

            // ----- 퍼센트 글자 출력 -----
            int textY = 100;
            for (int i = 0; i < 4; i++) {
                g.setColor(colors[i]);
                g.drawString(labels[i] + " " + (int)percent[i] + "%", 50 + i * 120, textY);
            }
        }
    }

    public static void main(String[] args) {
        new Question11();
    }
}
