package sungdam;

import java.util.Scanner;

public class OpenChallenge {
    public static void main(String[] args) {
        String text = readString(); // 여러 줄 텍스트 입력받기
        int[] alphabetCount = new int[26]; // A~Z 빈도 저장 배열

        // 모든 문자에 대해 검사
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) { // 영문자일 때만
                ch = Character.toUpperCase(ch); // 대문자로 통일
                alphabetCount[ch - 'A']++; // 해당 알파벳 카운트 증가
            }
        }

        // 히스토그램 출력
        for (int i = 0; i < 26; i++) {
            System.out.print((char) ('A' + i) + ": ");
            for (int j = 0; j < alphabetCount[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 여러 줄 입력받는 함수 (세미콜론 입력 시 종료)
    public static String readString() {
        StringBuffer sb = new StringBuffer();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            if (line.equals(";")) // 세미콜론 입력 시 종료
                break;
            sb.append(line); // 줄 추가
        }
        return sb.toString();
    }
}


