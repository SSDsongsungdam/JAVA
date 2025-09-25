package sungdam;

import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        
        System.out.print("양의 정수 10개 입력>>");
        for(int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        System.out.print("3의 배수는...");
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 3 == 0) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
        
        scanner.close();
    }
}