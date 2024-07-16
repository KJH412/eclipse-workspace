package com.shinhan.day07;
//챕터9 중첩클래스

//외부class
class OuterClass{
	//1.instance변수 (필드,멤버변수)
	int a = 100; 	
	int score = 99;
	//2/class변수
	static int b = 200;
	//3.instance method
	void method1() {}
	//4.static method
	static void method2() {}
	//instance inner class
	class InnerClass{ //<-------------중첩 멤버클래스
		//1.instance변수 (필드,멤버변수)
		int a2 = 100; 	
		String score = "A학점";
		//2/class변수
		static int b2 = 200;
		//3.instance method
		void method3() {
			System.out.println("inner class의 method3: " + (a+b+a2+b2)); //Outerclass 변수에 접근가능.
			//System.out.println(score); //마우스커서 대면 score가 int가 아니라 String으로 확인됨. inner클래스 필드로 접근한다.
			System.out.println("outer class의 feild: " + score);
			System.out.println("outer class의 feild: " + OuterClass.this.score);
		}
		//4.static method....instance변수 사용이 불가능.
		static void method4() {
			System.out.println("inner class의 static method4: " + (b+b2));	
		}
	}
	
	static class InnerClass2{ //<-------------정적 멤버클래스
		//1.instance변수 (필드,멤버변수)
		int a2 = 100; 	
		String score = "A학점";
		//2/class변수
		static int b2 = 200;
		//3.instance method
		void method3() { //static이 안붙은 method3이여서 a2를 쓸 수 있다. ???
			System.out.println("inner class의 method3: " + (b+a2+b2));  //a못씀.static이 아니여서
			System.out.println("outer class의 feild: " + score);
			//불가 System.out.println("outer class의 feild: " + OuterClass.this.score);
		}
		//4.static method....instance변수 사용이 불가능.
		static void method4() {
			System.out.println("inner class의 static method4: " + (b+b2));	
		}
	}

	void call() {
		//지역변수 : 내부클래스에서 접근하면 무조건 변경불가(final)
		int price = 1000; //final이 생략되어있음. 
		//로컬클래스 : method내에 있는 class, method내에서만 접근가능.(메소드안에 메소드는 불가하지만 클래스는 올 수 있음.)
		class LocalClass {
			//1.field
			int price2 = 2000;
			static int price3 = 3000;
			//2.method
			void show() {
				System.out.println("LocalClass instance method");
				//price=9999; 값변경X
				System.out.println("지역변수를 local class에서 사용 price=" + price); 
				//내부클래스에서 지역변수에 접근을했다면 무조건 final 내부에서 값을 바꿀 수 없음.
			}
			static void show2() {
				System.out.println("LocalClass class method");
			}
		}
		//price = 8888; 값변경X
		System.out.println(price);
		//static
		System.out.println(LocalClass.price3);
		LocalClass.show2();
		//instance
		LocalClass local = new LocalClass();
		System.out.println(local.price2);
		local.show();
	}
}



public class InnerClassTest {
	
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		outer.call();
	}
	
	public static void f2(String[] args) {
		System.out.println(OuterClass.InnerClass2.b2);
		OuterClass.InnerClass2.method4();
		
		
		//OuterClass.InnerClass2 inner = new OuterClass().InnerClass2(); 오류났음. 
		//왜? InnerClass2()가 static이니까 통쨰로 OuterClass.InnerClass2()불러줘야함. 만약 static이 아니라면 따로따로 new O().new I() 하면된다.
		OuterClass.InnerClass2 inner = new OuterClass.InnerClass2(); 
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();
	}
	public static void f1(String[] args) {
		
		//static사용
		System.out.println(OuterClass.InnerClass.b2);
		OuterClass.InnerClass.method4();
		
		//instance 사용
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
//		OuterClass.InnerClass inner2 = new OuterClass().new InnerClass();위와 같음.
		System.out.println(inner.a2);
		System.out.println(inner.score);
		inner.method3();
		
	}
}
