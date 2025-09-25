package sungdam;

public class Question7 {
    public static void main(String[] args) {
        // 정수를 10개 저장하는 배열 생성
        int[] numbers = new int[10];
        
        // 11~19 범위의 랜덤 정수 생성하여 배열에 저장
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random() * 9) + 11; // 11~19 범위
        }
        
        // 배열의 정수들 출력
        System.out.print("랜덤한 정수들...");
        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
            sum += numbers[i]; // 합계 계산
        }
        System.out.println();
        
        // 평균 계산 및 출력
        double average = (double)sum / numbers.length;
        System.out.println("평균은 " + average);
    }
}