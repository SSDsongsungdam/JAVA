package sungdam;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "학번이 " + id + "인 " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // 같은 객체면 true
        if (obj == null || getClass() != obj.getClass()) return false;
        Student other = (Student) obj;
        return id == other.id && name.equals(other.name);
    }
}

public class Question1 {
    public static void main(String[] args) {
        Student a = new Student("황기태", 23);
        Student b = new Student("황기태", 77);

        System.out.println(a);

        if (a.equals(b))
            System.out.println("같은 학생입니다.");
        else
            System.out.println("다른 학생입니다.");
    }
}
