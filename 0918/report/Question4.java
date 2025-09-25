package sungdam;

public class Question4 {
    public static void main(String[] args) {
        // 문제 4: 다음 2차원 배열 n을 실행 시켜와 같이 출력하는 프로그램을 작성하라
        int[][] n = {{1,2,3}, {1,2}, {1}, {1,2,3}, {1,2,3,4}};
        
        for(int i = 0; i < n.length; i++) {
            for(int j = 0; j < n[i].length; j++) {
                System.out.print(n[i][j]);
                if(j < n[i].length - 1) {
                    System.out.print("\t"); // 탭으로 구분
                }
            }
            System.out.println(); // 다음 행으로 이동
        }
    }
}