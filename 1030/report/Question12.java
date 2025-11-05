package sungdam;

import java.util.*;

class Player {
    private String name;
    private int number; // 선수가 고른 숫자
    private int matchCount; // 일치한 개수

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setMatchCount(int count) {
        this.matchCount = count;
    }

    public int getMatchCount() {
        return matchCount;
    }
}

public class Question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("게임에 참여할 선수들 이름>>");
        String[] names = sc.nextLine().split(" ");
        int n = names.length;

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            players[i] = new Player(names[i]);
        }

        // 각 선수의 숫자 입력
        for (int i = 0; i < n; i++) {
            System.out.print("[" + players[i].getName() + "] 정수 선택(1~10)>>");
            int num = Integer.parseInt(sc.nextLine());
            players[i].setNumber(num);
        }

        while (true) {
            System.out.print("Enter키 입력>>");
            sc.nextLine(); // Enter 대기

            int[] numbers = new int[15];
            for (int i = 0; i < 15; i++) {
                numbers[i] = rand.nextInt(10) + 1; // 1~10
                System.out.print(numbers[i] + " ");
            }
            System.out.println();

            // 일치 개수 세기
            for (Player p : players) {
                int count = 0;
                for (int num : numbers) {
                    if (num == p.getNumber()) count++;
                }
                p.setMatchCount(count);
                System.out.println("[" + p.getName() + "] 맞춘 개수: " + count);
            }

            // 가장 많이 맞춘 사람 찾기
            int max = 0;
            for (Player p : players) {
                if (p.getMatchCount() > max) max = p.getMatchCount();
            }

            ArrayList<Player> losers = new ArrayList<>();
            for (Player p : players) {
                if (p.getMatchCount() == max)
                    losers.add(p);
            }

            if (losers.size() == 1) {
                System.out.println("현재 패자는: " + losers.get(0).getName());
                System.out.println("최종 패자는 " + losers.get(0).getName() + "입니다.");
                break;
            } else {
                System.out.print("현재 패자들: ");
                for (Player p : losers) System.out.print(p.getName() + " ");
                System.out.println();
                System.out.println("패자가 1명이 아니므로 프로그램을 다시 실행합니다.\n");
            }
        }

        sc.close();
    }
}
