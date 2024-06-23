// 2. BankAccount 라는 클래스 생성
// accountNumber(계좌번호), balance(잔액) 변수
// 생성자 1개 : accountNumber 를 초기화
// getter 가 모든 변수에 맞게 존재
// deposit(예금하기) : balance(잔액) 증가시키는 메서드 -> "~원 입금되었습니다."
// withdraw(출금하기) : balance(잔액) 감소시키는 메서드 -> 출금액보다 잔액이 적으면 "잔액이 부족합니다" 충분하면 "~원 출금되었습니다"

public class BankAccount {
    String accountNumber;
    int balance;

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int money){
        System.out.println("입금이 진행됩니다.");
        balance += money;
        System.out.println(money + "원 입금 되었습니다.");
    }

    public void withdraw(int money){
        System.out.println("출금이 진행됩니다.");
        balance -= money;
        System.out.println(money + "원 출금 되었습니다.");
    }


}
