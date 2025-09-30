package sungdam;

class Average {
    private int[] data = new int[10]; // 최대 10개 저장
    private int nextIndex = 0;        // 현재 저장된 개수

    // 데이터 저장
    public void put(int value) {
        if (nextIndex < data.length) {
            data[nextIndex] = value;
            nextIndex++;
        } else {
            System.out.println("더 이상 저장할 수 없습니다.");
        }
    }

    // 저장된 모든 값 출력
    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // 평균 계산
    public double getAvg() {
        if (nextIndex == 0) return 0; // 나눗셈 방지
        int sum = 0;
        for (int i = 0; i < nextIndex; i++) {
            sum += data[i];
        }
        return (double) sum / nextIndex;
    }
}

public class Question4 {
    public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10);   // 10 저장
        avg.put(15);   // 15 저장
        avg.put(100);  // 100 저장

        avg.showAll(); // 저장된 데이터 출력
        System.out.println("평균은 " + avg.getAvg());
    }
}
