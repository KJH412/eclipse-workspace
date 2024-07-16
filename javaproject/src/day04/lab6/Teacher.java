package day04.lab6;

public class Teacher {
	private String name;
	private int age;
	private String subject;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public Teacher(String name, int age, String subject) {
		this.name = name;
		this.age = age;
		this.subject = subject;
	}
	
	void print() {
		System.out.print("\n이름 :" + name + " ");
		System.out.print("나이 :" + age + " ");
		System.out.print("담당과목 :" + subject);
	}
	
	
}
