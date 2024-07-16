package com.shinhan.day06;

public class BonusPointAccount extends Account {
	
	//field추가
	int bonusPoint;//누적포인트
	
	//생성자정의
	public BonusPointAccount(String accountNo, String ownerName, int balance, int bonusPoint) {
		super(accountNo, ownerName, balance);
		this.bonusPoint = bonusPoint;
	}
	//method재정의(Override)
	@Override
	void deposit(int amount) { //예금함.
		super.deposit(amount); //오버라이드 자동생성됐음.
		bonusPoint += amount*0.001; //복합대입연산자는 자동형변환됨.
//		bounusPoint = (int)(bonusPoint + amount*0.001)
	}
	
	@Override
	public String toString() {
		return "BonusPointAccount"+ super.toString() +" [bonusPoint=" + bonusPoint + "]";
	}
	
	
	
	
}
