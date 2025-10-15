package sungdam;

import java.util.Scanner;

// 추상 Player 클래스
abstract class Player {
    protected static String[] bet = { "묵", "찌", "빠" };
    protected String name;
    protected String lastBet;

    protected Player(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public String getBet() { return lastBet; }

    abstract public String next();  // 다음에 낼 손동작 반환
}

// Human 클래스
class Human extends Player {
    private Scanner sc;

    public Human(String name, Scanner sc) {
        super(name);
        this.sc = sc;
    }

    @Override
    public String next() {
        System.out.print(name + " >> ");
        lastBet = sc.next();
        return lastBet;
    }
}

// Computer 클래스
class Computer extends Player {
    public Computer(String name) {
        super(name);
    }

    @Override
    public String next() {
        int index = (int)(Math.random() * bet.length);
        lastBet = bet[index];
        System.out.println(name + " >> " + lastBet);
        return lastBet;
    }
}

// Game 클래스
class Game {
    private Player[] players;
    private Scanner sc;

    public Game() {
        sc = new Scanner(System.in);
        createPlayers();
    }

    private void createPlayers() {
        players = new Player[2];
        System.out.print("사용자의 이름을 입력하세요 >> ");
        String name = sc.next();
        players[0] = new Human(name, sc);
        players[1] = new Computer("컴퓨터");
    }

    public void run() {
        System.out.println("묵찌빠 게임을 시작합니다.");
        Player owner = players[0]; // 선공
        System.out.println(owner.getName() + "가 먼저 공격을 합니다.");

        while (true) {
            String human = players[0].next();
            String computer = players[1].next();

            if (!isValid(human)) {
                System.out.println("잘못 입력했습니다. 다시 입력하세요.");
                continue;
            }

            if (human.equals(computer)) {
                System.out.println(owner.getName() + "의 승리!");
                break;
            }

            owner = getWinner(human, computer);
            System.out.println(owner.getName() + "가 공격권을 가져갑니다.");
        }
        System.out.println("게임을 종료합니다.");
    }

    private boolean isValid(String s) {
        for (String b : Player.bet)
            if (b.equals(s)) return true;
        return false;
    }

    private Player getWinner(String h, String c) {
        // 묵찌빠 규칙
        if (h.equals("묵")) {
            return c.equals("찌") ? players[0] : players[1];
        } else if (h.equals("찌")) {
            return c.equals("빠") ? players[0] : players[1];
        } else { // "빠"
            return c.equals("묵") ? players[0] : players[1];
        }
    }
}

// 프로그램 실행 클래스
public class OpenChallenge {
    public static void main(String[] args) {
        new Game().run();
    }
}
