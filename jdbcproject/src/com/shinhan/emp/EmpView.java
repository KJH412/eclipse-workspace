package com.shinhan.emp;

import java.util.List;
import java.util.Map;

//View: 사용자에게 어떻게 보여줄지를 담당한다. JSP로 작성할 예정이다.(웹)
public class EmpView {

	public static void print(List<EmpDTO> emplist, String title) {
		System.out.printf("=============%s============\n",title);
		if(emplist.size()==0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
			return;
		}
		//stream으로 반복
		emplist.stream().forEach(emp -> System.out.println(emp));
	}
	public static void print(EmpDTO emp, String title) { //Overloading(이름같은메소드,매개변수다름)
		System.out.printf("=============%s============\n",title);
//		System.out.println(emp);
		if(emp==null) {
			System.out.println("존재하지 않는 직원입니다.");
		}else {
			System.out.println("직원번호:" + emp.getEmployee_id());
			System.out.println("이름:" + emp.getFirst_name());
			System.out.println("성:" + emp.getLast_name());
			System.out.println("급여:" + emp.getSalary());
			System.out.println("이메일:" + emp.getEmail());
			System.out.println("입사일:" + emp.getHire_date());
			System.out.println("부서:" + emp.getDepartment_id());
			System.out.println("커미션:" + emp.getCommission_pct());
			System.out.println("매니저:" + emp.getManager_id());
			System.out.println("전화번호:" + emp.getPhone_number());
		}
	}
	public static void print(String message) { //Overloading(이름같은메소드,매개변수다름)
		System.out.printf("=============%s============\n",message);
	}

	public static void print(Map<String, Object> emp) { //Overloading(이름같은메소드,매개변수다름)
		for(String key:emp.keySet()) {
			System.out.println(key + " ==> " + emp);
		}
	}
	
}
