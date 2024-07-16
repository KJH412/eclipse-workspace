package com.shinhan.day10.lab;

//<?> : 와일드카드타입. 모든타입이든지 다 들어올 수 있다.
public class Course {
	//모든 사람이면 등록 가능
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	//Student, HighStudent, MiddleStudent가 가능. (extends Student: Student의 하위로 가능. 학생을 상속받은것만 가능.)
	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	//Student, Person, Object
	public static void registerCourse3(Applicant<? super Student> applicant) {
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
	//Worker, Person, Object (super Worker : Worker의 상위만 가능.)
	public static void registerCourse4(Applicant<? super Worker> applicant) { 
		System.out.println(applicant.getKind().getClass().getSimpleName());
	}
}
