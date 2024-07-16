package com.shinhan.day05;

//class : object를 만들기 위한 틀(template), 설계도
//object : class를 이용해서 만든 독립된 객체
//instance == object, new로 만든 실체(메모리에 만들어진 실체)
public class Car {
	
//	클래스 5항목 (생상자는 필수.)
	//1.field (특징, data값 저장이 목적, 변수) 
	//  : static(class변수,object들의 공통변수),
	//    non-static(instance변수, 멤버변수) 해당 오브젝트것, new시에 자동으로 초기화 된다.
	static String company = "현대자동차"; //static이 붙어있어서 처음부터 값을 줌. class가 load시에 값이 할당된다.
	static int carCount;
	
	//String mode; //new 한 object객체마다 갖게 되는 mode와 price가 다름.
	//int price;	
	private String model;
	private int price;
	//2.constructor [method]...컴파일시에 정의가 없으면 자동으로 default 생성자(argument없음)를 만들어 준다. 
	//객체 생성시 자동으로 호출된다. new Car();
	//생성자는 생성시 값 초기화가 목적이다.
	
	//생성자의overloading(이름같고 매개변수 사양이 다르다)
	//매개변수이름과 멤버변수이름이 충돌발생 이를 구분하기 위해 현제객체를 this라고 사용.
	//하나의 생성자가 같은 이름의 다른모양의 생성자를 호출시 사용한다. this()
	Car(String model, int price){ //자바는 변수를 넣을 때 변수타입을 꼭 줘야함. Car(mode){} X -> Car(String mode){}
		//함수(변수타입 매개변수) : 매개변수는 지역변수이다.
		this.model = model; //값 초기화  //this.속성을쓰면되고
		this.price = price;
		carCount++;
		System.out.println(carCount + "번째 자동차가 만들어집니다.");
	}
	Car(String model){ 
		this(model, 100); //this()괄호는 호출임.
		/*
		this.mode = model; //값 초기화
		this.price = 100; //정해진 값이 있으면 넣고, 안넣으면 0
		*/
	}
	Car(int price){ //price만 초기화한다.
		this("모델명 미정", price);
		/*
		this.model = "이름미정"; 
		this.price = price;
		*/
	}
	
	
	//3.일반 method(기능, 문장들의 묶음), 반드시 return값의 타입을 정의한다. return값이 없으면 void.
	static void carInfoPrint(String title){ //함수이름(변수타입 매개변수){중괄호묶음}:구현한다는 뜻.  함수이름(); : 호출한다는 뜻. 
		System.out.println(title);
		System.out.println("company: "+ company);
		System.out.println("carCount: "+ carCount);
//		System.out.println("model: "+ model); 
//		System.out.println("price: "+ price);
		
	}
	
	//static이 안붙어있으면 new해야 쓸 수 있다. void carInfoPrint()
	static void carInfoPrint2(String title){ //함수이름(변수타입 매개변수){중괄호묶음}:구현한다는 뜻.  함수이름(); : 호출한다는 뜻. 
		System.out.println(title);
		System.out.println("company: "+ company);
		System.out.println("carCount: "+ carCount);
		//****불가(static method에서 non-static(instance변수)사용 불가!
		//System.out.println("model: "+ model); //new해야 쓸 수 있음.
		//System.out.println("price: "+ price);
		
	}
		
	//Getter/Setter는 *이름규칙을 지킨다. 자바기술에 JavaBeans기술에서 사용하기 때문.
	//모든 패키지에서 사용가능하도록 public붙음.
	 public String getModel() {
		return model;
	}
	 public int getPrice() {
		return price; //this는 객체라 붙으면 안됨.
	}
	 public void setModel(String model){
		this.model = model; //this.model과 = model 이름이 충돌되므로 this.사용
	}
	 public void setPrice(int price) {
		this.price = price;
	}
	
	
	//4.block : 생성자보다 우선.먼저 실행됨.
	 {
		 System.out.println("----instance block(객체생성시마다 수행)------");
	 }
	 static {
		 System.out.println("----class load시 1회 수행------");
		 //class load시 static변수 로직이 필요한 초기화시 사용한다.
	 }
	//5.inner class
	 class Tier{ //Car를 통해서만 쓸 수 있다. 파일명:Car$Tier.class
		 //1.field
		 String color;
		 //2.constructor
		 //3.method
		 //4.block
		 //5.inner class
	 }
	
}
