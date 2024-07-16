package chapter17.exam;

import java.util.Arrays;
import java.util.List;

//대소문자 상관없이 'java'단어 포함된 문자열만 출력
//Comparable2 comp = String::compareToIgnoreCase;  //compareToIgnoreCase 대소문자상관없이 비교해서 두개의 차이를 알려줌.
//int result = comp.compare(s1, s2); 
//System.out.println(result); //값 0

public class Example {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");

		list.stream()
		.filter(a -> a.toLowerCase().contains("java")) //소문자로바꿔서 java가 들어간 문장찾음.
		.forEach(a -> System.out.println(a));
	}	
}
