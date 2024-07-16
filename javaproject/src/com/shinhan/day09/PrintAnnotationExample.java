package com.shinhan.day09;
//만들어 둔 PrintAnnotation어노테이션 사용.
import java.lang.reflect.Method;

public class PrintAnnotationExample {
	public static void main(String[] args) throws Exception {
		Method[] declaredMethods = Service.class.getDeclaredMethods();
		for (Method method : declaredMethods) {
			// PrintAnnotation 얻기
			PrintAnnotation printAnnotation = method.getAnnotation(PrintAnnotation.class);
			System.out.println(printAnnotation.number());
			System.out.println(printAnnotation.value());
			// 설정 정보를 이용해서 선 출력
			printLine(printAnnotation); //기본 7개 "-"
			// 메소드 호출
			method.invoke(new Service()); //메소드1,2,3
			// 설정 정보를 이용해서 선 출력
			printLine(printAnnotation); //한번 더 호출
		}
	}

	public static void printLine(PrintAnnotation printAnnotation) {
		if (printAnnotation != null) {
			// number 속성값 얻기
			int number = printAnnotation.number();
			for (int i = 0; i < number; i++) {
				// value 속성값 얻기
				String value = printAnnotation.value();
				System.out.print(value); //7개찍힘
			}
			System.out.println();
		}
	}
}
