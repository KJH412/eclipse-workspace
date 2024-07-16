package day04.lab6;

public class Student {
	//instance 변수, 객체생성시 자동으로 초기화된다.
	private String name;
	private int age;
	private int id;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Student(String name, int age, int id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	//print 메소드
	 void print() {
				System.out.print("이름 :" + name + " ");
				System.out.print("나이 :" + age + " ");
				System.out.print("학번 :" + id);
	}
	
}

