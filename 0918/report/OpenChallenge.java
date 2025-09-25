package sungdam;

import java.util.Scanner;

public class OpenChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            int answer = (int)(Math.random() * 100); // 0~99 난수 생성
            int low = 0;
            int high = 99;
            int guess;
            int count = 1;

            System.out.println("수를 결정하였습니다. 맞추어 보세요.");
            System.out.println(low + "-" + high);

            while (true) {
                System.out.print(count + ">>");
                guess = scanner.nextInt();

                if (guess < answer) {
                    System.out.println("더 높게");
                    low = guess;
                } else if (guess > answer) {
                    System.out.println("더 낮게");
                    high = guess;
                } else {
                    System.out.println("맞았습니다.");
                    break;
                }
                System.out.println(low + "-" + high);
                count++;
            }

            System.out.print("다시하시겠습니까?(y/n) >> ");
            String again = scanner.next();
            if (again.equalsIgnoreCase("n")) {
                playAgain = false;
            }
        }
        System.out.println("게임을 종료합니다.");
        scanner.close();
    }
}
