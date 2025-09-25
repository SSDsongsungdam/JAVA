package sungdam;

public class Question1_2 {
    public static void main(String[] args) {
        int sum = 0, i = 1;
        do {
            sum = sum + i;
            i = i + 3;
        } while (i <= 50);
        System.out.println(sum);
    }
}
