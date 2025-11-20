package sungdam;

import java.applet.AudioClip;
import java.applet.Applet;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Question5 extends JFrame {

    private AudioClip clip;   // 오디오 객체
    private JLabel label;     // 상태 표시

    public Question5() {
        setTitle("오디오 시작 중단 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 상태 텍스트
        label = new JLabel("audio\\hiphop.wav 연주 계속", SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        add(label);

        // 오디오 로드
        try {
            URL url = getClass().getResource("audio/hiphop.wav");
            clip = Applet.newAudioClip(url);
            clip.loop();  // 프로그램 시작되자마자 재생
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "오디오 파일을 찾을 수 없습니다.");
        }

        // 마우스 리스너 등록
        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                if (clip != null) {
                    clip.loop();  // 연주 계속
                    label.setText("audio\\hiphop.wav 연주 계속");
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (clip != null) {
                    clip.stop();  // 연주 일시 중단
                    label.setText("audio\\hiphop.wav 연주 일시 중단");
                }
            }
        });

        setSize(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Question5();
    }
}
