package com.shinhan.lab.lab6;

class Employee3{
	
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;
	
	public Employee3(String name, String title, int baseSalary ) {
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		getTotalSalary();
	};
	

	public void getTotalSalary() {
		
		if(title.equals("부장")) {
			totalSalary = (int) (baseSalary + baseSalary*0.25);
		}else if(title.equals("과장")) {
			totalSalary = (int) (baseSalary + baseSalary*0.15);
		}else {
			totalSalary = (int) (baseSalary + baseSalary*0.05);
		}
	
	}
	 public void print() {

		 System.out.println(title+" 직급의 "+ name + "씨의 본봉은 " + baseSalary + "원이고 총급여는" + totalSalary + "원입니다.");
	 }
	
}


public class Lab5 {

	public static void main(String[] args) {
		Employee3 em = new Employee3("이부장", "부장" , 150000 );
		Employee3 em2 = new Employee3("김부장", "과장" , 130000);
		Employee3 em3 = new Employee3("최대리", "대리" , 120000);
		Employee3 em4 = new Employee3("박사원", "사원" , 100000);
		
		em.print();
		em2.print();
		em3.print();
		em4.print();
	}

}
