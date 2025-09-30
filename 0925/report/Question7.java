package sungdam;

class Memo {
    private String name;    // 작성자
    private String time;    // 작성 시간
    private String content; // 메모 텍스트

    // 생성자
    public Memo(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

    // 작성자 이름이 같은지 확인
    public boolean isSameName(Memo m) {
        return this.name.equals(m.name);
    }

    // 작성자 이름 반환
    public String getName() {
        return name;
    }

    // 메모 출력
    public void show() {
        System.out.println(name + ", " + time + " " + content);
    }

    // 메모 길이 반환
    public int length() {
        return content.length();
    }
}

public class Question7 {
    public static void main(String[] args) {
        Memo a = new Memo("유승연", "10:10", "자바 과제 있음");
        Memo b = new Memo("박재원", "10:15", "사고를 유연하게 연습하자!");
        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요..");

        a.show();

        if (a.isSameName(b)) System.out.println("동일한 사람입니다.");
        else System.out.println("다른 사람입니다.");

        System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
    }
}
