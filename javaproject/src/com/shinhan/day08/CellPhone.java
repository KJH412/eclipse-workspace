package com.shinhan.day08;
/*
 * String model // 핸드폰 모델 번호
double battery; // 남은 배터리 양
CellPhone(String model) // 모델 번호를 인자로 받는 생성자
void  call(int time) // 통화 시간(분)을 출력하고, 통화 시간에 따라 배터리 양을
감소시킨다.
// 감소되는 배터리 양 = 통화시간(분) * 0.5
// 배터리 양은 0보다 작아지지 않는다.
// 통화 시간(분)이 0 보다 작은 경우에는 IllegalArgumentException(“통화시간입력오류”)을 발생시킨다.

void  charge(int time) // 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리
양을 증가시킨다.
// 충전되는 배터리 양 = 충전시간(분) * 3
// 배터리 양은 100까지만 증가한다.
// 충전 시간(분)이 0보다 작은 경우에는 IllegalArgumentException(“충전시간입력오류”)을 발생시킨다.

void  printBattery() // 남은 배터리 양을 출력한다.
boolean     equals(Object
otherObject)
//   Object  타입의 객체를 입력받고,  입력받은 객체가
CellPhone  타입의 클래스이면서 모델 번호가 같은
경우에 true를 리턴한다.
 * 
 * 출력결과)
 * 충전 시간 : 20분
남은 배터리 양 : 60.0
통화 시간 : 300분
남은 배터리 양 : 0.0
충전 시간 : 50분
남은 배터리 양 : 100.0
통화 시간 : 40분
남은 배터리 양 : 80.0
통화시간입력오류
 * */
public class CellPhone {

	String model;
	double battery;
	public CellPhone(String model) {
		this.model = model;
	}
	void call(int time) {
		
		System.out.printf("통화 시간 : %d분\n", time);
		//감소되는 배터리 양 = 통화시간(분) * 0.5
		battery -= time * 0.5;
		if(battery <= 0) battery = 0; //배터리양이 음수가 되면 않으니까.
		if(time<0) throw new IllegalArgumentException("통화시간 입력오류");
	}
	void charge(int time) {
		// 충전한 시간(분)을 출력하고, 충전한 시간에 따라 배터리양을 증가시킨다.
		// 충전되는 배터리 양 = 충전시간(분) * 3
		// 배터리 양은 100까지만 증가한다.
		// 충전 시간(분)이 0보다 작은 경우에는 IllegalArgumentException(“충전시간입력오류”)을 발생시킨다.
		System.out.printf("충전 시간 : %d분\n" ,time);
		battery += time *3;
		if(battery >100) battery =100;
		if(time<0) throw new IllegalArgumentException("충전시간 입력오류");
	}
	void printBattery() {
		System.out.printf("남은 배터리 양 : %4.1f\n", battery);
	}
	public boolean equals(Object otherObject) { //boolean 리턴필요.
		if(!(otherObject instanceof CellPhone)) return false;
		CellPhone phone = (CellPhone)otherObject;
		return model.equals(phone.model);
	}
	


	public static void main(String[] args) {
		CellPhone myPhone = new CellPhone("SCH-600");
		myPhone.charge(20); // 20분간 충전을 한다.
		myPhone.printBattery();
		myPhone.call(300); // 300분간 통화를 한다.
		myPhone.printBattery();
		myPhone.charge(50); // 50분간 충전을 한다.
		myPhone.printBattery();
		myPhone.call(40); // 40분간 통화를 한다.
		myPhone.printBattery();
		try {
			myPhone.call(-20); // 통화시간이 잘못 입력되었다.
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		CellPhone yourPhone = new CellPhone("SCH-600");
		if (myPhone.equals(yourPhone)) {
			System.out.println("동일 모델입니다.");
		} else {
			System.out.println("다른 모델입니다.");
		}
	}

}
