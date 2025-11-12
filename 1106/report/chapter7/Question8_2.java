package sungdam;

import java.util.*;

class Student {
    private String name;
    private String major;
    private int year;
    private double grade;

    public Student(String name, String major, int year, double grade) {
        this.name = name;
        this.major = major;
        this.year = year;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getMajor() { return major; }
    public int getYear() { return year; }
    public double getGrade() { return grade; }

    public void showInfo() {
        System.out.println("이름:" + name + "\t전공:" + major + "\t학번:" + year + "\t학점평균:" + grade);
    }
}

public class Question8_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Student> map = new HashMap<>();

        System.out.println("4명 이름, 전공, 학번, 학점 입력");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String name = sc.next();
            String major = sc.next();
            int year = sc.nextInt();
            double grade = sc.nextDouble();
            map.put(name, new Student(name, major, year, grade));
        }

        System.out.println("--------------------------------------");
        for (String key : map.keySet()) {
            map.get(key).showInfo();
        }
        System.out.println("--------------------------------------");

        // 장학생 출력
        System.out.print("장학생: ");
        for (Student s : map.values()) {
            if (s.getGrade() >= 4.0)
                System.out.print(s.getName() + " ");
        }
        System.out.println();
        System.out.println();

        // 이름으로 검색
        while (true) {
            System.out.print("학생 이름 >> ");
            String name = sc.next();
            if (name.equals("그만")) break;

            Student s = map.get(name);
            if (s == null)
                System.out.println(name + " 학생이 없습니다.");
            else
                s.showInfo();
        }

        sc.close();
    }
}
