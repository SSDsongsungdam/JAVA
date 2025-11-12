package sungdam;

import java.util.ArrayList;
import java.util.Scanner;

public class Question10 {
    private ArrayList<String> arrayList = new ArrayList<>();

    // src와 동일한 문자열을 모두 제거하는 메서드
    private void searchAndRemove(String src, int j) {
        while (j < arrayList.size()) {
            String dest = arrayList.get(j);
            if (src.equals(dest)) {
                arrayList.remove(j); // 동일한 문자열 제거
            } else {
                j++; // 다음 인덱스로 이동
            }
        }
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("문자열들을 입력하세요>>");
            String line = sc.nextLine();

            if (line.equals("그만"))
                break;

            // 공백을 기준으로 문자열 나누기
            String[] words = line.split(" ");

            // 모든 단어를 ArrayList에 추가
            for (String w : words)
                arrayList.add(w);

            // 중복 제거
            int i = 0;
            while (i < arrayList.size()) {
                String src = arrayList.get(i);
                searchAndRemove(src, i + 1);
                i++;
            }

            // 결과 출력
            for (String w : arrayList)
                System.out.print(w + " ");
            System.out.println();

            arrayList.clear(); // 다음 입력을 위해 초기화
        }

        sc.close();
    }

    public static void main(String[] args) {
        Question10 app = new Question10();
        app.run();
    }
}

