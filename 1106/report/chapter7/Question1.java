package sungdam;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();

        System.out.print("정수 입력 (-1이면 입력 끝)>>");
        while (true) {
            int num = sc.nextInt();
            if (num == -1) break; // -1 입력 시 종료
            v.add(num);
        }

        if (v.isEmpty()) {
            System.out.println("입력된 수가 없습니다.");
            sc.close();
            return;
        }

        int min = v.get(0); // 첫 번째 원소를 초기 최소값으로 설정
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i) < min)
                min = v.get(i);
        }

        System.out.println("제일 작은 수는 " + min);
        sc.close();
    }
}
