package sungdam;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Question18 {
    public static void main(String[] args) {     
        Scanner scanner = new Scanner(System.in);
        
        int[] studentIds = new int[10];  // 학번 배열
        int[] scores = new int[10];      // 점수 배열
        
        // 10명 학생의 학번과 점수 입력받기
        System.out.println("10명 학생의 학번과 점수 입력");
        for(int i = 0; i < 10; i++) {
            System.out.print((i+1) + ">>" + (i+1) + " ");
            studentIds[i] = scanner.nextInt();
            scores[i] = scanner.nextInt();
        }
        
        // 학번으로 점수 검색
        while(true) {
            try {
                System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
                int choice = scanner.nextInt();
                
                if(choice == 1) {
                    // 학번으로 검색
                    System.out.print("학번>>");
                    int searchId = scanner.nextInt();
                    
                    boolean found = false;
                    for(int i = 0; i < studentIds.length; i++) {
                        if(studentIds[i] == searchId) {
                            System.out.println(searchId + "점");
                            found = true;
                            break;
                        }
                    }
                    
                    if(!found) {
                        System.out.println(searchId + "의 학생은 없습니다.");
                    }
                    
                } else if(choice == 2) {
                    // 점수로 검색
                    System.out.print("점수>>");
                    int searchScore = scanner.nextInt();
                    
                    System.out.print("점수가 " + searchScore + "인 학생은 ");
                    boolean found = false;
                    for(int i = 0; i < scores.length; i++) {
                        if(scores[i] == searchScore) {
                            if(found) {
                                System.out.print(" ");
                            }
                            System.out.print(studentIds[i]);
                            found = true;
                        }
                    }
                    
                    if(found) {
                        System.out.println(" 입니다.");
                    } else {
                        System.out.println("없습니다.");
                    }
                    
                } else if(choice == 3) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    System.out.println("1, 2, 3 중에서 선택해주세요.");
                }
                
            } catch(InputMismatchException e) {
                System.out.println("경고!! 정수를 입력하시오.");
                scanner.nextLine(); // 버퍼 비우기
            }
        }
        
        scanner.close();
    }
}