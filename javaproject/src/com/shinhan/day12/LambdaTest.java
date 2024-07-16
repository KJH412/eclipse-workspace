package com.shinhan.day12;

//함수형인터페이스
@FunctionalInterface 
interface Calcuable{
	double calc(double x, double y);  //리턴있는 함수
}									  //함수가 한개 존재.			

//구현class
class MyCalculator implements Calcuable {
	public double calc(double x, double y) { 
		return x+y;
	}
}

class Computer{
	public static double staticMethod(double x, double y) {
		return x+y;
	}
	public double instanceMethod(double x, double y) {
		return x+y;
	}
}
 

@FunctionalInterface //인터페이스안에 메소드(함수)가 1개라 람다식이 가능하다.
interface Comparable2{
	/*public숨어있음*/int compare(String a, String b); //추상메서드(람다식,익명구현클래스가능)
}

interface Creatable{
	public Student create(String name, int score);
}

class Person{
	public Student getStudent(Creatable creatable, String name, int score) {
		return creatable.create(name, score);
	}
}

//main 실행
public class LambdaTest {
	public static void main(String[] args) {
		//f1();
		//f2();
		//f3();
		//f4();
		f5();
	}

	private static void f5() {
		Person p1 = new Person();
		Creatable creatable = new Creatable() {
		
			public Student create(String name, int score) {
				return new Student(name, score);
			}
		};
		//Creatable creatable2 = (String name, int score) -> new Student(name, score);
		Creatable creatable2 = Student::new;
		
		Student s =  p1.getStudent(creatable2, "홍길동1", 200); //Person클래스의 Student함수를 부르려고함.
		System.out.println(s);
		
	}

	private static void f4() {
		Student s = new Student("홍길동", 100);
		Student s2 = makeStudent("홍길동", 100);
		
	}

	private static Student makeStudent(String name, int score) {
		return new Student(name, score);
	}

	private static void f3() {
		String s1 = "b";
		String s2 = "a";
		/*
		String s1 = "홍길동";
		String s2 = "김길동";
	
		Comparable2 comp = new Comparable2() {
			public int compare(String a, String b) { //추상메서드구현. public놓치지말기.
				return 0;
			}
		};
		*/
//		Comparable2 comp = (String a, String b) -> a.length() - b.length(); //<--여기 있는 기능은 내가원하는대로
//		Comparable2 comp = (a, b) -> a.length() - b.length(); 
		Comparable2 comp = String::compareToIgnoreCase;  //compareToIgnoreCase 대소문자상관없이 비교해서 두개의 차이를 알려줌.
		int result = comp.compare(s1, s2); 
		System.out.println(result); //값 0
		
	}

	private static void f2() {
		System.out.println("1.구현class 이용");
		MyCalculator a = new MyCalculator();
		System.out.println("result= " + a.calc(1, 2));

		System.out.println("2.구현class 이용");
		Calcuable b = new Calcuable() {
			//구현
			public double calc(double x, double y) { 
				return x-y;
			}
		};
		System.out.println("result= " + b.calc(1, 2));
		
		System.out.println("3.람다표현식");
		//Calcuable c = (double x, double y)-> x*y ;
		//Calcuable c = (x, y)-> x*y ;
		//Calcuable c = (x, y)-> {return x*y; }; //위 3개는 함수 직접 만든것
		//Calcuable c = Computer::staticMethod;  //클래스 ::instanceMethod
		Computer computer = new Computer(); 
		Calcuable c = computer::instanceMethod; //객체생성하고 사용한다.
		
		System.out.println("result= " + c.calc(1, 2));
		
	}

	private static void f1() {
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("Thread구현");
			}
		};// 1.익명구현클래스(Thread클래스를 바로 만든다.)

		Thread t2 = new Thread(new Runnable() { // 2.Runnable인터페이스를 구현

			@Override
			public void run() {
				System.out.println("Thread구현...Runnable interface구현");
			}
		}); // 이미 Thread를 상속받고 있다면?
		
		Thread t3 = new Thread(() -> { // 3.익명구현클래스만들기 람다식, 함수형인터페이스만 사용가능.
		
			System.out.println("Thread구현...Runnable interface구현");
		
		});
	}
}
