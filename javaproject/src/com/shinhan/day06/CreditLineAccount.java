package com.shinhan.day06;

public class CreditLineAccount extends Account{
	
	int creditLine; //마이너스 한도 field


	public CreditLineAccount(String accountNo, String ownerName,
									int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}
	
	//인출한다 메서드는 부모의 로직을 사용한다...재정의를 원한다. (인출금액이 잔고보다 마이너스한도까지 커짐.)
	//override(재정의, 덮어쓰기)
	//이름, 매개변수타입과 개수, return모두 같아야한다. modifier는 같거나 더 넓어져야한다. => public
	@Override
	public int withdraw(int amount) {
//		if (balance < amount) {
		if (getBalance() < amount) {		
			System.out.println("잔고부족. 출금불가");
			return 0;
		}
//		balance -= amount;
		setBalance(getBalance()-amount);
		return amount;
	}

	@Override
	public String toString() {
		return "CreditLineAccount"+ super.toString() +"[CreditLine=" + creditLine + "]";
	}
	
//	Book f1() {
////		Book b = new Book();
////		b.title = "AA";
////		b.price = 1000;
////		return = b;
//		
////		return new Booke("AA",1000,b); ?
//	}
//	
//
//	class Book{
//		String title;
//		int price;
//		
//		Book(String title, int price) {
//			this.title = title;
//			this.price = price;
//		}
//	}
	
	
}
