package com.shinhan.day06;
//자식 CheckingAccount, 실행테스트InheritenceTest3

//extends Object는 생력되어있음. 모든클래스는 상속받게 되어 있음.
//JavaBeans기술 규격서 : field는 접근제한자를 private, 외부에서는 getter/setter접근

//final : 최종을 의미
//final class : 상속불가
//final field : 1회만 할당(선언시,생성시), 수정불가능.
//final static field : 상수 (1회할당, 선언시 또는 static block)
//final method : 재정의 불가
public class Account extends Object{ 
	
	//final 값 할당 안하면 오류남.
	private final String name = "우리은행"; //1.선언시 한번 할당.
	private final String name2; //final 2.생성시 한번 할당 가능.
	private static final String NAME3 = "우리은행"; //3.상수 static
	private static final String NAME4; 
	static {
		NAME4 = "우리은행";
	}
	final void method1() {
		System.out.println("자식이 재정의불가");
	}
	
	private String accountNo;//생성자,setter를 이용해야 접근 가능.
	private String ownerName;
	private int balance;
	
	// 자식 class 오류 해결 방법 : 아무일도 하지 않는 기본 생성자 추가
		/*
		public Account() {
			// default 생성자
		}
		*/
	
	//생성자 : 정의하지 않으면 컴파일러가 default생성자를 만든다.
	//		 정의하면 만들어주지않는다.
	//생성자 추가(argument가 3개) CheckingAccount오류남.
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
		
		name2="우리은행";
	}

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance < amount) {
			System.out.println("잔고부족. 출금불가");
			return 0;
		}
		balance -= amount;
		return amount;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//우클릭>Source>toString()
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	//field 추가
	protected String title="protected field연습";
	//메서드 추가
	protected void print() {
		System.out.println("protected 접근제한자연습");
	}
}
