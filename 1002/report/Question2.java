package sungdam;

class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    private int color;

    public ColorTV(int size, int color) {
        super(size);
        this.color = color;
    }

    protected int getColor() {
        return color;
    }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + getColor() + "컬러");
    }
}

class SmartTV extends ColorTV {
    private String ip;

    public SmartTV(String ip, int size, int color) {
        super(size, color);
        this.ip = ip;
    }

    @Override
    public void printProperty() {
        System.out.println("나의 SmartTV는 " + ip + " 주소의 " 
            + getSize() + "인치 " + getColor() + "컬러");
    }
}

public class Question2 {
    public static void Question2(String[] args) {
        SmartTV smartTV = new SmartTV("192.168.0.5", 77, 2000000);
        smartTV.printProperty();
    }
}
