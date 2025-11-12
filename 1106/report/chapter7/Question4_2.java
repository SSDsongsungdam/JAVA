package sungdam;

import java.util.*;

public class Question4_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 품목과 가격을 각각 ArrayList에 저장
        ArrayList<String> items = new ArrayList<>(Arrays.asList(
            "고추장", "만두", "새우깡", "콜라", "참치캔", "치약", "연어", "삼겹살"
        ));
        ArrayList<Integer> prices = new ArrayList<>(Arrays.asList(
            3000, 500, 1500, 600, 2000, 1000, 2500, 2500
        ));

        while (true) {
            System.out.print("물건과 개수를 입력하세요>> ");
            String line = sc.nextLine().trim();

            if (line.equals("그만")) break;

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

                int idx = items.indexOf(item);
                if (idx == -1) {
                    System.out.println(item + "은(는) 없는 상품입니다!");
                    valid = false;
                    break;
                }

                total += prices.get(idx) * count;
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
