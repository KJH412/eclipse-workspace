package com.shinhan.day06;
//day04 lab6 해설

//패키지 내에 class가 존재하는지 찾는다.
//Modifier
//1.접근지정자 1개가능 : public > protected > 생략(default) > private
//2.활용방법 여러개가능 : static , final, abstract, synchronized, ........
public class SchoolTest { //public
	public static void main(String[] args) {
//		Student a = new Student();
		Student a = new Student("홍길동",20,200201);
		a.getName();
		a.setName("aaa");
		
//		Teacher b = new Teacher("선생님",20,"과목");
//		Employeer c = new Employeer("홍길동",20,200201 );
//		b.getName();
//		c.get
		
	}
}
	
	class Student{ //public 뺴줌. default여서 다른패키지에서 쓸 수 없다.
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
		public Student() {
			// TODO Auto-generated constructor stub
		}
		private void print() { //private:다른클래스에서 접근못함(SchoolTest에서x)
			System.out.println("이름"+name +"나이"+age+"학번"+id);
		}
	}
	
	
//	class Teacher{
//		private String name;
//		private int age;
//		private String subject;
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public int getAge() {
//			return age;
//		}
//		public void setAge(int age) {
//			this.age = age;
//		}
//		public String getSubject() {
//			return subject;
//		}
//		public void setSubject(String subject) {
//			this.subject = subject;
//		}
//		
//		private void print() { 
//			System.out.println("이름"+"나이"+"학번");
//		}
//		
//		
//	}	
//	class Employee {
//		String name; //private이 없다? 다른패키지에서 접근이 됨.
//		private int age;
//		private String dept;
//		
//		public String getName() {
//			return name;
//		}
//		public void setName(String name) {
//			this.name = name;
//		}
//		public int getAge() {
//			return age;
//		}
//		public void setAge(int age) {
//			this.age = age;
//		}
//		public String getDept() {
//			return dept;
//		}
//		public void setDept(String dept) {
//			this.dept = dept;
//		}
//		
//		private void print() {
//			System.out.println("이름"+"나이"+"학번");
//		}
//		
//		
//	}
		
	


