package com.shinhan.day05;

//챕터6 19번
public class Account {
	private int balance;
	static final int MIN_BALANCE = 0; //상수 선언
	static final int MAX_BALANCE = 100000000;
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
//		if(balance<MIN_BALANCE || balance>MAX_BALANCE) return;
		if(balance>=MIN_BALANCE && balance<=MAX_BALANCE) {
			this.balance = balance;
		}
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		
		account.setBalance(10000);
		System.out.println("현재잔고는 " + account.getBalance());
		account.setBalance(-100);
		System.out.println("현재잔고는 " + account.getBalance());
		account.setBalance(200000);
		System.out.println("현재잔고는 " + account.getBalance());
		account.setBalance(300000);
		System.out.println("현재잔고는 " + account.getBalance()); 
		//MAX_BALANCE=100값이 작아서 0이 출력됐음. 가격 크게 수정함.
	}
	
}
