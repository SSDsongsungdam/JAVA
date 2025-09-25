package sungdam;

import java.util.Scanner;

public class Question11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wrongCount = 0; // 틀린 횟수
        
        while(wrongCount < 3) {
            // 랜덤하게 구구단 문제 생성 (2~9단)
            int num1 = (int)(Math.random() * 8) + 2; // 2~9
            int num2 = (int)(Math.random() * 9) + 1; // 1~9
            int correctAnswer = num1 * num2;
            
            System.out.print(num1 + "x" + num2 + "=");
            int userAnswer = scanner.nextInt();
            
            if(userAnswer == correctAnswer) {
                System.out.println("맞았습니다.");
            } else {
                System.out.println("틀렸습니다. 정답은 " + correctAnswer + "입니다.");
                wrongCount++;
                System.out.println("틀린 횟수: " + wrongCount);
                
                if(wrongCount == 3) {
                    System.out.println("3번 틀려서 종료합니다.");
                    break;
                }
            }
        }
        
        scanner.close();
    }
}