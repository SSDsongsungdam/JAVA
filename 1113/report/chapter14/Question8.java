package sungdam;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.sound.sampled.*;
import javax.swing.*;

public class Question8 extends JFrame {

    JCheckBox[] checkBoxes;
    String[] files = {
            "audio/wolf.wav",
            "audio/dhol_drums.wav",
            "audio/sirenpolice.wav",
            "audio/hiphop.wav"
    };

    JButton startBtn = new JButton("연주시작");
    JButton stopBtn = new JButton("연주 끝");

    Clip clip;                      // 현재 재생 중인 클립
    boolean isPlaying = false;      // 재생 중 여부
    int currentIndex = 0;           // 현재 재생할 음악 인덱스
    List<Integer> playList;         // 체크된 순서 목록

    public Question8() {
        super("오디오 연주");

        setLayout(new BorderLayout());

        // 상단 안내 문구
        add(new JLabel("체크된 곡만 순서대로 한 번 연주합니다.", JLabel.CENTER),
                BorderLayout.NORTH);

        // 체크박스 패널
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        checkBoxes = new JCheckBox[files.length];

        for (int i = 0; i < files.length; i++) {
            checkBoxes[i] = new JCheckBox(files[i]);
            checkBoxes[i].setFont(new Font("Dialog", Font.PLAIN, 14));
            centerPanel.add(checkBoxes[i]);
        }

        add(centerPanel, BorderLayout.CENTER);

        // 버튼 패널
        JPanel btnPanel = new JPanel();
        btnPanel.add(startBtn);
        btnPanel.add(stopBtn);
        add(btnPanel, BorderLayout.SOUTH);

        startBtn.addActionListener(e -> startPlay());
        stopBtn.addActionListener(e -> stopPlay());

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // ✔ 재생 시작
    void startPlay() {
        stopPlay();  // 기존 재생 중이면 끊기
        isPlaying = true;

        // 체크된 파일만 리스트에 넣기
        playList = new ArrayList<>();
        for (int i = 0; i < checkBoxes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                playList.add(i);
            }
        }

        if (playList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "선택된 곡이 없습니다.");
            return;
        }

        currentIndex = 0;
        playNext();
    }

    // ✔ 다음 곡 재생
    void playNext() {
        if (!isPlaying) return;
        if (currentIndex >= playList.size()) {
            isPlaying = false;
            return;
        }

        int idx = playList.get(currentIndex);

        // 현재 재생 곡 강조(굵게 + 파란색)
        highlightPlaying(idx);

        try {
            if (clip != null && clip.isOpen()) clip.close();

            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(files[idx]));
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();

            // 곡이 끝나면 다음 곡으로
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                    currentIndex++;
                    playNext();
                }
            });

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // ✔ 재생 중인 곡을 강조
    void highlightPlaying(int index) {
        for (int i = 0; i < checkBoxes.length; i++) {
            if (i == index) {
                checkBoxes[i].setFont(new Font("Dialog", Font.BOLD, 14));
                checkBoxes[i].setForeground(Color.BLUE);
            } else {
                checkBoxes[i].setFont(new Font("Dialog", Font.PLAIN, 14));
                checkBoxes[i].setForeground(Color.BLACK);
            }
        }
    }

    // ✔ 재생 종료
    void stopPlay() {
        isPlaying = false;
        if (clip != null) {
            clip.stop();
            clip.close();
        }

        // 폰트 원래대로
        for (JCheckBox cb : checkBoxes) {
            cb.setFont(new Font("Dialog", Font.PLAIN, 14));
            cb.setForeground(Color.BLACK);
        }
    }

    public static void main(String[] args) {
        new Question8();
    }
}
