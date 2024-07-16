package chapter17.exam;

import java.util.Arrays;
import java.util.List;

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
//평균나이 구하기.
public class Example2 {
	public static void main(String[] args) {
	 List<Member> list = Arrays.asList(
	 new Member("홍길동", 30),
	 new Member("신용권", 40),
	 new Member("감자바", 26)
	 );
	 double avg = list.stream().mapToInt(m->m.getAge()).average().getAsDouble();
//	  list.stream().mapToInt(m -> m.getAge()).average()
//			 		.ifPresentOrElse(a -> { 
//			 			System.out.println("있음 avg:" + a);
//			 		}, () -> {
//			 				System.out.println("data없음");
//			 		});

	 
	 
	 System.out.println("평균 나이: " + avg);
	}
}