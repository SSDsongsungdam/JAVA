package sungdam;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner one = new Scanner(System.in);
		System.out.print("$1=1200원입니다 달러를 입력하세요>>");
		int daler1 = one.nextInt();
		int daler2 = daler1*1200;
		System.out.print("$"+daler1+"는 "+daler2+"원입니다");
		
		one.close();
	}
	
}
