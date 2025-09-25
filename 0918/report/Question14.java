package sungdam;

import java.util.Scanner;

public class Question14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("***** 갬블링 게임을 시작합니다. *****");
        
        while(true) {
            System.out.print("엔터키 입력>>");
            String input = scanner.nextLine();
            
            // 0, 1, 2 중에서 랜덤하게 3개 생성
            int num1 = (int)(Math.random() * 3); // 0, 1, 2 중 랜덤
            int num2 = (int)(Math.random() * 3);
            int num3 = (int)(Math.random() * 3);
            
            System.out.println(num1 + " " + num2 + " " + num3);
            
            // 3개가 모두 같은지 확인
            if(num1 == num2 && num2 == num3) {
                System.out.println("성공, 대박났어요!");
                break; // 게임 종료
            }
        }
        
        scanner.close();
    }
}