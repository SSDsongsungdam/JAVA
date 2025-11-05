package sungdam;

import java.util.Calendar;
import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calendar today = Calendar.getInstance();

        // 오늘 날짜 출력
        int tYear = today.get(Calendar.YEAR);
        int tMonth = today.get(Calendar.MONTH) + 1;
        int tDay = today.get(Calendar.DAY_OF_MONTH);
        System.out.printf("오늘은 %d년 %d월 %d일%n", tYear, tMonth, tDay);

        while (true) {
            System.out.print("생일 입력(년 월 일)>>>");
            String input = sc.nextLine().trim();

            if (input.equals("그만")) break;

            String[] parts = input.split(" ");
            if (parts.length != 3) {
                System.out.println("입력 형식이 잘못되었습니다. (예: 2004 8 15)");
                continue;
            }

            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            Calendar birth = Calendar.getInstance();
            birth.set(year, month - 1, day);

            // 시분초 0으로 초기화 (정확한 날짜 계산)
            today.set(Calendar.HOUR_OF_DAY, 0);
            today.set(Calendar.MINUTE, 0);
            today.set(Calendar.SECOND, 0);
            today.set(Calendar.MILLISECOND, 0);
            birth.set(Calendar.HOUR_OF_DAY, 0);
            birth.set(Calendar.MINUTE, 0);
            birth.set(Calendar.SECOND, 0);
            birth.set(Calendar.MILLISECOND, 0);

            long diffMillis = today.getTimeInMillis() - birth.getTimeInMillis();
            long diffDays = diffMillis / (1000 * 60 * 60 * 24);

            if (diffDays > 0) {
                System.out.printf("오늘까지 %d일 살아왔습니다.%n", diffDays + 1);
            } else if (diffDays == 0) {
                System.out.println("오늘이 생일입니다!");
            } else {
                System.out.printf("%d일 더 살아야 생일이 됩니다.%n", -diffDays);
            }
        }

        sc.close();
    }
}
