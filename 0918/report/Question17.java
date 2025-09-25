package sungdam;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Question17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};
        
        // 메뉴 출력
        for(int i = 0; i < coffee.length; i++) {
            System.out.print(coffee[i]);
            if(i < coffee.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" 있습니다.");
        
        while(true) {
            try {
                System.out.print("주문>>");
                String order = scanner.next();
                
                if(order.equals("그만")) {
                    break;
                }
                
                // 주문한 커피 찾기
                boolean found = false;
                for(int i = 0; i < coffee.length; i++) {
                    if(coffee[i].equals(order)) {
                        int quantity = scanner.nextInt();
                        int totalPrice = price[i] * quantity;
                        System.out.println("가격은 " + totalPrice + "원입니다.");
                        found = true;
                        break;
                    }
                }
                
                if(!found) {
                    System.out.println(order + "는 없는 메뉴입니다.");
                    // 잘못된 메뉴 입력 후 숫자가 입력된 경우를 위해 다음 토큰이 숫자인지 확인
                    if(scanner.hasNextInt()) {
                        scanner.nextInt(); // 숫자 소비
                    }
                }
                
            } catch(InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요!");
                scanner.nextLine(); // 버퍼 비우기
            }
        }
        
        scanner.close();
    }
}