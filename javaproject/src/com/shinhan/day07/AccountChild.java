package com.shinhan.day07;

import com.shinhan.day06.Account;

public class AccountChild extends Account{ 
	//extends Account 붙이면 에러남. Account에 default생성자가 없어서그럼.
	
	public AccountChild(){
		        super("", "", 0); // 명시적 초기화
		
	}
	void test() {
		System.out.println(title);
		print();
	}
}
//상속 받지 않은 경우 protected는 같은 패키지에서만 접근이 가능하다
//class Account2 {
//void test() {
//   Account acc = new Account("", "", 0);
//   System.out.println(acc.title);
//   acc.print();
//}
//}
