package com.shinhan.day10;
//제네릭메소드
public class GenericTest {
	
	public static void main(String[] args) {
		Product<Double, Integer> p1 = makeProduct2(3.14, 200);
		boolean result = compare(10,20);
		System.out.println(result);
	}
	
	//T에 Number의 자식만 올 수 있다.
	private static <T extends Number> boolean compare(T i, T j) {
		double d1 = i.doubleValue(); //타입에 제약을 건다. 숫자는 double로 바꿀 수 있음.
		double d2 = j.doubleValue();
		
//		i == j (X)
		return d1 ==  d2; //숫자타입이라==가능
	}

	//A는 Number를 상속받은 것
	//제한된 타입 파라미터
	private static <A extends Number, B> Product<A, B> makeProduct2(A i, B j) {
		Product<A, B> p = new Product<A, B>(i, j); 
		return p;
	}

	public static void main4(String[] args) {
		Product<String, Integer> p1 = makeProduct("A", 100); //<String, Integer>
		Product<Integer, String> p2 = makeProduct(200, "B"); //<Integer, String>
		Product<String, String> p3 = makeProduct("C", "D"); //<String, String>
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}
	//<A,B>이걸 안써주면 java에 A타입,B타입이 있다고 읽기때문에 에러난다.
	private static <A,B> Product<A, B> makeProduct(A a, B b) {
		Product<A, B> p = new Product<A, B>(a, b); //p리턴
		return p;
	}

	public static void main3(String[] args) {
		Box<String> result1 = makeBox("구체적타입 사용시 결정"); //makeBox를 리턴되는 함수(타입필요)로 만들기.
		Box<Integer> result2 = makeBox(100); 
		Box<Car> result3 = makeBox(new Car()); //makeBox를 리턴되는 함수(타입필요)로 만들기.
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}
	private static <T> Box<T> makeBox(T str){ //T가 뭐냐고 에러나는데, 사용할 때 결정한다고 앞에 <T>로 정해둠
		Box<T> box = new Box<>(str); 
		return box;
	}
	/*
	private static Box<String> makeBox(String str){
		Box<String> box = new Box<>(str); // <String>같은타입이라 <>로 생략
		return box;
	}
	*/
	
	public static void main2(String[] args) {
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		Box<String> result1 = boxing("문자"); //boxing안에 문자가 들어가라.
		Box<Integer> result2 = boxing(100); 
		Box<TV> result3 = boxing(new TV()); 
		Box<Home> result4 = boxing(new Home()); 

		Box<Product<String, Integer>> result5 = boxing(new Product<>("A",100)); 
		Box<ChildProduct<String, Integer, String>> result6 = 
				boxing(new ChildProduct<>("A",100,"a")); 
		
		
		System.out.println(result1.getContent());
		System.out.println(result2.getContent());
		System.out.println(result3.getContent());
		System.out.println(result4.getContent());
		System.out.println(result5.getContent());
		System.out.println(result6.getContent());
		
		
		Box<String> s = boxing("문자");
		Box<Integer> i = boxing(100);
		Box<TV> tv = boxing(new TV());
		
		System.out.println(s.getContent()); //s만 출력하면 주소만 찍힘.
		System.out.println(i.getContent());
		System.out.println(tv.getContent());
	}

	//<T>: T가 제네릭이다. 구체적인 타입이 아니다.
	//Box<T> : return타입, 제네릭타입인 Box를 return한다.
	private static <T> Box<T> boxing(T t) { 
				//<T>는 사용할 때 구체적으로 써주는거고 Box<T>는 리턴할 때 써줌.
		Box<T> box = new Box(); //구체적인 객체를 만들어 보낸다.
		//Box<T> box = new Box(t); //()안에 써주면 set할 필요가 없다.
		box.setContent(t); //값을 넣어준다. 출력.
		return box; //box리턴 Box객체
	}
	
	private static <P> Box<P> boxing2(P p) { 
		Box<P> box = new Box(p); //()안에 써주면 set할 필요가 없다.
		return box; //box리턴 Box객체
	}
	
	
	
	private static void f6() {
		ChildProduct<String, Integer, Integer> p1 =
				new ChildProduct<String, Integer, Integer>("컴퓨터",1234,100);
		System.out.println(p1);
		
	}
	private static void f5() {
		CoffeeAgency coffeeAgency = new CoffeeAgency();
		CoffeeMachine machine = coffeeAgency.rent();
		machine.method1();
		
		coffeeAgency.method1(machine);
		
	}
	private static void f4() {
		HomeAgency homeAgency = new HomeAgency();
		Home home = homeAgency.rent();
		home.turnOnLight();
		
		CarAgency carAgency = new CarAgency();
		Car car = carAgency.rent();
		car.run();
		
	}
	private static void f3() {
		Product<String, Integer> p1 = new Product<String, Integer>(); //Product<K,V>-><String, Integer>사용할 때 구체적인타입을 만듦.
		p1.setKind("ABC");
		p1.setModel(200);
		Product<String, Integer> p2 = new Product<>("컴퓨터", 100);
		System.out.println(p1);
		System.out.println(p2);
		
		Product<CoffeeMachine, String> p3 = new Product<>(new CoffeeMachine(), "DDD");
		System.out.println(p3);
	}
	private static void f2() {
		//제네릭사용목적 : 컴파일시에 타입을 제한하기(잘못된 타입 입력불가, 얻을때 형변환 불필요)
		Box<CoffeeMachine> box1 = new Box<CoffeeMachine>();
		box1.setContent(new CoffeeMachine());
		CoffeeMachine a = box1.getContent(); //Integer타입>int타입 : unboxing
		System.out.println(a);
	}
	private static void f1() {
		Box box1 = new Box();
		box1.setContent(100); //setContent(Object):다 들어 갈 수 있다.
		box1.setContent("100");
		//box1.setContent(new CoffeeMachine());
		
		CoffeeMachine obg = (CoffeeMachine)box1.getContent(); //오브젝트타입이라 형변환 필요
	}

}
