package sungdam;

public class Question2_2 {
    public static void main(String[] args) {
        int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
        int i = 0;
        do {
            if (n[i] % 2 == 0 && n[i] % 4 == 0) {
                System.out.print(n[i] + " ");
            }
            i++;
        } while (i < n.length);
    }
}