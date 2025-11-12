package sungdam;

import java.util.*;

public class Question4_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 구입 가능한 물건과 가격 저장
        HashMap<String, Integer> items = new HashMap<>();
        items.put("고추장", 3000);
        items.put("만두", 500);
        items.put("새우깡", 1500);
        items.put("콜라", 600);
        items.put("참치캔", 2000);
        items.put("치약", 1000);
        items.put("연어", 2500);
        items.put("삼겹살", 2500);
        
        while (true) {
            System.out.print("물건과 개수를 입력하세요>> ");
            String line = sc.nextLine().trim();
            
            if (line.equals("그만")) {
                break;
            }
            
            String[] parts = line.split(" ");
            if (parts.length % 2 != 0) {
                System.out.println("입력에 문제가 있습니다!");
                continue;
            }
            
            int total = 0;
            boolean valid = true;
            
            for (int i = 0; i < parts.length; i += 2) {
                String item = parts[i];
                int count = 0;
                
                try {
                    count = Integer.parseInt(parts[i + 1]);
                } catch (NumberFormatException e) {
                    valid = false;
                    break;
                }
                
                if (!items.containsKey(item)) {
                    System.out.println(item + "은(는) 없는 상품입니다!");
                    valid = false;
                    break;
                }
                total += items.get(item) * count;
            }
            
            if (valid) {
                System.out.println("전체 비용은 " + total + "원입니다.");
            } else {
                System.out.println("입력에 문제가 있습니다!");
            }
        }
        sc.close();
    }
}
