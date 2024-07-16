package com.shinhan.day09;

import java.util.HashSet;

public class ObjectTest {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
	}

	private static void f3() {
		//ComputerVO3
		ComputerVO3 com1 = new ComputerVO3(null, 100 , "Samsung");
		ComputerVO3 com2 = new ComputerVO3("A", 100 , "Samsung");
		ComputerVO com3 = new ComputerVO(null, 100 , "Samsung");
		ComputerVO2 aa = new ComputerVO2("B", 100 , "Samsung");
		System.out.println(aa.model()); 
		
		System.out.println(com1); 
		System.out.println(com2);
		System.out.println(com1.equals(com2));
		
//		System.out.println(com1.getModel().charAt(0)); //null을 사용해서 에러가 뜸.
		System.out.println(com3.getModel()); //non-null 
	}
	
	private static void f2() {
		//ComputerVO2
		ComputerVO2 com1 = new ComputerVO2("A", 100 , "Samsung");
		ComputerVO2 com2 = new ComputerVO2("A", 100 , "Samsung");
		System.out.println(com1); 
		System.out.println(com2);
		System.out.println(com1.equals(com2));
	}

	private static void f1() {
		//ComputerVO
		ComputerVO com1 = new ComputerVO("A", 100 , "Samsung");
		ComputerVO com2 = new ComputerVO("A", 100 , "Samsung");
		System.out.println(com1); //toString() 호출된다. 원래 주소가 return, 재정의가능
		System.out.println(com2);		
		
		System.out.println(com1 == com2); //주소비교, c++재정의가능, 자바는 불가능
		System.out.println(com1.equals(com2)); //equals:주소비교, 재정의가능
		
		//동일객체비교 (hashcode() , equals() 재정의)**기억(동일객체를 비교하기 위해서 hashcode와 equals를 재정의해줘야한다.)
		//Set : 순서없고 중복불가
		HashSet<ComputerVO> computers = new HashSet<>(); //<>생략하면 앞에 쓴 <E>와 같다고 해석함.
		computers.add(com1);
		computers.add(com2);
		computers.add(new ComputerVO("A", 100 , "Samsung"));
		System.out.println(computers.size());
		
		for(ComputerVO com:computers) {
			System.out.println(com);
		}
	}
	

}
