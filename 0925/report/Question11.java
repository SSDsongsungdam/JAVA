package sungdam;

class ArrayUtil {
    // 두 배열을 연결한 새 배열 반환
    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i];
        }
        for (int i = 0; i < b.length; i++) {
            result[a.length + i] = b[i];
        }
        return result;
    }

    // 배열 출력
    public static void print(int[] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i != a.length - 1) System.out.print(" ");
        }
        System.out.println(" ]");
    }
}

public class Question11 {
    public static void main(String[] args) {
        int[] array1 = { 1, 5, 7, 9 };
        int[] array2 = { 3, 6, -1, 100, 77 };

        int[] array3 = ArrayUtil.concat(array1, array2); // 두 배열 합치기
        ArrayUtil.print(array3); // 합쳐진 배열 출력
    }
}
