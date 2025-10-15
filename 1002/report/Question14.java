package sungdam;

import java.util.Scanner;

public abstract class Shape {
    private Shape next;
    
    public Shape() { next = null; }
    
    public void setNext(Shape obj) { next = obj; } // 링크 연결
    
    public Shape getNext() { return next; }
    
    public abstract void draw(); // 추상 메소드
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("Rect");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class GraphicEditor {
    private Scanner scanner = new Scanner(System.in);
    private Shape head = null; // 연결 리스트의 head
    
    public GraphicEditor() {
        System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
    }
    
    public void run() {
        while(true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            int menu = scanner.nextInt();
            
            switch(menu) {
                case 1:
                    insert();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    System.out.println("Beauty Graphic Editor를 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
    
    private void insert() {
        System.out.print("Line(1), Rect(2), Circle(3)>>");
        int type = scanner.nextInt();
        
        Shape shape = null;
        switch(type) {
            case 1:
                shape = new Line();
                break;
            case 2:
                shape = new Rect();
                break;
            case 3:
                shape = new Circle();
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }
        
        // 리스트의 맨 끝에 추가
        if(head == null) {
            head = shape;
        } else {
            Shape current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(shape);
        }
    }
    
    private void delete() {
        System.out.print("삭제할 도형의 위치>>");
        int position = scanner.nextInt();
        
        if(head == null) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }
        
        // 첫 번째 노드 삭제
        if(position == 1) {
            head = head.getNext();
            return;
        }
        
        // position-1번째 노드 찾기
        Shape current = head;
        for(int i = 1; i < position - 1; i++) {
            if(current == null || current.getNext() == null) {
                System.out.println("삭제할 수 없습니다.");
                return;
            }
            current = current.getNext();
        }
        
        if(current.getNext() == null) {
            System.out.println("삭제할 수 없습니다.");
            return;
        }
        
        // position번째 노드 삭제
        current.setNext(current.getNext().getNext());
    }
    
    private void showAll() {
        Shape current = head;
        while(current != null) {
            current.draw();
            current = current.getNext();
        }
    }
}

public class Question14 {
    public static void main(String[] args) {
        GraphicEditor editor = new GraphicEditor();
        editor.run();
    }
}