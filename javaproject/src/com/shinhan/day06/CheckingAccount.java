package com.shinhan.day06;

public class CheckingAccount extends Account {
	
	//1.상속 후 field추가
	String cardNo;
	
	//직접 set으로 부르지 않아도 됨
	
	//2.생성자정의...부모의 생성자를 명시적으로 호출
	//부모의 field가 private로 되어있는경우
	//자식은 값을 setting하기 이해 1.생성자이용 2.setter이용
	public CheckingAccount(String accountNo, String ownerName, int balance, String cardNo) {
		//supuer();
		//생성자호출 : 자동으로 super()
		
		//생성자호출: 명시적으로 호출하기
		super(accountNo,ownerName,balance); 
		//부모 필드가 private라서 부모에 생성자를 만들고 super로 접근.
		//default 생성자가 없어도 됨.
		
		this.cardNo = cardNo; //직접함.
	}
	
	//3.상속 후 기능추가
	int pay(String cardNo, int amount){
		if(cardNo.equals(this.cardNo)) {
			return withdraw(amount); //부모가 갖고있는 함수 withdraw. (출금)
		}else {
			System.out.println("카드번호 불일치. 일치불가");
			return 0;
		}
	}

	@Override
	public String toString() {
		return "CheckingAccount"+ super.toString() +"[cardNo=" + cardNo + "]";
		//부모에서 super.toString()문자열을 받아옴. 재정의
	}
	
	
}
