package sungdam;

import java.util.Random;
import java.util.Scanner;

public class Question9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        final int SIZE = 5;
        char[][] grid = new char[SIZE][SIZE];

        while (true) {
            System.out.print("단어>>");
            String word = sc.nextLine().trim();

            if (word.equals("그만")) break;

            // 5x5 배열 랜덤 문자로 초기화
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    grid[i][j] = (char) ('a' + rand.nextInt(26));
                }
            }

            int len = word.length();
            if (len > SIZE) {
                System.out.println("단어 길이가 너무 깁니다. (최대 5글자)");
                continue;
            }

            // 방향 선택: 0=가로, 1=세로, 2=대각선
            int direction = rand.nextInt(3);
            int row = 0, col = 0;

            switch (direction) {
                case 0: // 가로
                    row = rand.nextInt(SIZE);
                    col = rand.nextInt(SIZE - len + 1);
                    for (int i = 0; i < len; i++) {
                        grid[row][col + i] = word.charAt(i);
                    }
                    break;

                case 1: // 세로
                    row = rand.nextInt(SIZE - len + 1);
                    col = rand.nextInt(SIZE);
                    for (int i = 0; i < len; i++) {
                        grid[row + i][col] = word.charAt(i);
                    }
                    break;

                case 2: // 대각선
                    row = rand.nextInt(SIZE - len + 1);
                    col = rand.nextInt(SIZE - len + 1);
                    for (int i = 0; i < len; i++) {
                        grid[row + i][col + i] = word.charAt(i);
                    }
                    break;
            }

            // 출력
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(grid[i][j] + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
