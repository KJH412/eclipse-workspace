package com.shinhan.day13; /* 람다식 확인문제 */

import java.util.stream.IntStream;

import com.shinhan.day12.Student;

//@FunctionalInterface 체크용 필수는X
interface Makeable {
	public Student makeStrudent(String name, int score);

}

class StudentMakeClass implements Makeable { // 2.인터페이스의 추상메서드를 구현한 구현클래스. (원래방식)

	@Override
	public Student makeStrudent(String name, int score) {

		return new Student(name, score);
	}

}

/*
 * 기존방식 인터페이스 구현클래스 class MyButton implements ClickListener{
 * 
 * }
 * 
 */

class Button {
//정적 멤버 인터페이스(함수형 인터페이스)
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}

	private ClickListener clickListener;

	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}

	public void click() {
		this.clickListener.onClick();
	}
}

interface Function {
	public double apply(double a, double b);
}

@FunctionalInterface // 함수가 하나일때 FunctionalInterface
interface Operator {
	public int apply(int x, int y);
}

@FunctionalInterface
interface Function2<T> {
	public double apply(T t);
}

class Student2 {
	private String name;
	private int englishScore;
	private int mathScore;

	public Student2(String name, int englishScore, int mathScore) {
		this.name = name;
		this.englishScore = englishScore;
		this.mathScore = mathScore;
	}

	public String getName() {
		return name;
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public int getMathScore() {
		return mathScore;
	}
	
}

	
public class Review {

	// 배열 항목 중에 최대값 또는 최소값 찾기
	private static int[] scores = { 10, 50, 3 };

	public static int maxOrMin(Operator operator) {
		int result = scores[0]; // 배열한줄이라서 [0].
		for (int score : scores) {
			result = operator.apply(result, score);
		}
		return result;
	}

	public static void main(String[] args) {
		// f1();
		// f2();
		// f3();
		// f4();
		//f5();
		f6();
	}

	private static void f6() {
		Student2[] students ={
				new Student2("홍길동", 90, 96),
				new Student2("신용권", 95, 93)
		 };
		 //avg() 메소드 작성
		
		//람다식 메서드 참조
		double englishAng = avg(Student2::getEnglishScore, students);
		System.out.println("영어 평균 점수: " + englishAng);
		
		double mathAvg = avg(Student2::getMathScore, students);
		System.out.println("수학 평균 점수: " + mathAvg);
		
//		 double englishAvg = avg( s -> s.getEnglishScore(), students ); //avg에 학생students도 파라미터로 넘긴다.
//		 double mathAvg = avg( s -> s.getMathScore(), students );
	}																		   //avg에 파라미터로 보내는 식 : s -> s.getMathScore(), students -> func으로받음
	private static double avg(Function2<Student2> func, Student2[] students) { //func(식)을 받아서 수행함
		int total = 0;
		for(Student2 st:students) {
			total += func.apply(st);
		}
		return (double)total/students.length;
	}
	//-----
	private static void f5() {
		// 최대값 얻기
		int max = maxOrMin((a, b) -> a >= b ? a : b);
		System.out.println("최대값: " + max);
		// 최소값 얻기
		int min = maxOrMin((a, b) -> a < b ? a : b);
		System.out.println("최소값: " + min);
	}
	//-----
	private static void f4() {
		double result = calc((x, y) -> (x / y));
		System.out.println("result: " + result);

		double result2 = calc((x, y) -> (x + y));
		System.out.println("result2: " + result2);

	}

	public static double calc(Function fun) {
		double x = 10;
		double y = 4;
		return fun.apply(x, y);
	}

	//-----
	private static void f3() {
		Button btnOk = new Button();
		// 1.구현클래스사용
		// btnOk.setClickListener(new MyButton());
		// 2.익명
		// btnOk.setClickListener(new Button.ClickListener() {
		// @Override
		// public void onClick() {
		// }
		// });
		btnOk.setClickListener(() -> {
			System.out.println("Ok 버튼을 클릭했습니다.");
		});
		btnOk.click();

		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭했습니다"));
		btnCancel.click();

	}

	private static void f2() {
		Thread thread = new Thread(() -> IntStream.rangeClosed(1, 3).forEach(i -> System.out.println("작업스레드가 실행됩니다.")));
		thread.start();
	}

	private static void f1() {

		Makeable make1 = (n, s) -> new Student(n, s); // 3.람다표현식, 변수이름내가정함n,s.
		Makeable make2 = Student::new; // 4.람다식 생성자 참조 <-- 인자() 없어도 가능. 매개변수있는 생성자도 호출가능.

		Makeable make3 = new Makeable() {
			public Student makeStrudent(String name, int score) {

				return new Student(name, score);
			}
		};
		Makeable make4 = new StudentMakeClass(); // 1.구현클래스

		Student s1 = make2.makeStrudent("상호", 100);
		Student s2 = make2.makeStrudent("상호2", 200);

		System.out.println(s1 + "\n" + s2);

		// ------1234번 다 가능한 방법이다.

	}

}
