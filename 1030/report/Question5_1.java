package sungdam;

import java.util.Scanner;

public class Question5_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
            String input = sc.nextLine().trim();

            // 종료 조건
            if (input.equalsIgnoreCase("그만")) {
                break;
            }

            String[] grades = input.split("\\s+"); // 공백 기준 분리
            double sum = 0.0;
            boolean hasError = false;

            for (String g : grades) {
                char grade = Character.toUpperCase(g.charAt(0));
                double score = 0.0;

                switch (grade) {
                    case 'A': score = 95; break;
                    case 'B': score = 85; break;
                    case 'C': score = 75; break;
                    case 'D': score = 65; break;
                    case 'F': score = 50; break;
                    default:
                        System.out.println("입력 오류 : " + grade);
                        hasError = true;
                        break;
                }

                if (hasError) break;
                sum += score;
            }

            if (!hasError) {
                double avg = sum / grades.length;
                System.out.println("평균은 " + avg);
            }
            System.out.println();
        }

        sc.close();
    }
}
