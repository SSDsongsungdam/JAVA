package sungdam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Question2 extends JFrame {

    private BufferedImage img = null;   // 선택한 이미지 저장
    private ImagePanel panel = new ImagePanel();

    public Question2() {
        setTitle("메뉴로 배경 이미지 로딩하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);

        setJMenuBar(createMenuBar());
        add(panel);

        setVisible(true);
    }

    // 메뉴 생성
    private JMenuBar createMenuBar() {
        JMenuBar bar = new JMenuBar();
        JMenu fileMenu = new JMenu("파일");

        JMenuItem openItem = new JMenuItem("열기");
        openItem.addActionListener(new OpenAction());

        fileMenu.add(openItem);
        bar.add(fileMenu);

        return bar;
    }

    // 열기 메뉴 클릭 시
    class OpenAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();

            // JPG 필터
            chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                    "JPG Images", "jpg", "jpeg"));

            int ret = chooser.showOpenDialog(null);

            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    img = ImageIO.read(file);
                    panel.setImage(img);   // 패널에 이미지 설정
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "이미지 로드 실패");
                }
            }
        }
    }

    // 패널에 직접 drawImage()로 그리기
    class ImagePanel extends JPanel {
        private BufferedImage image = null;

        public void setImage(BufferedImage img) {
            this.image = img;
            repaint();
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (image != null) {
                // 패널 전체에 맞게 이미지 배율 조정하여 그리기
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }

    public static void main(String[] args) {
        new Question2();
    }
}
