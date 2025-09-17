package sungdam;

import java.util.Scanner;

public class OpenChallenge {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		System.out.print("철수 >>");
		String male = scanner.next();
		System.out.printf("영희 >>");
		String woman = scanner.next();
		
		if(male.equals(woman)) {
			System.out.println("비겼습니다");
		}else if(male.equals("가위")&& woman.equals("보")||
				male.equals("바위")&& woman.equals("가위")||
				male.equals("보")&& woman.equals("바위")
				) {
			System.out.print("철수가 이겼습니다");
		}else {
			System.out.print("영희가 이겼습니다");
		}
		scanner.close();
	}
}
