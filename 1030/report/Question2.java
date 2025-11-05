package sungdam;

class Book {
    private String author;  // 저자
    private String title;   // 도서명
    private String buyer;   // 구입자

    // 생성자
    public Book(String author, String title, String buyer) {
        this.author = author;
        this.title = title;
        this.buyer = buyer;
    }

    // toString() 재정의
    @Override
    public String toString() {
        return buyer + "이 구입한 도서: " + author + "의 " + title;
    }

    // equals() 재정의 - 저자와 도서명이 같으면 같은 책
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return author.equals(other.author) && title.equals(other.title);
    }
}

public class Question2 {
    public static void main(String[] args) {
        Book a = new Book("황기태", "명품자바", "김하진");
        Book b = new Book("황기태", "명품자바", "하연빈");

        System.out.println(a);
        System.out.println(b);

        if (a.equals(b))
            System.out.println("같은 책");
        else
            System.out.println("다른 책");
    }
}
