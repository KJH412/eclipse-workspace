package com.shinhan.lab.lab6;

class Person {
	public static int numberOfPersons; // 전체 인구 수  (☆★☆★)static?
						              // Person 객체가 생성될 때마다 증가
	 public int age;
	 public String name;
	
	//생성자
	public Person(){  // 나이는 12살, 이름은 “Anonymous”로 초기화함
		this(12,"Anonymouse"); //(☆★☆★)
//		this.age = 12;
//		this.name = "Anonymouse";
		
		numberOfPersons++; //객체가 생성될 때마다 1씩 증가 
		
	}
	public Person(int age, String name) {// 나이는 age 매개변수, 이름은 name 매개변수로 Setting함
		this.age = age;
		this.name = name;
		//numberOfPersons++;//객체가 생성될 때마다 1씩 증가
	}
	//메소드
	public void selfIntroduce(int age, String name){ // 예) 내 이름은 철수이며, 나이는 3살입니다.
		System.out.println("내 이름은 "+name+"이며, 나이는 "+age+"살 입니다.");
	}
	
	public int getPopulation(){// 전체 인구수를 Return함
		return numberOfPersons; 
	}
	
}

public class lab1 {

	public static void main(String[] args) {
		
		Person ps1 = new Person();
		Person ps2 = new Person();
		ps1.selfIntroduce(2, "길동");
		ps2.selfIntroduce(3, "철수");
		
		int num = Person.numberOfPersons;
		System.out.println("전체 인구수: " + num);
		
		
	}

}
