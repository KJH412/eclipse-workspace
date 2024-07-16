package day04;

//day04

//class : object를 만들기 위한 틀(template), 설계도
//object : class를 이용해서 만든 독립된 실체(instance)
public class Book {
	
	//클래스 안에 들어갈 수 있는 다섯 가지
	
	//1.field(변수, data 저장목적, 특징)
	
	String title;
	int price;
	
	//2.constructor(생성자메서드):argument가 없는 기본생성자는 컴파일시에 만들어진다.(함수랑 비슷하게생김 그래서 생성자메서드라고 부른다.) 
	
	//class이름과 같아야한다. return불가
	//--> void Book(){}는 불가능. 절대x! void는 메소드임.
	//생성자 추가가능...추가하면 컴파일시에 생성자를 만들지 않는다.
	//Overloading(이름은 '같고' 매개변수 사양이 다르다)
	//this : 현재객체
	//-> 매개변수이름과 field이름이 충돌발생시 구분하기 위해 사용한다. 클래스(매개변수,...)
	//같은이름의 다른모양의 생성자를 호출하기 : this()
	Book(){
		//System.out.println("default생성자를 재정의함");
		//코드를 한 곳에 몰아 넣는다.
		this(null,0);
	}
	Book(String title, int price){ //실제 로직 (유지보수 여기만 하면된다.) 
		System.out.println("!!!!!argument2개 생성자");
		this.title = title;
		this.price = price;
	}
	Book(String title){
//		System.out.println("argument1개 생성자...title");
//		this.title = title;
//		this.price = 50000;
		this(title, 50000);
	}
	Book(int price){
//		System.out.println("argument1개 생성자...price");
//		this.title = "제목모름";
//		this.price = price;
		this("제목모름", price);
	}
	
	//===> 매개변수가 다른 생성자가 여러개? 생성자오버로딩 (위 Book(){}생성자가 4개 있다.)
	
	//3.method(함수, 기능) : 반드시 return type을 정의한다. return값이 없으면 void	
	void bookInfoPrint(){
		System.out.println("===책의정보===");
		System.out.println("제목:"+this.title);
		System.out.println("가격:"+price);
	}
	
	
	//4.block
	{
		System.out.println("block...object생성시마다 수행");
	}
	static {
		System.out.println("class load시에 1회 수행");
	}
	//5.inner class
	class AA{
		
	}
	
}
