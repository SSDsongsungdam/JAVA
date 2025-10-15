package sungdam;

import java.util.Scanner;
import java.util.Arrays;

class BaseArray {
    protected int array[];
    protected int nextIndex = 0;
    
    public BaseArray(int size) {
        array = new int[size];
    }
    
    public int length() {
        return array.length;
    }
    
    public void add(int n) {
        if(nextIndex == array.length) return;
        array[nextIndex] = n;
        nextIndex++;
    }
    
    public void print() {
        for(int n : array) System.out.print(n + " ");
        System.out.println();
    }
}

class SortedArray extends BaseArray {
    public SortedArray(int size) {
        super(size);
    }
    
    @Override
    public void add(int n) {
        if(nextIndex == array.length) return;
        array[nextIndex] = n;
        nextIndex++;
        
        // 삽입 정렬 방식으로 정렬된 상태 유지
        for(int i = nextIndex - 1; i > 0; i--) {
            if(array[i] < array[i-1]) {
                int temp = array[i];
                array[i] = array[i-1];
                array[i-1] = temp;
            } else {
                break;
            }
        }
    }
}

public class Question10 {
    public static void main(String[] args) {
        SortedArray sArray = new SortedArray(10);
        Scanner scanner = new Scanner(System.in);
        System.out.print(">>");
        for(int i=0; i<sArray.length(); i++) {
            int n = scanner.nextInt();
            sArray.add(n);
        }
        sArray.print();
        scanner.close();
    }
}