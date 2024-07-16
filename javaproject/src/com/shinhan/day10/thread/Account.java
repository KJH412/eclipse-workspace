package com.shinhan.day10.thread;
//예제
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor //기본생성자
@AllArgsConstructor //생성자
public class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	//입금
	public void deposit(int amount) {
		balance += amount;
	}
	//출금
	int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			return amount;
		} else {
			System.out.println("잔고부족");
			return 0;
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [accountNo=");
		builder.append(accountNo);
		builder.append(", ownerName=");
		builder.append(ownerName);
		builder.append(", balance=");
		builder.append(balance);
		builder.append("]");
		return builder.toString();
	}
	
}
