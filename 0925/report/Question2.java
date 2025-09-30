package sungdam;

class Cube {
    private int width;
    private int height;
    private int depth;

    // 생성자
    public Cube(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    // 부피 반환
    public int getVolume() {
        return width * height * depth;
    }

    // 크기 증가
    public void increase(int w, int h, int d) {
        this.width += w;
        this.height += h;
        this.depth += d;
    }

    // 0 여부 확인
    public boolean isZero() {
        return (width == 0 || height == 0 || depth == 0);
    }
}

public class Question2 {
    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3);
        System.out.println("큐브의 부피는 " + cube.getVolume());

        cube.increase(1, 2, 3); // 가로, 세로, 높이 각각 1,2,3씩 증가
        System.out.println("큐브의 부피는 " + cube.getVolume());

        if (cube.isZero())
            System.out.println("큐브의 부피는 0");
        else
            System.out.println("큐브의 부피는 0이 아님");
    }
}
