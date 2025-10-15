package sungdam;

import java.util.Scanner;

abstract class Calc {
    protected String errorMsg;
    protected int a, b;
    
    public void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    abstract public int calculate();
}

class Add extends Calc {
    @Override
    public int calculate() {
        return a + b;
    }
}

class Sub extends Calc {
    @Override
    public int calculate() {
        return a - b;
    }
}

class Mul extends Calc {
    @Override
    public int calculate() {
        return a * b;
    }
}

class Div extends Calc {
    @Override
    public int calculate() {
        if(b == 0) {
            errorMsg = "0으로 나눌 수 없음. 프로그램 종료";
            return 0;
        }
        return a / b;
    }
}

public class Question13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.print("두 정수와 연산자를 입력하시오>>");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            String operator = scanner.next();
            
            Calc calc = null;
            
            switch(operator) {
                case "+":
                    calc = new Add();
                    break;
                case "-":
                    calc = new Sub();
                    break;
                case "*":
                    calc = new Mul();
                    break;
                case "/":
                    calc = new Div();
                    break;
                default:
                    System.out.println("잘못된 연산자입니다.");
                    continue;
            }
            
            calc.setValue(num1, num2);
            int result = calc.calculate();
            
            if(calc.errorMsg != null) {
                System.out.println(calc.errorMsg);
                break;
            } else {
                System.out.println("계산 결과 " + result);
            }
        }
        
        scanner.close();
    }
}