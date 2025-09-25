package sungdam;

import java.util.Scanner;

public class Question6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        
        System.out.print("양의 정수 10개 입력>>");
        for(int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        System.out.print("자리수의 합이 9인 것은 ...");
        for(int i = 0; i < numbers.length; i++) {
            if(getSumOfDigits(numbers[i]) == 9) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
        
        scanner.close();
    }
    
    // 자릿수의 합을 구하는 메서드
    public static int getSumOfDigits(int number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10; // 마지막 자릿수를 더함
            number /= 10;       // 마지막 자릿수를 제거
        }
        return sum;
    }
}