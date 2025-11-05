package sungdam;

import java.util.Random;
import java.util.Scanner;

// Player 클래스
class Player {
    private String name;
    private Random rand = new Random();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 한 번 시도
    public boolean play() {
        Scanner sc = new Scanner(System.in);
        System.out.print("[" + name + "] : <Enter>");
        sc.nextLine(); // Enter 입력 대기

        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = rand.nextInt(3) + 1; // 1~3 사이 랜덤값
            System.out.print(num[i] + " ");
        }
        System.out.println();

        // 세 숫자가 모두 같으면 true
        if (num[0] == num[1] && num[1] == num[2]) {
            System.out.println(name + "이(가) 이겼습니다!!");
            return true;
        } else {
            System.out.println("아쉽군요!");
            return false;
        }
    }
}

// 게임 전체를 담당하는 클래스
public class Question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("갬블링 게임에 참여할 선수 숫자>>");
        int n = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 선수 이름>>");
            String name = sc.nextLine();
            players[i] = new Player(name);
        }

        // 게임 시작
        boolean finished = false;
        while (!finished) {
            for (int i = 0; i < n; i++) {
                if (players[i].play()) {
                    finished = true;
                    break;
                }
            }
        }

        sc.close();
    }
}
