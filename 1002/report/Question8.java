package sungdam;

abstract class Box {
    protected int size; // 현재 박스에 들어 있는 재료의 양
    
    public Box(int size) { // 생성자
        this.size = size;
    }
    
    public boolean isEmpty() { 
        return size == 0; 
    } // 박스가 빈 경우 true 리턴
    
    public abstract boolean consume(); // 박스에 들어 있는 재료를 일정량 소비
    
    public abstract void print(); // 박스에 들어 있는 양을 "*" 문자로 출력
}

class IngredientBox extends Box {
    private String name;
    
    public IngredientBox(String name, int size) { // 생성자
        super(size);
        this.name = name;
    }
    
    @Override
    public boolean consume() {
        if (size > 0) {
            size--;
            return true;
        }
        return false;
    }
    
    @Override
    public void print() {
        System.out.print(name + " ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println(size); // 숫자 출력 추가
    }
    
    public String getName() {
        return name;
    }
}

public class Question8 {
    public static void main(String[] args) {
        System.out.println("*****정출 커피 자판기입니다.*****");
        
        IngredientBox coffee = new IngredientBox("커피", 5);
        IngredientBox cream = new IngredientBox("프림", 5);
        IngredientBox sugar = new IngredientBox("설탕", 5);
        
        coffee.print();
        cream.print();
        sugar.print();
        
        // 다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>1
        System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>1");
        coffee.consume();
        cream.consume();
        sugar.consume();
        coffee.print();
        cream.print();
        sugar.print();
        
        // 다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>2
        System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>2");
        coffee.consume();
        sugar.consume();
        coffee.print();
        cream.print();
        sugar.print();
        
        // 다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>3
        System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>3");
        coffee.consume();
        coffee.print();
        cream.print();
        sugar.print();
        
        // 다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>3
        System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>3");
        coffee.consume();
        coffee.print();
        cream.print();
        sugar.print();
        
        // 다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>2
        System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>2");
        coffee.consume();
        sugar.consume();
        coffee.print();
        cream.print();
        sugar.print();
        
        // 다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>1
        System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>1");
        System.out.println("원료가 부족합니다.");
        coffee.print();
        cream.print();
        sugar.print();
        
        // 다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>4
        System.out.println("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>4");
        System.out.println("종료 커피 자판기 프로그램을 종료합니다");
    }
}