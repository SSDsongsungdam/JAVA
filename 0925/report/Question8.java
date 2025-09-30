package sungdam;

class Account {
    private int balance; // 잔액

    // 생성자
    public Account(int balance) {
        this.balance = balance;
    }

    // 단일 금액 입금
    public void deposit(int money) {
        balance += money;
    }

    // 배열로 여러 금액 입금
    public void deposit(int[] moneyArr) {
        for (int m : moneyArr) {
            balance += m;
        }
    }

    // 출금 (잔액 부족하면 가능한 만큼만 출금)
    public int withdraw(int money) {
        if (balance >= money) {
            balance -= money;
            return money;
        } else {
            int temp = balance;
            balance = 0;
            return temp;
        }
    }

    // 잔액 조회
    public int getBalance() {
        return balance;
    }
}

public class Question8 {
    public static void main(String[] args) {
        Account a = new Account(100); // 100원 예금
        a.deposit(5000);
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int[] bulk = {100, 500, 200, 700};
        a.deposit(bulk);
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int money = 1000;
        int wMoney = a.withdraw(money);
        if (wMoney < money)
            System.out.println(money + "원 인출 못합니다. " + wMoney + "원만 인출합니다.");
        else
            System.out.println(money + "원 인출하였습니다.");

        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
    }
}
