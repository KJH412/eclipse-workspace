package day04.lab5;

public class EmployeeExam {

	public static void main(String[] args) {
		//배열생성
		Employee[] arr = new Employee[4];
				
		//Employee객체 생성
		arr[0] = new Employee("이부장","부장",1500000);
		arr[1] = new Employee("김과장","과장",1300000);
		arr[2] = new Employee("최대리","대리",1200000);
		arr[3] = new Employee("박사원","사원",1000000);
		
		for(Employee e : arr) { // 향상된 for
			e.print();
		}
		
//		e1.print(); 비효율적. 배열로 변수 만들어서 출력하기.
//		e2.print();
//		e3.print();
//		e4.print();
		
	}

}
