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

class Point3DColor extends Point {
    private int z;
    private String color;

    public Point3DColor(int x, int y, int z, String color) {
        super(x, y);
        this.z = z;
        this.color = color;
    }

    public void move(Point3DColor p) {
        // 다른 Point3DColor 점으로 이동
        super.move(p.getX(), p.getY());
        this.z = p.z;
        this.color = p.color;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")" + color + "점";
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point3DColor))
            return false;
        Point3DColor p = (Point3DColor) obj;
        // 위치와 색상이 모두 같을 때 true
        return (getX() == p.getX() && getY() == p.getY() && this.z == p.z && this.color.equals(p.color));
    }
}

public class Question7 {
    public static void main(String[] args) {
        Point3DColor p = new Point3DColor(10, 20, 30, "RED");
        System.out.println(p.toString() + "입니다.");

        Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
        System.out.println(q.toString() + "입니다.");

        p.move(q);  // p를 q의 위치로 이동
        System.out.println(p.toString() + "입니다.");

        Point3DColor r = new Point3DColor(1, 2, 3, "RED");
        if (p.equals(r))
            System.out.println("예. 같은 위치 같은 색깔의 점입니다.");
        else
            System.out.println("아니오");
    }
}
