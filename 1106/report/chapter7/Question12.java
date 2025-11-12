package sungdam;

import java.util.*;

public class Question12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String[]> program = new ArrayList<>();
        HashMap<String, Integer> vars = new HashMap<>();

        System.out.println("나의 가상 컴퓨터가 작동합니다. 프로그램을 입력해주세요. go를 입력하면 작동합니다.");

        // 1. 프로그램 입력
        while (true) {
            System.out.print(program.size() + 1 + ">> ");
            String line = sc.nextLine().trim();

            if (line.equals("go")) break;

            String[] tokens = line.split(" ");
            program.add(tokens);

            if (tokens[0].equals("exi")) break; // 프로그램 종료 명령도 입력 가능
        }

        // 2. 프로그램 실행
        int pc = 0; // program counter

        while (pc < program.size()) {
            String[] cmd = program.get(pc);
            String inst = cmd[0];

            switch (inst) {
                case "mov": {
                    String var = cmd[1];
                    String val = cmd[2];
                    int num = getValue(val, vars);
                    vars.put(var, num);
                    pc++;
                    break;
                }

                case "add": {
                    String var = cmd[1];
                    String val = cmd[2];
                    int result = vars.getOrDefault(var, 0) + getValue(val, vars);
                    vars.put(var, result);
                    pc++;
                    break;
                }

                case "sub": {
                    String var = cmd[1];
                    String val = cmd[2];
                    int result = vars.getOrDefault(var, 0) - getValue(val, vars);
                    vars.put(var, result);
                    pc++;
                    break;
                }

                case "jn0": {
                    String var = cmd[1];
                    int jump = Integer.parseInt(cmd[2]) - 1; // 줄 번호는 1부터 시작
                    if (vars.getOrDefault(var, 0) != 0) {
                        pc = jump;
                    } else {
                        pc++;
                    }
                    break;
                }

                case "prt": {
                    String var = cmd[1];
                    int val = vars.getOrDefault(var, 0);
                    System.out.println("[prt " + var + "] sum변수 값: " + val);
                    pc++;
                    break;
                }

                case "exi": {
                    System.out.println("프로그램 실행 종료.");
                    pc = program.size(); // 강제 종료
                    break;
                }

                default:
                    System.out.println("알 수 없는 명령어: " + inst);
                    pc++;
                    break;
            }
        }

        // 3. 변수 상태 출력
        System.out.println("변수들의 최종 값을 출력합니다.");
        for (String key : vars.keySet()) {
            System.out.println(key + ":" + vars.get(key));
        }

        sc.close();
    }

    // 숫자 혹은 변수 이름을 처리하는 함수
    private static int getValue(String s, HashMap<String, Integer> vars) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return vars.getOrDefault(s, 0);
        }
    }
}
