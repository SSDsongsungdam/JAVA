package sungdam;

import java.util.Scanner;

interface IStack {
    int capacity(); // 스택에 저장 가능한 개수 리턴
    int length(); // 스택에 현재 저장된 개수 리턴
    boolean push(String val); // 스택의 톱(top)에 문자열 저장하고 true 리턴
                              // 꽉 차서 불가능 false 리턴
    String pop(); // 스택의 톱(top)에 저장된 문자열 리턴, 스택이 비어 있으면 null 리턴
}

class StringStack implements IStack {
    private String[] stack;
    private int top;
    
    public StringStack(int capacity) {
        stack = new String[capacity];
        top = 0;
    }
    
    @Override
    public int capacity() {
        return stack.length;
    }
    
    @Override
    public int length() {
        return top;
    }
    
    @Override
    public boolean push(String val) {
        if(top == stack.length) {
            return false;
        }
        stack[top] = val;
        top++;
        return true;
    }
    
    @Override
    public String pop() {
        if(top == 0) {
            return null;
        }
        top--;
        return stack[top];
    }
}

public class Question11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("스택 용량>>");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기
        
        StringStack stack = new StringStack(capacity);
        
        while(true) {
            System.out.print("문자열 입력>>");
            String input = scanner.nextLine();
            
            if(input.equals("그만")) {
                break;
            }
            
            if(!stack.push(input)) {
                System.out.println("스택이 꽉 차서 " + input + " 저장 불가");
            }
        }
        
        System.out.print("스택에 저장된 문자열 팝 : ");
        while(stack.length() > 0) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}