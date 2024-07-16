package com.shinhan.day09;

//리플렉션 살펴보기. 용어는 알아 두기..

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {
	
	public static void main(String[] args) throws Exception {
		Class<ComputerVO> clazz = ComputerVO.class;
		System.out.println("[생성자 정보]");
		Constructor<?>[] constructors = clazz.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.print(constructor.getName() + "(");
			Class<?>[] parameters = constructor.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();
		System.out.println("[필드 정보]");
		Field[] fields = clazz.getDeclaredFields(); // 필드가 여러개 온다.
		for (Field field : fields) {
			System.out.println(field.getType().getName() + " " + field.getName()); // 타입과 필드의 이름을 찍음.
		}
		System.out.println();
		System.out.println("[메소드 정보]");
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
	}

	private static void printParameters(Class[] parameters) {
		for (int i = 0; i < parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if (i < (parameters.length - 1)) {
				System.out.print(",");
			}
		}
	}
}
