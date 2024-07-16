package com.shinhan.lab.lab6;

class Account{
	private String accNo;
	private int balance;
	
	public Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		//(☆★☆★)
		System.out.println(accNo + " 계좌가 개설되었습니다.");
		System.out.println(accNo + " 계좌의 잔고는" + balance +"입니다.");
	}
	public String getAccNo() {
		return accNo;
	}

	public int getBalance() {
		return balance;
	}
	
	//잔고 (☆★☆★)
	public void save(int money) {
		// TODO Auto-generated method stub
		System.out.println(accNo+" 계좌의 잔고는 "+ balance + "원 입니다.");
	}
	//입금 (☆★☆★)리턴
	public int deposit(int money) {
		
		if(money>0) {
			balance += money;
			System.out.println(accNo+" 계좌에 "+ money + "원이 입금되었습니다.");
			System.out.println(accNo+" 계좌의 잔고는 "+ balance + "원 입니다.");
			return money;
		}else {
			return 0;
		}

	}
	//출금 (☆★☆★)리턴
	public int withdraw(int money) {
		if(balance>=money) {
			balance -= money;
			System.out.println(accNo+" 계좌에 "+ money + "원이 출금되었습니다.");
			save(balance);  //(☆★☆★)
			return money; 
		}else {
			System.out.println("잔고가 부족합니다!");
			return 0;
		}
	}
	
	
}

public class lab2 {//TestAccount 

	public static void main(String[] args) {
		Account acc = new Account("078-3762-293", 1000000);
		acc.deposit(2000000);
		acc.withdraw(500000);

	}

}
