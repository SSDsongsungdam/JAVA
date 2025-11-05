package sungdam;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
        String str = sc.nextLine();  // 공백 포함 입력 받기

        for (int i = 0; i < str.length(); i++) {
            // 문자열을 회전시키는 부분
            String rotated = str.substring(i) + str.substring(0, i);
            System.out.println(rotated);
        }

        sc.close();
    }
}
