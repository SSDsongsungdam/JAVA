package sungdam;

class VArray {
    private int[] arr;  // 내부 배열
    private int size;   // 현재 저장된 개수

    // 생성자
    public VArray(int capacity) {
        arr = new int[capacity];
        size = 0;
    }

    // 현재 배열의 용량 반환
    public int capacity() {
        return arr.length;
    }

    // 현재 저장된 원소 개수 반환
    public int size() {
        return size;
    }

    // 내부 배열 크기 2배로 확장
    private void expand() {
        int[] newArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // 맨 뒤에 원소 추가
    public void add(int value) {
        if (size == arr.length) {
            expand();
        }
        arr[size++] = value;
    }

    // 특정 위치에 삽입
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        if (size == arr.length) {
            expand();
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        size++;
    }

    // 특정 위치 값 삭제
    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
    }

    // 저장된 모든 원소 출력
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Question14 {
    public static void main(String[] args) {
        VArray v = new VArray(5); // 크기 5짜리 가변 배열
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        // 7개 저장 (중간에 expand 발생)
        for (int i = 0; i < 7; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        // 삽입
        v.insert(3, 100);
        v.insert(5, 200);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        // 삭제
        v.remove(10);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        // 5개 더 추가
        for (int i = 50; i < 55; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}
