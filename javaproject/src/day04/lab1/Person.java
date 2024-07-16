package day04.lab1;

public class Person {
	
	//Person객체가 생성될 때마다 증가
	static int numberOfPersons;
	
	//instance변수
	int age;
	String name;
	
	//나이는 12살, 이름은 “Anonymous”로 초기화함
	Person() {
		//age=12;
		//name="Anonymouse";
		this(12,"Anonymouse");
	}
	// 나이는 age 매개변수, 이름은 name 매개변수로 Setting
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}

	//내 이름은 철수이며, 나이는 3살입니다.
	void selfIntroduce(){
		System.out.println("내 이름은 "+name+"이며, 나이는 "+age+"살입니다.");
	}
	
	int getPopulation() {
		return numberOfPersons;
	}
	
	//main
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person(30, "홍길동");
		p1.selfIntroduce();
		p2.selfIntroduce();
		System.out.println(p1.getPopulation());
		System.out.println(Person.numberOfPersons);
	}

	
}
