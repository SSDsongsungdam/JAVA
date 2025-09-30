package sungdam;

import java.util.Scanner;

class Seat {
    private String[] seats; // 좌석 배열

    public Seat() {
        seats = new String[10]; // 좌석 10개
        for (int i = 0; i < seats.length; i++) {
            seats[i] = "---"; // 빈 좌석
        }
    }

    public void show() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print(seats[i] + " ");
        }
        System.out.println();
    }

    public void reserve(String name, int num) {
        if (num < 1 || num > 10) {
            System.out.println("잘못된 좌석 번호입니다.");
            return;
        }
        if (!seats[num - 1].equals("---")) {
            System.out.println("이미 예약된 좌석입니다.");
            return;
        }
        seats[num - 1] = name;
    }

    public void cancel(String name) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals(name)) {
                seats[i] = "---";
                return;
            }
        }
        System.out.println("예약자 이름이 존재하지 않습니다.");
    }
}

public class Question13 {
    private Seat[] seats = new Seat[3];
    private Scanner sc = new Scanner(System.in);

    public Question13() {
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat();
        }
    }

    private void showAll() {
        System.out.print("S>> ");
        seats[0].show();
        System.out.print("A>> ");
        seats[1].show();
        System.out.print("B>> ");
        seats[2].show();
        System.out.println();
    }

    private void reserve() {
        System.out.print("좌석구분 S(1), A(2), B(3)>> ");
        int type = sc.nextInt();
        System.out.print("이름>> ");
        String name = sc.next();
        System.out.print("번호(1~10)>> ");
        int num = sc.nextInt();
        seats[type - 1].reserve(name, num);
    }

    private void cancel() {
        System.out.print("좌석구분 S(1), A(2), B(3)>> ");
        int type = sc.nextInt();
        System.out.print("이름>> ");
        String name = sc.next();
        seats[type - 1].cancel(name);
    }

    public void run() {
        System.out.println("콘서트 예약 시스템입니다.");
        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4 >> ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1: reserve(); break;
                case 2: showAll(); break;
                case 3: cancel(); break;
                case 4: System.out.println("프로그램을 종료합니다."); return;
                default: System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void main(String[] args) {
        Question13 cr = new Question13();
        cr.run();
    }
}
