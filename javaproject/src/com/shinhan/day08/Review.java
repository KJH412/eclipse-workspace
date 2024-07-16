package com.shinhan.day08;
/* 예약어 : 무조건 소문자 (package ,interface.. 등등) */

//규격서 : interface
@FunctionalInterface //람다표현식이 가능한지 check하는 어노테이션(annotation)
interface JDBCInterface{
	//1.상수
	//2.추상메서드..구현class가 반드시 구현할 의무가 있다.
	public abstract void connection(); /* public abstract 생략되어있음. */
	//3.default method : 구현이 가능, 구현class가 공통적으로 사용하는 기능, 재정의 가능*
	//4.static method : 구현, 구현class가 공통적으로 사용하는 기능, 재정의 불가능*
	//5.private method :default메소드에서만 호출 가능하다.
}
//구현class
class OracleDB implements JDBCInterface {
	public  void connection() {
		System.out.println("OracleDB DB연결합니다.");
	};
}
class MySQLDB implements JDBCInterface {
	public  void connection() {
		System.out.println("MySQLDB DB연결합니다.");
	};
}

public class Review {

	public static void main(String[] args) {
		work(new OracleDB()); //OracleDB를 new로 객체를 만들어서 work를 실행하도록 함.
		work(new MySQLDB());
		
		//익명구현클래스 메소드 재정의
		work(new JDBCInterface() {
			
			@Override
			public void connection() {
				System.out.println("익명구현class에서 메서드 재정의함.");
				method();
				
			}
			void method() { //이걸 단독으로 JDBCInterface인터페이스를 통해서 실행할 수 없다.
				System.out.println("메서드 추가함.");
			}
		});
		work(()-> System.out.println("람다표현식으로 메서드 재정의함.")); //((매개변수)-> 매서드재정의)
	}

	private static void work(JDBCInterface db) { //work() OracleDB와 MySQLDB의 공통 인터페이스를 타입으로 ()안에 써주면 됨.
		db.connection();
	}
	
	
}
