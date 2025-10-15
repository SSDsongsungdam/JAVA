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
}

class Point3D extends Point {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public void moveUp(int zPlus) {
        z += zPlus;
    }

    public void moveDown(int zMinus) {
        z -= zMinus;
    }

    // x, y, z 모두 이동하는 메서드
    public void move(int x, int y, int z) {
        super.move(x, y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")의 점";
    }
}

public class Question5 {
    public static void main(String[] args) {
        Point3D p = new Point3D(3, 2, 1);
        System.out.println(p.toString() + "입니다.");

        p.moveUp(3);   // z축 +3
        System.out.println(p.toString() + "입니다.");

        p.moveDown(2); // z축 -2
        System.out.println(p.toString() + "입니다.");

        p.move(5, 5, 2);
        System.out.println(p.toString() + "입니다.");

        p.move(100, 200, 300);
        System.out.println(p.toString() + "입니다.");
    }
}
