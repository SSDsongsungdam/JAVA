package sungdam;

import java.util.Scanner;

public class Question8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("정수 몇 개 저장하시겠습니까?");
        int count = scanner.nextInt();
        
        // 배열 생성
        int[] numbers = new int[count];
        
        // 1~100 범위의 랜덤 정수로 배열 채우기
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 100) + 1; // 1~100 범위
        }
        
        // 랜덤한 정수들 출력
        System.out.print("랜덤한 정수들...");
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            sum += numbers[i];
        }
        System.out.println();
        
        // 평균 계산 및 출력
        double average = (double)sum / numbers.length;
        System.out.println("평균은 " + average);
        
        scanner.close();
    }
}