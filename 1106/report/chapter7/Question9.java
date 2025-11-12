package sungdam;

import java.util.*;

// 추상 클래스 Shape
abstract class Shape {
    private int type; // 도형 종류 식별용 (1: Line, 2: Rect, 3: Circle)

    public Shape(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public abstract void draw(); // 도형을 그리는 추상 메서드
}

// Line 클래스
class Line extends Shape {
    public Line() {
        super(1);
    }

    @Override
    public void draw() {
        System.out.println("Line");
    }
}

// Rect 클래스
class Rect extends Shape {
    public Rect() {
        super(2);
    }

    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

// Circle 클래스
class Circle extends Shape {
    public Circle() {
        super(3);
    }

    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

// 메인 클래스
public class Question9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Shape> shapes = new Vector<>();

        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");

        while (true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int choice = sc.nextInt();

            if (choice == 1) { // 삽입
                System.out.print("Line(1), Rect(2), Circle(3)>>");
                int type = sc.nextInt();
                Shape s = null;

                switch (type) {
                    case 1: s = new Line(); break;
                    case 2: s = new Rect(); break;
                    case 3: s = new Circle(); break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        continue;
                }
                shapes.add(s);

            } else if (choice == 2) { // 삭제
                System.out.print("삭제할 도형의 위치>>");
                int index = sc.nextInt();

                if (index < 1 || index > shapes.size()) {
                    System.out.println("삭제할 수 없습니다.");
                } else {
                    shapes.remove(index - 1);
                }

            } else if (choice == 3) { // 모두 보기
                for (Shape s : shapes) {
                    s.draw();
                }

            } else if (choice == 4) { // 종료
                System.out.println("Beauty Graphic Editor를 종료합니다.");
                break;

            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}
