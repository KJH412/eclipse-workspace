package day04.lab6;

public class School {

	public static void main(String[] args) {
		Student st = new Student("홍길동", 20, 200201);
		st.print();
		
		Teacher tc = new Teacher("이순신", 30, "JAVA");
		tc.print();
		
		Employee ep = new Employee("유관순", 40, "교무과");
		ep.print();
	}

}
