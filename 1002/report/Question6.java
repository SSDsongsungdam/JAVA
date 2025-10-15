package sungdam;

class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")의 점";
    }
}

class PositivePoint extends Point {
    public PositivePoint() {
        super(1, 1); // 기본값 (1,1)
    }

    public PositivePoint(int x, int y) {
        super(x > 0 && y > 0 ? x : 1, y > 0 && y > 0 ? y : 1);
    }

    @Override
    protected void move(int x, int y) {
        // 이동 시에도 음수 좌표 불가
        if (x > 0 && y > 0)
            super.move(x, y);
    }
}

public class Question6 {
    public static void main(String[] args) {
        PositivePoint p = new PositivePoint(10, 10);
        p.move(5, 5);
        System.out.println(p.toString() + "입니다.");

        p.move(2, -2);  // 음수 좌표 → 이동 없음
        System.out.println(p.toString() + "입니다.");

        PositivePoint q = new PositivePoint(-10, -10); // 음수 좌표 → (1,1)
        System.out.println(q.toString() + "입니다.");
    }
}
