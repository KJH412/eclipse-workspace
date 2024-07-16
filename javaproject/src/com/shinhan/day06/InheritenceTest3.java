package com.shinhan.day06;


//OOP(객체지향)특징 : 캡슐화(정보은닉,private), 상속(기존class물려받음,수정가능,추가가능(Override)),
//				   다형성(사용은 같지만 결과는 다르다)

public class InheritenceTest3 {

	public static void main(String[] args) {
//		method1();
//		method2();
//		method3();
		method4();
		
	}

	private static void method4() {
		Account acc1 = new Account("112", "김", 1000);
		//아래 세개 부모가 Account
		CheckingAccount acc2 = new CheckingAccount("113","양", 2000, "66-77"); //카드번호체크
		CreditLineAccount acc3 = new CreditLineAccount("114", "박", 3000, 2000); //마이너스한
		BonusPointAccount acc4 = new BonusPointAccount("115", "정", 4000, 4);
		
		//부모 Account에서 오버라이드 toString()으로 문자열 같은것 출력시킴.
		/*
		System.out.println(acc1);//주소가 뜸.com.shinhan.day06.Account@1eb44e46
		System.out.println(acc2); 
		System.out.println(acc3);
		System.out.println(acc4);  
		너무길어서 method5()에 담아 출력시키기.
		*/
		
		method5(acc1);
		method5(acc2);
		method5(acc3);
		method5(acc4);
//		method7();
	}
	private static void method5(Account acc) { //static. 같은()썼는데 다 다르게 나옴. 다형성
		System.out.println("------------------");
		System.out.println(acc);
		System.out.println("계좌번호: " + acc.getAccountNo());
		System.out.println("예금주: " + acc.getOwnerName());
		System.out.println("잔고: " + acc.getBalance());
		
//		CheckingAccount acc2 = (CheckingAccount)acc; 불가
		System.out.println(acc instanceof CheckingAccount); //CheckingAccount의 instance인지 물어봄.
		
		acc.deposit(5555);
		
		if(acc instanceof CheckingAccount) {
			//부모 = 자식
			//형제로 변경불가
			//자식 = (자식)부모  : 다시 자식으로 돌아감.
			CheckingAccount acc2 = (CheckingAccount)acc; //강제형변환. 초기문법
			System.out.println("카드번호: " + acc2.cardNo);
			acc2.pay("66-77", 100);
		}
		if(acc instanceof CreditLineAccount acc2) {//변수선언을 생략할때 (..acc2)안에 쓰면 됨.
			System.out.println("마이너스 한도: " + acc2.creditLine);
			int amount = acc2.withdraw(5000);
			System.out.println("출금액: "+ amount);
		}
		if(acc instanceof BonusPointAccount acc3) {
			System.out.println("보너스 포인트: " + acc3.bonusPoint);
		}
	}

	private static void method7() {
		//형변환
		//1)객체에서 자동형변환 : 부모의 타입방 = 자식의 타입 값
		Account acc = new CheckingAccount("113","양",2000,"66-77");
		//2)객체에서 강제형변환 : 자식타입방 = (자식의타입, 반드시 instance의타입)부모의 타입값
		CheckingAccount acc2 = (CheckingAccount)acc;  //CheckingAccount타입으로만 형변환.
		//CreditLineAccount acc2 = (CreditLineAccount)acc; //오류. CheckingAccount가 CreditLineAccount로 형제가 바뀔 순 없음 
	}
	private static void method6() {
		//형변환 
		//1)기본형 자동 : 큰방 = 작은값
		long bang;
		int data = 100;
		bang = data; //자동형변환 long이 int로
		
		//2)강제 (명시) : 작은방 = (작은방타입)큰값
		long data2 = 200;
		int bang2;
		bang2 = (int)data2; 
	}

	private static void method3() {
		BonusPointAccount acc1 = 
				new BonusPointAccount("1123", "길동", 1000, 1); //원래있던1포인트(0.001)
		acc1.deposit(5000); //5000입금해서 balance 잔고가 6000이 됨.
		
		System.out.println(acc1.getBalance());
		System.out.println(acc1.bonusPoint); //누적포인트 6000*0.001
	}

	private static void method2() {
		CreditLineAccount acc2 = 
				new CreditLineAccount("112", "현상", 2000, 1000);
		acc2.deposit(2000);
		int amount = acc2.withdraw(5000);
		System.out.println("출금액: " + amount);
	}

	private static void method1() {
		CheckingAccount acc1 = new CheckingAccount("111-222", "홍길동", 1000, "77-88");
		acc1.deposit(2000);
		int amount = acc1.withdraw(2000);
		
		System.out.println("출금액: " + amount);
		System.out.println("잔고: "+ acc1.getBalance());
		amount = acc1.pay("77-88", 800);
		
		amount = acc1.pay("77-99", 800);
		System.out.println("카드로인출: "+ amount);
	}

}
