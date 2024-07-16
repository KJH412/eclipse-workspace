package day04;

public class Account {
	//1.field
	String accNo;
	int balance;
	
	//2.생성자
	Account(String accNo, int balance){
		this.accNo = accNo;
		this.balance = balance;
		System.out.println(accNo + "계좌가 개설되었습니다.");
		//System.out.println(accNo + "계좌의 잔고는"+balance+"입니다.");
		print();
	}
	void deposit(int amount) { //입금
		balance += amount;
		System.out.println(accNo + "계좌에"+ amount +"원이 입금되었습니다.");
//		System.out.println(accNo + "계좌의 잔고는"+ balance +"입니다.");
		print();
	}
	void withdraw(int amount) {
		balance -= amount;
		System.out.println(accNo + "계좌에"+ amount +"원이 출금되었습니다.");
		//System.out.println(accNo + "계좌의 잔고는"+ balance +"입니다.");
		print();
	}
	
	
	void print(){
		System.out.println(accNo + "계좌의 잔고는"+ balance +"입니다.");
	}
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}
	
}
