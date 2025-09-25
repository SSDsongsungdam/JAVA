package sungdam;

import java.util.Scanner;

public class Question13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] course = {"C", "C++", "Python", "Java", "HTML5"};
        String[] grade = {"A", "B+", "B", "A+", "D"};
        
        while(true) {
            System.out.print("과목>>");
            String courseName = scanner.nextLine();
            
            if(courseName.equals("그만")) {
                break;
            }
            
            // 과목명 검색
            boolean found = false;
            for(int i = 0; i < course.length; i++) {
                if(course[i].equals(courseName)) {
                    System.out.println(courseName + " 학점은 " + grade[i]);
                    found = true;
                    break;
                }
            }
            
            if(!found) {
                System.out.println(courseName + "는 없는 과목입니다.");
            }
        }
        
        scanner.close();
    }
}