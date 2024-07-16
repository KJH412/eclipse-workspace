package day04.lab5;

public class Employee2Test {

	public static void main(String[] args) {
		Employee2 emp = new Employee2("123","홍길동",100);
		emp.setId("555");
		emp.setName("김이름");
		emp.setBaseSalary(200);
		
		System.out.println(emp.toString());
		System.out.println(emp);
	}

}
