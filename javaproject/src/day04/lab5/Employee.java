package day04.lab5;

public class Employee {
	
	//필드
	//캡슐화
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;
	
	//생성자 만듦(마우스우클릭)
	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		computeTotalSalary();
	}
	

	public void computeTotalSalary() {
		if(title.equals("부장")) { //.equals
			totalSalary = (int)(baseSalary + baseSalary*0.25); //int로 캐스팅.
		}else if(title.equals("과장")) {
			totalSalary = (int)(baseSalary + baseSalary*0.15);
		}else {
			totalSalary = (int)(baseSalary + baseSalary*0.05);
		}
		
		
		//오답풀이) 문자열을 비교할때는 == 을 쓰면 안됨. 필드에서 값을 조작했을 때 결과값이 바뀔 수 도 있기 때문이다.
//		if(title == "과장") {
//			totalSalary = baseSalary + baseSalary/15;
//		}else {
//			totalSalary = baseSalary + baseSalary/5;
//		}
	}
	
	public void print() {
		System.out.println(title +" 직급의 "+name+"씨의 본봉은 "
							+ baseSalary + "원이고 총 급여는" 
							+ totalSalary+"입니다.");
	}
}
