package sungdam;

import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {        
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[4][4];
        
        // 0~255 범위의 랜덤 정수로 배열 초기화
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                array[i][j] = (int)(Math.random() * 256); // 0~255 범위
            }
        }
        
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        
        // 초기 배열 출력
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(array[i][j]);
                if(j < 3) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        
        // 임계값 입력받기
        System.out.print("임계값 입력>>");
        int threshold = scanner.nextInt();
        
        // 임계값을 기준으로 배열 수정
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(array[i][j] > threshold) {
                    array[i][j] = 255;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        
        // 수정된 배열 출력
        System.out.println();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(array[i][j]);
                if(j < 3) {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}