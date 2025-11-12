package sungdam;

import java.util.*;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> mileageMap = new HashMap<>();
        
        System.out.println("*** 마일리지 관리 프로그램입니다. ***");
        
        while (true) {
            System.out.print("이름과 마일리지>> ");
            String name = sc.next();
            
            if (name.equals("그만")) break; // 종료 조건
            
            // 숫자 입력 오류 방지
            if (!sc.hasNextInt()) {
                System.out.println("마일리지는 숫자로 입력해주세요!");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }
            
            int mileage = sc.nextInt();
            
            // 기존 고객이면 누적, 아니면 새로 등록
            mileageMap.put(name, mileageMap.getOrDefault(name, 0) + mileage);
        }
        
        // 마일리지 현황 출력
        for (String key : mileageMap.keySet()) {
            System.out.print("(" + key + ":" + mileageMap.get(key) + ") ");
        }
        System.out.println();
        
        // 가장 마일리지가 높은 고객 찾기
        String topCustomer = null;
        int maxMileage = 0;
        
        for (Map.Entry<String, Integer> entry : mileageMap.entrySet()) {
            if (entry.getValue() > maxMileage) {
                maxMileage = entry.getValue();
                topCustomer = entry.getKey();
            }
        }
        
        System.out.println("가장 마일리지가 높은 고객은 " + topCustomer + "입니다.");
        System.out.println("프로그램을 종료합니다.");
        
        sc.close();
    }
}
