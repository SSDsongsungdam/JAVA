package sungdam;

import java.util.*;

public class Question10_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // 단어 목록
        String[] words = { "happy", "morning", "package", "together", "extract", "nation", "connect", "present", "cookie", "lovely", "sunny" };

        System.out.println("10초 안에 단어를 맞추세요!!");

        while (true) {
            // 랜덤 단어 선택
            String answer = words[rand.nextInt(words.length)];

            // 문자 배열로 변환 후 섞기
            char[] chars = answer.toCharArray();
            for (int i = 0; i < 10; i++) {
                int idx1 = rand.nextInt(chars.length);
                int idx2 = rand.nextInt(chars.length);
                char temp = chars[idx1];
                chars[idx1] = chars[idx2];
                chars[idx2] = temp;
            }

            // 섞인 단어 출력
            String quiz = new String(chars);
            System.out.println(quiz);

            // 시작 시간
            long start = System.currentTimeMillis();

            System.out.print(">>");
            String input = sc.nextLine();

            if (input.equals("그만")) {
                break;
            }

            // 종료 시간
            long end = System.currentTimeMillis();
            double time = (end - start) / 1000.0;

            if (input.equals(answer)) {
                if (time <= 10.0) {
                    System.out.printf("성공!!! %.3f초 경과\n", time);
                } else {
                    System.out.printf("실패!!! 10초 초과. %.3f초 경과\n", time);
                }
            } else {
                System.out.printf("실패!!! %s 입니다. %.3f초 경과\n", answer, time);
            }
        }

        sc.close();
    }
}
