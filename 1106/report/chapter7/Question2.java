package sungdam;

import java.util.*;

public class Question2 {
    private Vector<Integer> v = new Vector<Integer>(); // 정수 저장용 벡터

    // 정수 입력받기 (0 입력 시 종료)
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("0이 입력될 때까지 정수 입력>>");
        while (true) {
            int num = sc.nextInt();
            if (num == 0)
                break;
            v.add(num);
        }
    }

    // 음수를 모두 0으로 바꾸기
    public void changeToZero() {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) < 0)
                v.set(i, 0);
        }
    }

    // 벡터의 모든 값 출력
    public void showAll() {
        for (int n : v)
            System.out.print(n + " ");
        System.out.println();
    }

    // 양수들의 합 구하기
    public int add() {
        int sum = 0;
        for (int n : v) {
            if (n > 0)
                sum += n;
        }
        return sum;
    }

    // main 메서드
    public static void main(String[] args) {
        Question2 sp = new Question2();
        sp.read(); // 정수 입력받기
        sp.changeToZero(); // 음수 → 0
        System.out.print("음수를 0으로 바꾸면 ");
        sp.showAll(); // 벡터 출력
        System.out.println("양수들의 합은 " + sp.add()); // 합 출력
    }
}
