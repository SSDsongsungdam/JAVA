package sungdam;

import javax.swing.*;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Question7 extends JFrame {

    private Clip clip;
    private JLabel statusLabel;

    public Question7() {
        setTitle("오디오 파일을 찾아 연주/종료 제어");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);

        statusLabel = new JLabel("오디오 파일을 선택하세요", SwingConstants.CENTER);
        statusLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        add(statusLabel);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();
        JMenu audioMenu = new JMenu("오디오");

        JMenuItem playItem = new JMenuItem("연주");
        JMenuItem stopItem = new JMenuItem("종료");

        audioMenu.add(playItem);
        audioMenu.add(stopItem);

        menuBar.add(audioMenu);
        setJMenuBar(menuBar);

        // ➤ 연주 메뉴 클릭
        playItem.addActionListener(e -> chooseAndPlay());

        // ➤ 종료 메뉴 클릭
        stopItem.addActionListener(e -> stopAudio());

        setVisible(true);
    }

    // -------------------------------
    //   오디오 파일 선택 및 재생
    // -------------------------------
    private void chooseAndPlay() {
        JFileChooser chooser = new JFileChooser();

        // wav 파일만 선택되도록 필터 추가
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "WAV Audio Files (*.wav)", "wav"
        ));

        int ret = chooser.showOpenDialog(this);

        if (ret == JFileChooser.APPROVE_OPTION) {
            File wavFile = chooser.getSelectedFile();
            playAudio(wavFile);
        }
    }

    // -------------------------------
    //   오디오 재생 함수
    // -------------------------------
    private void playAudio(File file) {
        try {
            // 기존 재생 중지
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();

            statusLabel.setText(file.getName() + " 를 연주하고 있습니다");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "오디오 파일을 재생할 수 없습니다.");
        }
    }

    // -------------------------------
    //   오디오 종료 함수
    // -------------------------------
    private void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            statusLabel.setText("연주가 종료되었습니다");
        }
    }

    public static void main(String[] args) {
        new Question7();
    }
}
