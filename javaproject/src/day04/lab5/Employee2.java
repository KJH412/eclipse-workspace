package day04.lab5;
//LAB5 문제2

public class Employee2 {
	//1. 사원(Employee) 클래스는 사원번호를 나타내는 id(문자열)와 사원 이름을 나타내는 name(문자열), 사원의 기본급을 나타내는 baseSalary(정수) 필드를 가지고 있다.
	private String id;
	private String name;
	private int baseSalary;
	//2. 사원번호(id), 사원이름(name), 기본급(baseSalary)을 인자로 받는 생성자가 있어야 합니다.
	public Employee2(String id, String name, int baseSalary) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	//3.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	//4.
	public double getSalary(double bonus) {
		return baseSalary + baseSalary * bonus ;  //1회성이면 한 줄로 써도 됨.
		//		double salary = baseSalary + baseSalary * bonus ; 
		//		return salary;		
	}
	//5.
	@Override
	public String toString() {
		return "Employee2 [id=" + id + ", name=" + name + ", baseSalary=" + baseSalary + "]";
	}
	
	String toString2() {
		return "name(id) 사원의 기본급은 baseSalary원 입니다.";
	}
	
	
	
	
	
	
	
	
	
}
