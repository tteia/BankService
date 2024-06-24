// 1. BankService 라는 클래스 생성 => main 메서드에서 BankAccount 객체 생성 후 입출금 등 테스트

// while(true){} : 어떤 서비스 이용할지 질문.
// 1. 계좌 개설 2. 입금 3. 출금 4.계좌 송금
// 1-1. 계좌 번호를 입력하세요. 1-2. list 에 담기.
// 2-1. 입금 금액을 입력하세요.
// 3-1. 출금 금액을 입력하세요.
// 4-1. 입금 받는 사람을 입력하세요. 4-2. 계좌번호 찾기. 입금 금액을 입력하세요.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BankAccount> accountList = new ArrayList<>();
        while(true){
            System.out.println("이용하실 서비스를 선택해주세요.");
            System.out.println("1. 계좌 개설 2. 입금 3. 출금 4. 계좌 송금");
            System.out.println("===================================");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                System.out.println("계좌 개설을 선택하셨습니다.");
                System.out.println("계좌 번호를 입력하세요.");
                String newAccountNumber = sc.nextLine();
                BankAccount newAccount = new BankAccount(newAccountNumber);
                accountList.add(newAccount);
                System.out.println("계좌 개설이 완료되었습니다. 신규 계좌번호 : " + newAccount.accountNumber);
                System.out.println("===================================");
            }
            else if(choice == 2){
                System.out.println("입금을 선택하셨습니다.");
                System.out.println("입금하실 계좌번호를 입력하세요.");
                String myAccount = sc.nextLine();
                BankAccount bankAccount = findAccount(accountList, myAccount);
                if (bankAccount != null) {
                    System.out.println(myAccount + " 로 입금하실 금액을 입력하세요.");
                    int money = sc.nextInt();
                    bankAccount.deposit(money);
                    System.out.println("===================================");
                } else {
                    System.out.println("존재하지 않는 계좌번호입니다.");
                }
            }
            else if(choice == 3){
                System.out.println("출금을 선택하셨습니다.");
                System.out.println("출금하실 계좌번호를 입력하세요.");
                String myAccount = sc.nextLine();
                BankAccount bankAccount = findAccount(accountList, myAccount);
                if (bankAccount != null) {
                    System.out.println(myAccount + " 로 출금하실 금액을 입력하세요.");
                    int money = sc.nextInt();
                    bankAccount.withdraw(money);
                    System.out.println("===================================");
                } else {
                    System.out.println("존재하지 않는 계좌번호입니다.");
                }
            }
            else if(choice == 4){
                System.out.println("계좌 송금을 선택하셨습니다.");
                System.out.println("출금하실 계좌를 입력해주세요.");
                String myAccount = sc.nextLine();
                BankAccount bankAccount = findAccount(accountList, myAccount);

                if (bankAccount != null) {
                    System.out.println("송금하실 금액을 입력해주세요.");
                    int money = sc.nextInt();
                    sc.nextLine();
                    System.out.println("상대방 계좌를 입력해주세요.");
                    String opponentAccount = sc.nextLine();
                    BankAccount opponentBankAccount = findAccount(accountList, opponentAccount);
                    if (opponentBankAccount != null) {
                        System.out.println(myAccount + " 에서 " + opponentAccount + " 로 " + money + " 원 송금이 진행됩니다.");
                        System.out.println("===================================");
                        bankAccount.transfer(opponentBankAccount, money);
                        System.out.println("===================================");
                    } else {
                        System.out.println("존재하지 않는 상대방 계좌번호입니다.");
                    }
                } else {
                    System.out.println("존재하지 않는 계좌번호입니다.");
                }
            }
        }
    }

    public static BankAccount findAccount(List<BankAccount> accountList, String accountNumber) {
        for (BankAccount account : accountList) {
            if (account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}



