package sungdam;

import java.util.*;

public class Question11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        // 1. 사람 이름과 걸음 수 입력
        while (true) {
            System.out.print("이름과 걸음수>>");
            String line = sc.nextLine();

            if (line.equals("그만"))
                break;

            String[] parts = line.split(" ");
            String name = parts[0];
            ArrayList<Integer> list = map.getOrDefault(name, new ArrayList<>());

            for (int i = 1; i < parts.length; i++) {
                list.add(Integer.parseInt(parts[i]));
            }
            map.put(name, list);
        }

        // 2. 걸음 수가 가장 많은 사람 찾기
        String maxName = null;
        int maxTotal = 0;

        for (String name : map.keySet()) {
            ArrayList<Integer> list = map.get(name);
            int sum = 0;
            for (int step : list)
                sum += step;

            if (sum > maxTotal) {
                maxTotal = sum;
                maxName = name;
            }
        }

        if (maxName != null)
            System.out.println("걸음수가 가장 많은 사람은 " + maxName + " " + maxTotal + "보");

        // 3. 이름 검색
        while (true) {
            System.out.print("검색할 이름>>");
            String name = sc.nextLine();
            if (name.equals("그만"))
                break;

            ArrayList<Integer> list = map.get(name);
            if (list == null) {
                System.out.println(name + "은(는) 없는 학생입니다.");
            } else {
                int sum = 0;
                for (int s : list) {
                    System.out.print(s + " ");
                    sum += s;
                }
                double avg = (double) sum / list.size();
                System.out.println("평균 " + Math.round(avg));
            }
        }

        sc.close();
    }
}
