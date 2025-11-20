package sungdam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class OpenChallenge extends JFrame {
    // 초기 재고량
    private static final int INIT = 5;

    // 재료들
    private int cup = INIT;
    private int coffee = INIT;
    private int water = INIT;
    private int sugar = INIT;
    private int cream = INIT;

    // UI 컴포넌트
    private JProgressBar pbCup, pbCoffee, pbWater, pbSugar, pbCream;
    private JLabel lbCup, lbCoffee, lbWater, lbSugar, lbCream;
    private JPanel centerPanel;
    private JLabel centerImageLabel;

    public OpenChallenge() {
        super("Coffee Vending Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 360);
        setLocationRelativeTo(null);

        // 레이아웃: BorderLayout
        Container c = getContentPane();
        c.setLayout(new BorderLayout(8, 8));

        // NORTH: 제목 라벨
        JLabel title = new JLabel("Welcome, Hot Coffee!!", JLabel.CENTER);
        title.setOpaque(true);
        title.setBackground(new Color(0xC8, 0xA2, 0xD6));
        title.setFont(title.getFont().deriveFont(Font.BOLD, 18f));
        title.setBorder(new EmptyBorder(6, 6, 6, 6));
        c.add(title, BorderLayout.NORTH);

        // SOUTH: 버튼 패널
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
        JButton btnBlack = new JButton("Black Coffee");
        JButton btnSugar = new JButton("Sugar Coffee");
        JButton btnDabang = new JButton("Dabang Coffee");
        JButton btnReset = new JButton("Reset");

        btnBlack.addActionListener(e -> makeCoffee(CoffeeType.BLACK));
        btnSugar.addActionListener(e -> makeCoffee(CoffeeType.SUGAR));
        btnDabang.addActionListener(e -> makeCoffee(CoffeeType.DABANG));
        btnReset.addActionListener(e -> resetAll());

        southPanel.add(btnBlack);
        southPanel.add(btnSugar);
        southPanel.add(btnDabang);
        southPanel.add(btnReset);

        c.add(southPanel, BorderLayout.SOUTH);

        // CENTER: 자원 표시 + 커피 이미지 영역
        JPanel mainCenter = new JPanel(new BorderLayout(10, 10));
        // 자원 표시(왼쪽)
        JPanel resourcePanel = new JPanel();
        resourcePanel.setLayout(new GridLayout(5, 1, 6, 6));
        resourcePanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // 각 자원은 JProgressBar + 숫자 라벨로 표시
        pbCup = createBar();
        lbCup = new JLabel("", JLabel.RIGHT);
        resourcePanel.add(createRow("Cup", pbCup, lbCup));

        pbCoffee = createBar();
        lbCoffee = new JLabel("", JLabel.RIGHT);
        resourcePanel.add(createRow("Coffee", pbCoffee, lbCoffee));

        pbWater = createBar();
        lbWater = new JLabel("", JLabel.RIGHT);
        resourcePanel.add(createRow("Water", pbWater, lbWater));

        pbSugar = createBar();
        lbSugar = new JLabel("", JLabel.RIGHT);
        resourcePanel.add(createRow("Sugar", pbSugar, lbSugar));

        pbCream = createBar();
        lbCream = new JLabel("", JLabel.RIGHT);
        resourcePanel.add(createRow("Cream", pbCream, lbCream));

        mainCenter.add(resourcePanel, BorderLayout.WEST);

        // 오른쪽: 커피 이미지/표시 영역
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        centerImageLabel = new JLabel("", JLabel.CENTER);
        centerImageLabel.setFont(centerImageLabel.getFont().deriveFont(Font.PLAIN, 24f));
        centerImageLabel.setOpaque(true);
        centerImageLabel.setBackground(Color.WHITE);
        centerImageLabel.setPreferredSize(new Dimension(350, 200));
        centerPanel.add(centerImageLabel, BorderLayout.CENTER);
        mainCenter.add(centerPanel, BorderLayout.CENTER);

        c.add(mainCenter, BorderLayout.CENTER);

        updateUIValues();
    }

    private JPanel createRow(String name, JProgressBar bar, JLabel numLabel) {
        JPanel p = new JPanel(new BorderLayout(6, 6));
        JLabel lbl = new JLabel(name);
        lbl.setPreferredSize(new Dimension(70, 20));
        bar.setStringPainted(true);
        JPanel left = new JPanel(new BorderLayout(6, 6));
        left.add(lbl, BorderLayout.WEST);
        left.add(bar, BorderLayout.CENTER);
        p.add(left, BorderLayout.CENTER);

        numLabel.setPreferredSize(new Dimension(40, 20));
        p.add(numLabel, BorderLayout.EAST);
        return p;
    }

    private JProgressBar createBar() {
        JProgressBar pb = new JProgressBar(0, INIT);
        pb.setValue(INIT);
        return pb;
    }

    private void updateUIValues() {
        pbCup.setValue(Math.max(0, Math.min(INIT, cup)));
        pbCup.setString(String.valueOf(cup));
        lbCup.setText(String.valueOf(cup));

        pbCoffee.setValue(Math.max(0, Math.min(INIT, coffee)));
        pbCoffee.setString(String.valueOf(coffee));
        lbCoffee.setText(String.valueOf(coffee));

        pbWater.setValue(Math.max(0, Math.min(INIT, water)));
        pbWater.setString(String.valueOf(water));
        lbWater.setText(String.valueOf(water));

        pbSugar.setValue(Math.max(0, Math.min(INIT, sugar)));
        pbSugar.setString(String.valueOf(sugar));
        lbSugar.setText(String.valueOf(sugar));

        pbCream.setValue(Math.max(0, Math.min(INIT, cream)));
        pbCream.setString(String.valueOf(cream));
        lbCream.setText(String.valueOf(cream));
    }

    private enum CoffeeType { BLACK, SUGAR, DABANG }

    private void makeCoffee(CoffeeType type) {
        // 필요한 재료 검사
        // 공통: cup, coffee, water 필요
        boolean ok = true;
        String missing = "";

        if (cup <= 0) { ok = false; missing += "Cup "; }
        if (coffee <= 0) { ok = false; missing += "Coffee "; }
        if (water <= 0) { ok = false; missing += "Water "; }

        if (type == CoffeeType.SUGAR && sugar <= 0) {
            ok = false; missing += "Sugar ";
        }
        if (type == CoffeeType.DABANG && cream <= 0) {
            ok = false; missing += "Cream ";
        }

        if (!ok) {
            // 하나라도 부족 -> 경고
            JOptionPane.showMessageDialog(this,
                    "부족한 것이 있습니다: " + missing + "\n재고를 채워주세요.",
                    "커피 제조 불가",
                    JOptionPane.WARNING_MESSAGE);
            // 센터 이미지 리셋 (선택사항)
            centerImageLabel.setText("");
            centerImageLabel.setIcon(null);
            return;
        }

        // 재료 감소: 공통
        cup--; coffee--; water--;
        if (type == CoffeeType.SUGAR) sugar--;
        if (type == CoffeeType.DABANG) cream--;

        // 커피 이미지/문구 표시 (실제 이미지를 사용하려면 ImageIcon으로 교체 가능)
        switch (type) {
            case BLACK:
                centerImageLabel.setText("☕ Black Coffee");
                break;
            case SUGAR:
                centerImageLabel.setText("☕ Sugar Coffee");
                break;
            case DABANG:
                centerImageLabel.setText("☕ Dabang Coffee");
                break;
        }
        centerImageLabel.setFont(centerImageLabel.getFont().deriveFont(Font.BOLD, 22f));
        centerImageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 성공 메시지
        JOptionPane.showMessageDialog(this,
                "커피가 나왔습니다. 맛있게 드세요!",
                "커피 완성",
                JOptionPane.INFORMATION_MESSAGE);

        updateUIValues();
    }

    private void resetAll() {
        cup = INIT;
        coffee = INIT;
        water = INIT;
        sugar = INIT;
        cream = INIT;
        centerImageLabel.setText("");
        updateUIValues();
    }

    public static void main(String[] args) {
        // Swing UI는 EDT에서 생성
        SwingUtilities.invokeLater(() -> {
            OpenChallenge sim = new OpenChallenge();
            sim.setVisible(true);
        });
    }
}
