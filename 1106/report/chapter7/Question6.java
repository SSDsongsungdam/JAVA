package sungdam;

import java.util.*;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> accounts = new HashMap<>();
        
        System.out.println("*** 명품 은행에 오신 것을 환영합니다. ***");
        
        while (true) {
            System.out.print("입금:1, 출금:2, 조회:3, 전체 조회:4, 종료:5>>");
            int choice = sc.nextInt();
            
            if (choice == 5) { // 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            
            switch (choice) {
                case 1: // 입금
                    System.out.print("계좌명과 액수>>");
                    String depositName = sc.next();
                    int depositAmount = sc.nextInt();
                    accounts.put(depositName, accounts.getOrDefault(depositName, 0) + depositAmount);
                    break;
                    
                case 2: // 출금
                    System.out.print("계좌명과 액수>>");
                    String withdrawName = sc.next();
                    int withdrawAmount = sc.nextInt();
                    if (!accounts.containsKey(withdrawName)) {
                        System.out.println("해당 계좌가 존재하지 않습니다!");
                        break;
                    }
                    int balance = accounts.get(withdrawName);
                    if (balance < withdrawAmount) {
                        System.out.println("잔액이 부족하여 출금할 수 없음!!");
                    } else {
                        accounts.put(withdrawName, balance - withdrawAmount);
                    }
                    break;
                    
                case 3: // 개별 조회
                    System.out.print("계좌명>>");
                    String name = sc.next();
                    if (accounts.containsKey(name)) {
                        System.out.println("(" + name + ":" + accounts.get(name) + "원)");
                    } else {
                        System.out.println("해당 계좌가 존재하지 않습니다!");
                    }
                    break;
                    
                case 4: // 전체 조회
                    for (String key : accounts.keySet()) {
                        System.out.print("(" + key + ":" + accounts.get(key) + "원) ");
                    }
                    System.out.println();
                    break;
                    
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
            }
        }
        
        sc.close();
    }
}
