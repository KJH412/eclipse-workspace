package day04.lab6;

public class Employee {
	private String name;
	private int age;
	private String dept;
	
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Employee(String name, int age, String dept) {
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
	
	void print() {
		System.out.print("\n이름 :" + name + " ");
		System.out.print("나이 :" + age + " ");
		System.out.print("부서 :" + dept);
	}
	
	
}
