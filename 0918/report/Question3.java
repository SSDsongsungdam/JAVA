package sungdam;

import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        // 양의 정수 입력 받을 때까지 반복
        while (true) {
            System.out.print("양의 정수 입력>>");
            n = sc.nextInt();
            if (n > 0) break;
        }

        // 별 출력
        for (int i = n; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        sc.close();
    }
}
