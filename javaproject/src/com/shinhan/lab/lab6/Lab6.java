package com.shinhan.lab.lab6;
/*
 [출력값]
이   름 : 홍길동    나 이 : 20     학    번 : 200201
이   름 : 이순신    나 이 : 30     담당과목 : JAVA
이   름 : 유관순    나 이 : 40     부    서 : 교무과
 
 */
class Student{
	private String name;
	private int age;
	private int id;
	
	public Student(String name, int age, int id) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
	}
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
	
	void print(){
		System.out.println("이 름:" + name+ " " + "나이:" + age + " " +  "학번:"+ id);
	}
}
class Teacher{
	private String name;
	private int age;
	private String subject ;
	
	
	public Teacher(String name, int age, String subject) {
		super();
		this.name = name;
		this.age = age;
		this.subject = subject;
	}
	
	void print(){
		System.out.println("이 름:" + name+ " " + "나이:" + age + " " +  "담당과목:"+ subject);
	}

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
	

}
class Employee{
	private String name;
	private int age;
	private String dept;
	
	public Employee(String name, int age, String dept) {
		super();
		this.name = name;
		this.age = age;
		this.dept = dept;
	}
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
	
	void print(){
		System.out.println("이 름:" + name+ " " + "나이:" + age + " " +  "부서:"+ dept);
	}
}
public class Lab6 {
	public static void main(String[] args) {
		Student st = new Student("홍길동", 20, 200201);
		Teacher tc = new Teacher("이순신",20,"JAVA");
		Employee em = new Employee("유관순", 40, "교무과");
		st.print();
		tc.print();
		em.print();
		
		
	}
}
