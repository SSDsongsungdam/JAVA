package sungdam;

import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> stockMap = new HashMap<>();

        System.out.println("주식 종목과 주가를 입력하세요 (예: 삼성전자 75000)");

        // 1단계: 종목과 주가 입력
        while (true) {
            System.out.print("종목, 주가>>");
            String name = sc.next(); // 종목명
            if (name.equals("그만")) break; // 입력 종료
            int price = sc.nextInt();
            stockMap.put(name, price);
        }

        // 2단계: 검색 단계
        System.out.println("주가를 검색합니다.");
        while (true) {
            System.out.print("종목>>");
            String name = sc.next();
            if (name.equals("그만")) break;

            Integer price = stockMap.get(name);
            if (price == null)
                System.out.println(name + "는 없는 종목입니다.");
            else
                System.out.println(name + "의 주가는 " + price + "원입니다.");
        }

        sc.close();
    }
}
