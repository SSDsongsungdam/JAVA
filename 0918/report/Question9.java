package sungdam;

public class Question9 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        
        // 0~255 범위의 랜덤 정수로 배열 채우기
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                array[i][j] = (int)(Math.random() * 256); // 0~255 범위
            }
        }
        
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        
        // 배열 출력
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                System.out.print(array[i][j]);
                if(j < 3) {
                    System.out.print("\t"); // 탭으로 구분
                }
            }
            System.out.println(); // 다음 행으로
        }
    }
}