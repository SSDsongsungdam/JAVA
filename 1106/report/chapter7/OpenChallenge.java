package sungdam;

import java.util.*;

// 단어를 나타내는 클래스
class Word {
    private String english;
    private String korean;

    public Word(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }
}

// 메인 퀴즈 클래스
public class OpenChallenge {
    private Vector<Word> v = new Vector<>();
    private Scanner sc = new Scanner(System.in);

    public OpenChallenge() {
        // 17개의 단어를 미리 추가
        v.add(new Word("painting", "그림"));
        v.add(new Word("emotion", "감정"));
        v.add(new Word("baby", "아기"));
        v.add(new Word("error", "오류"));
        v.add(new Word("bear", "곰"));
        v.add(new Word("eye", "눈"));
        v.add(new Word("picture", "사진"));
        v.add(new Word("love", "사랑"));
        v.add(new Word("human", "인간"));
        v.add(new Word("society", "사회"));
        v.add(new Word("animal", "동물"));
        v.add(new Word("student", "학생"));
        v.add(new Word("teacher", "교사"));
        v.add(new Word("game", "게임"));
        v.add(new Word("car", "자동차"));
        v.add(new Word("fruit", "과일"));
        v.add(new Word("computer", "컴퓨터"));
    }

    public void run() {
        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");

        while (true) {
            int problemIndex = (int)(Math.random() * v.size());
            Word problem = v.get(problemIndex);

            // 보기 생성 (정답 포함 4개)
            Vector<Word> options = new Vector<>();
            options.add(problem);

            while (options.size() < 4) {
                int r = (int)(Math.random() * v.size());
                Word w = v.get(r);
                if (!options.contains(w)) {
                    options.add(w);
                }
            }

            // 보기 순서 랜덤 섞기
            Collections.shuffle(options);

            // 문제 출력
            System.out.println(problem.getEnglish() + "?");
            for (int i = 0; i < options.size(); i++) {
                System.out.print("(" + (i + 1) + ")" + options.get(i).getKorean() + " ");
            }
            System.out.print(":-) ");

            int answer = sc.nextInt();
            if (answer == -1) {
                System.out.println("\"명품영어\"를 종료합니다...");
                break;
            }

            if (options.get(answer - 1) == problem)
                System.out.println("Excellent !!");
            else
                System.out.println("No. !!");
        }
    }

    public static void main(String[] args) {
        OpenChallenge quiz = new OpenChallenge();
        quiz.run();
    }
}
