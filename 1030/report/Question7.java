package sungdam;

import java.util.Calendar;
import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();

        while (true) {
            System.out.print("년도 입력(-1이면 종료)>>> ");
            int year = sc.nextInt();
            if (year == -1) break;

            for (int month = 0; month < 12; month++) {
                cal.set(year, month, 1);

                int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
                int startDay = cal.get(Calendar.DAY_OF_WEEK); // 1:일요일~7:토요일

                System.out.printf("\n%d년 %d월\n", year, month + 1);
                System.out.println("일 월 화 수 목 금 토");

                // 1일 시작 전 공백 출력
                for (int i = 1; i < startDay; i++) {
                    System.out.print("   ");
                }

                // 날짜 출력
                for (int day = 1; day <= lastDay; day++) {
                    System.out.printf("%2d ", day);
                    if ((day + startDay - 1) % 7 == 0) System.out.println();
                }
                System.out.println();
            }
        }

        System.out.println("년도 입력(-1이면 종료)>>>");
        sc.close();
    }
}
