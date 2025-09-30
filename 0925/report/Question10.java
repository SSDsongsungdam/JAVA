package sungdam;

import java.util.Scanner;

class Day {
    private String work; // 하루 일정

    public void setWork(String work) {
        this.work = work;
    }

    public String getWork() {
        return work;
    }

    public void show() {
        if (work == null) {
            System.out.println("없습니다.");
        } else {
            System.out.println(work + "입니다.");
        }
    }
}

class Diary {
    private Day[] days;
    private int lastDay = 30; // 한 달은 30일

    public Diary() {
        days = new Day[lastDay];
        for (int i = 0; i < days.length; i++) {
            days[i] = new Day();
        }
    }

    // 일정 기록
    public void input(int day, String work) {
        if (day < 1 || day > lastDay) {
            System.out.println("잘못된 날짜입니다.");
            return;
        }
        days[day - 1].setWork(work);
        System.out.println(day + "일의 일정이 저장되었습니다.");
    }

    // 일정 보기
    public void view(int day) {
        if (day < 1 || day > lastDay) {
            System.out.println("잘못된 날짜입니다.");
            return;
        }
        System.out.print(day + "일의 일정은 ");
        days[day - 1].show();
    }

    // 프로그램 종료
    public void finish() {
        System.out.println("프로그램을 종료합니다.");
    }
}

public class Question10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Diary diary = new Diary();
        System.out.println("***** 2024년 10월 다이어리 *****");

        while (true) {
            System.out.print("기록:1, 보기:2, 종료:3 >> ");
            int menu = sc.nextInt();
            if (menu == 1) { // 기록
                System.out.print("날짜(1~30)와 텍스트(빈칸 없이 4글자 이하)>> ");
                int day = sc.nextInt();
                String work = sc.next();
                diary.input(day, work);
            } else if (menu == 2) { // 보기
                System.out.print("날짜(1~30)>> ");
                int day = sc.nextInt();
                diary.view(day);
            } else if (menu == 3) { // 종료
                diary.finish();
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}
