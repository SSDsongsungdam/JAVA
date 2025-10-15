package sungdam;

abstract class PairMap {
    protected String keyArray[];
    protected String valueArray[];
    
    abstract public String get(String key); // key 값으로 value 검색
    abstract public void put(String key, String value); // key와 value를 쌍으로 저장
                                                         // 기존에 key가 이미 저장되어 있으면 값을 value로 수정
    abstract public String delete(String key); // key 값을 가진 아이템(value와 함께) 삭제, 삭제된 value 값 리턴
    abstract public int length(); // 현재 저장된 아이템 개수 리턴
}

class Dictionary extends PairMap {
    private int count;
    
    public Dictionary(int capacity) {
        keyArray = new String[capacity];
        valueArray = new String[capacity];
        count = 0;
    }
    
    @Override
    public String get(String key) {
        for(int i = 0; i < count; i++) {
            if(keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }
    
    @Override
    public void put(String key, String value) {
        // 기존 key가 있는지 확인
        for(int i = 0; i < count; i++) {
            if(keyArray[i].equals(key)) {
                valueArray[i] = value; // 값 수정
                return;
            }
        }
        
        // 새로운 key-value 추가
        if(count < keyArray.length) {
            keyArray[count] = key;
            valueArray[count] = value;
            count++;
        }
    }
    
    @Override
    public String delete(String key) {
        for(int i = 0; i < count; i++) {
            if(keyArray[i].equals(key)) {
                String deletedValue = valueArray[i];
                // 뒤의 원소들을 앞으로 이동
                for(int j = i; j < count - 1; j++) {
                    keyArray[j] = keyArray[j + 1];
                    valueArray[j] = valueArray[j + 1];
                }
                count--;
                return deletedValue;
            }
        }
        return null;
    }
    
    @Override
    public int length() {
        return count;
    }
}

public class Question12 {
    public static void main(String[] args) {
        Dictionary dic = new Dictionary(10);
        
        dic.put("황기태", "자바");
        dic.put("이재문", "파이썬");
        dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정
        
        System.out.println("이재문의 값은 " + dic.get("이재문"));
        System.out.println("황기태의 값은 " + dic.get("황기태"));
        
        dic.delete("황기태");
        System.out.println("황기태의 값은 " + dic.get("황기태"));
    }
}