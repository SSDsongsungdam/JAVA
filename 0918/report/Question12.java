package sungdam;

import java.util.Scanner;

public class Question12 {
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);
        
        // 이름 배열 정의 (이미지 하단 참고)
        String[] boyMiddleList = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
        String[] boyLastList = {"태", "진", "광", "혁", "우", "철", "빈", "준", "구", "호", "석"};
        String[] girlMiddleList = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
        String[] girlLastList = {"진", "연", "정", "서", "리", "숙", "미", "원", "라", "희", "수"};
        
        System.out.println("***** 작명 프로그램이 실행됩니다. *****");
        
        while(true) {
            System.out.print("남/여 선택>>");
            String gender = scanner.nextLine();
            
            if(gender.equals("그만")) {
                System.out.println("남/여/그만 중에서 입력하시오!");
                System.out.print("남/여 선택>>");
                gender = scanner.nextLine();
                if(gender.equals("그만")) {
                    break;
                }
            }
            
            if(gender.equals("남")) {
                System.out.print("성 입력>>");
                String lastName = scanner.nextLine();
                
                // 랜덤하게 중간 이름과 마지막 이름 선택
                int middleIndex = (int)(Math.random() * boyMiddleList.length);
                int lastIndex = (int)(Math.random() * boyLastList.length);
                
                String fullName = lastName + boyMiddleList[middleIndex] + boyLastList[lastIndex];
                System.out.println("추천 이름: " + fullName);
                
            } else if(gender.equals("여")) {
                System.out.print("성 입력>>");
                String lastName = scanner.nextLine();
                
                // 랜덤하게 중간 이름과 마지막 이름 선택
                int middleIndex = (int)(Math.random() * girlMiddleList.length);
                int lastIndex = (int)(Math.random() * girlLastList.length);
                
                String fullName = lastName + girlMiddleList[middleIndex] + girlLastList[lastIndex];
                System.out.println("추천 이름: " + fullName);
                
            } else {
                System.out.println("남/여/그만 중에서 입력하시오!");
                continue;
            }
        }
        
        scanner.close();
    }
}