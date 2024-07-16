package com.shinhan.day13; /* 스트림 확인문제 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}

class Member2 {
	private String name;
	private String job;

	public Member2(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}
}

public class Review2 {

	public static void main(String[] args) {
		f6();

	}

	private static void f6() {
		List<Member2> list = Arrays.asList(
				 new Member2("홍길동", "개발자"),
				 new Member2("김나리", "디자이너"),
				 new Member2("신용권", "개발자")
				 );
		//스트림을 다른 컬렉션으로 바꿀 때 collect(Collectors.)  , Collectors는클래스임.(기능존재)
		Map<String, List<Member2>> groupingMap = 
//				list.stream().collect(Collectors.groupingBy(m->m.getJob()));
		list.stream().collect(Collectors.groupingBy(m->m.getJob())); 
		
		//collect() : 스트림을 다른 자료구로 변경. 
		//Collectors(자료구조들) Map>List변경할 때 collect를 안쓰면 add해서 하나씩 넣어줘야함.
		
		groupingMap.get("개발자") //List<Member2>로들어옴
		.stream() //스트림으로 만듦
		.forEach(m-> System.out.println(m));
		
		 System.out.println("--------------------------");
		 groupingMap.get("디자이너").stream().forEach(m->System.out.println(m));
	}

	private static void f5() {
		 List<Member2> list = Arrays.asList(
				 new Member2("홍길동", "개발자"),
				new Member2("김나리", "디자이너"),
				 new Member2("신용권", "개발자")
				 );
				 
		 List<Member2> developers = list.stream()
				 					.filter(m->m.getJob().equals("개발자")).toList(); //toList()
		 
		 List<Member2> developers2 = list.stream()
					.filter(m->m.getJob().equals("개발자")).collect(Collectors.toList()); //Collectors
				 
		 developers.stream()
		 .forEach(m -> System.out.println(m.getName()));
	}

	private static void f4() {
		List<Member> list = // new ArrayList<Member>();
				Arrays.asList(
						new Member("홍길동", 30), // mapToInt :멤버객체->int로바꾼다.
						new Member("신용권", 40),
						new Member("감자바", 26)
						);
//		 double avg = list.stream().mapToInt(m->m.getAge()).average().getAsDouble();
		double avg = list.stream().mapToInt(m -> m.getAge()).average().orElse(0);
		// orElse(없다면) 로직이길면사용안함.
		/* double avg = */ list.stream().mapToInt(m -> m.getAge()).average() // 값도 있고 로직도 있을 경우 추천. ifPresentOrElse
				.ifPresentOrElse(a -> { // 있을 때와 없을때를 둘다 적을 수 있다.(a->{},()->{})
					System.out.println("있음 avg:" + a);
				}, () -> {
					System.out.println("data없음");
				});

		System.out.println("평균 나이: " + avg);

	}

	private static void f3() {
		List<String> list = Arrays.asList( // 수정이불가능함
				"This is a java book", "Lambda Expressions", "Java8 supports lambda expressions");

		list.stream().filter(line -> line.toLowerCase().contains("java")) // JAVA(java) 소문자 비교로 바꿔서 찾음.
				.forEach(s -> System.out.println(s));
	}

	private static void f2() {
		int[] arr = { 1, 2, 3, 4, 5 };
		// 내부반복자(스트림Stream)
		System.out.println("-----forEach는 최종단계-----");
		Arrays.stream(arr).forEach(i -> System.out.println(i));
		System.out.println("-----peek는 중간단계-----");
		long result = Arrays.stream(arr).peek(i -> System.out.println(i)).sum();
		System.out.println("sum:" + result);

	}

	private static void f1() {
		int[] arr = { 1, 2, 3, 4, 5 };
		// 향상FOR: 외부반복자
		for (int i : arr) {
			System.out.println(i);
		}
	}

}
