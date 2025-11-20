package sungdam;

import javax.swing.*;

public class Question1 extends JFrame {

    public Question1() {
        setTitle("메뉴 만들기");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();

        // 4가지 메뉴 생성
        JMenu fileMenu = new JMenu("파일");
        JMenu editMenu = new JMenu("편집");
        JMenu viewMenu = new JMenu("보기");
        JMenu inputMenu = new JMenu("입력");

        // 보기 메뉴의 메뉴아이템 2개 생성
        JMenuItem zoomItem = new JMenuItem("화면확대");
        JMenuItem outlineItem = new JMenuItem("족윤곽");

        // 보기 메뉴에 아이템 추가
        viewMenu.add(zoomItem);
        viewMenu.add(outlineItem);

        // 메뉴바에 메뉴 추가
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(inputMenu);

        // 프레임에 메뉴바 추가
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Question1();
    }
}
