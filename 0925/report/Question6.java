package sungdam;

class Rectangle {
    private int x, y;           // 좌표
    private int width, height;  // 크기

    // 생성자
    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // 사각형 정보 출력
    public void show() {
        System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
    }

    // 정사각형 여부 확인
    public boolean isSquare() {
        return width == height;
    }

    // 다른 사각형 포함 여부 확인
    public boolean contains(Rectangle r) {
        return (this.x < r.x &&
                this.y < r.y &&
                (this.x + this.width) > (r.x + r.width) &&
                (this.y + this.height) > (r.y + r.height));
    }
}

public class Question6 {
    public static void main(String[] args) {
        Rectangle a = new Rectangle(3, 3, 6, 6);   // 좌표 (3,3), 6x6
        Rectangle b = new Rectangle(4, 4, 2, 3);   // 좌표 (4,4), 2x3

        a.show();

        if (a.isSquare()) System.out.println("a는 정사각형입니다.");
        else System.out.println("a는 정사각형이 아닙니다.");

        if (a.contains(b)) System.out.println("a는 b를 포함합니다.");
        else System.out.println("a는 b를 포함하지 않습니다.");
    }
}
