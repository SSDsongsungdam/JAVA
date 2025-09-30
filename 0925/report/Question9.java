package sungdam;

import java.util.Scanner;

class Player {
    String name;   // 선수 이름
    int guess;     // 제시한 숫자
    int score;     // 점수

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void makeGuess(Scanner sc) {
        System.out.print(name + ">>");
        guess = sc.nextInt();
    }
}

public class Question9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("게임에 참여할 선수 수>>");
        int n = sc.nextInt();
        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.print("선수 이름>>");
            String name = sc.next();
            players[i] = new Player(name);
        }

        boolean playing = true;
        while (playing) {
            int answer = (int)(Math.random() * 100) + 1; // 1~100 난수
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

            // 선수들이 차례대로 입력
            for (Player p : players) {
                p.makeGuess(sc);
            }

            // 가장 가까운 선수 찾기
            Player winner = players[0];
            int minDiff = Math.abs(players[0].guess - answer);

            for (int i = 1; i < n; i++) {
                int diff = Math.abs(players[i].guess - answer);
                if (diff < minDiff) {
                    minDiff = diff;
                    winner = players[i];
                }
            }

            System.out.println("정답은 " + answer + ". " + winner.name + "이(가) 이겼습니다!");
            winner.score++;
            System.out.println(winner.name + " 승점 1점 확보! 현재 점수: " + winner.score);

            System.out.print("계속하시겠습니까?(yes/no)>>");
            String again = sc.next();
            if (again.equalsIgnoreCase("no")) {
                playing = false;
            }
        }

        // 최종 점수 출력
        System.out.println("=== 최종 점수 ===");
        for (Player p : players) {
            System.out.println(p.name + ": " + p.score + "점");
        }

        sc.close();
    }
}
