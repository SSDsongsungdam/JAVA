package sungdam;

class Song {
    private String title;
    private String singer;
    private int year;
    private String lang;

    // 생성자
    public Song(String title, String singer, int year, String lang) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.lang = lang;
    }

    // 출력 메소드
    public void show() {
        System.out.println(year + "년 " + lang + "의 " + singer + "가 부른 " + title);
    }
}

public class Question5 {
    public static void main(String[] args) {
        Song song = new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국어");
        song.show();
    }
}
