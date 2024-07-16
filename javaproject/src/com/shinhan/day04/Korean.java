package day04;

//class:틀, 특징, 행위를 정한다.
//object:각각의 다른 object와 구별되는 독립된 특징을 부여한다.
public class Korean {
	
	//1.field
	private String nation="대한민국"; //초기값 설정.	private String name;	private String ssn;
	
	//2.constructor : 목적이 초기화이다. 초기화할 것 없으면 안 만들어도됨. 자동으로 컴퍼일러가 생성만들어줌.
	Korean(String name, String ssn){
		this.name = name;
		this.ssn = ssn;
	}
	Korean(String name){
		this.name = name;
	}
	//-->오버로딩
	
	//3.메서드(기능) : 함수는 return type이 필수다.
	void print(){
		System.out.println(nation);
		System.out.println(name);
		System.out.println(ssn);
		//private 변수를 이곳에서 쓸 수 있음. 
		//--> KoreanTest에서는 print함수로 nation,name,ssn을 프린트함.
	}
}
