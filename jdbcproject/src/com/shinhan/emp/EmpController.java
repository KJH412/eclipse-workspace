package com.shinhan.emp;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.shinhan.util.DateUtil;

//1 사용자가 요청 -> Controller -> Service
//2 사용자display <-View <-Controller <- Service
//나중에 Servlet서블릿으로 작성할 예정이다.(서버에서 실행되는 자바프로그램)
public class EmpController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;
		EmpService empService = new EmpService();
		while (!isStop) {
			int selectJob = menuDisplay(); // 메뉴보여줌
			switch (selectJob) {
			case 0 -> { isStop=true;}
			case 1 -> {
				List<EmpDTO> emplist = empService.selectAll();
				EmpView.print(emplist, "모든 직원 조회"); // print(데이터,title)메소드 만듦.
			}
			case 2 -> {
				System.out.print("조회할 직원 번호>>");
				int empid = sc.nextInt();
				EmpView.print(empService.selectById(empid), "특정직원조회");
			}
			case 3 -> {
				System.out.print("조회할 직원 부서>>");
				int deptid = sc.nextInt();
				EmpView.print(empService.selectByDeptId(deptid), "특정부서 직원조회");
			}
			case 4 -> {
				System.out.print("조회할 JOB(예,IT_PROG)>>");
				String jobid = sc.next();
				EmpView.print(empService.selectByjob(jobid), "특정 JOB인 직원");
			}
			case 5 -> {
				System.out.println("조회 할 (부서/직책/입사일(0000-00-00)/급여)(예,60 IT_PROG 2005-01-01 5000)>>");
				int deptid = sc.nextInt();
				String jobid = sc.next();
				//(Date)getUtilDate로 형변환 안됌. util은 sql문을 쓸 수 없음
				//여기 Date는 java.sql.Date sql로 import했기 때문에~
				//import는 전체에 sql데이터를 쓴다고 보면 됨.
				Date hdate = DateUtil.getSQLDate(sc.next());  // 형식0000-00-00
				//Date hdate = DateUtil.getSQLDate(sc.next());  // 형식0000-00-00
				int salary = sc.nextInt();
				EmpView.print(empService.selectByCondition(deptid,jobid,hdate,salary), "(부서/직책/입사일/급여)조건 조회");
			}
			case 6 -> {
				//모듈화-함수로뺌.
				EmpDTO emp = insertMenu();
				int result = empService.empInsert(emp);
				EmpView.print(result > 0 ? "입력 성공":"입력 실패");
			}
			case 7 -> {
				EmpDTO emp = insertMenu();
				int result = empService.empUpdate(emp);
				EmpView.print(result > 0 ? "수정 성공":"수정 실패");
			}
			case 8 -> {
				System.out.print("삭제할 직원번호>>");
				int empid = sc.nextInt();
				int result = empService.empDelete(empid);
				EmpView.print(result > 0 ? "수정 성공":"수정 실패");
			}
			case 9 -> {
				System.out.print("조회할 직원번호 >>");
				int empid = sc.nextInt();
				//컨트롤러>서비스>뷰>DAO순으로 만들어 봄.
				//3개만 받아오고 싶다.  Map으로 받을 수 있다. 매개변수Map을 받는 print함수도 새로 생성.
				//emp정보가 모든칼럼이면 DTO, (이름,job,salary)만 가져오기 
				Map<String, Object> emp = empService.empInfo(empid);   //empInfo메소드 자동create생성(역으로 만들어봄)
				EmpView.print(emp);
			}
			case 10 -> {
				System.out.print("조회할 직원번호 >>");
				int empid = sc.nextInt();
				double result = empService.callFunction(empid);   //empInfo메소드 자동create생성(역으로 만들어봄)
				EmpView.print("직원의 보너스: "+result);
			
			}
			default -> {}
			}
		}
		System.out.println("=============메인END===============");
	}

	private static EmpDTO insertMenu() {
		//나중에 HTML로 입력받을 것
		System.out.println("EMPLOYEE_ID >>"); //FK
		int empid = sc.nextInt();
		System.out.println("FIRST_NAME >>");  
		String fname = sc.next();
		System.out.println("LAST_NAME >>");
		String lname = sc.next();
		System.out.println("EMAIL >>");
		String email = sc.next();
		System.out.println("PHONE_NUMBER >>");
		String phone = sc.next();
		System.out.println("HIRE_DATE >>");
		Date hdate = DateUtil.getSQLDate(sc.next());
		System.out.println("JOB_ID >>"); //FK
		String jobid = sc.next();
		System.out.println("SALARY >>");
		int sal = sc.nextInt();
		System.out.println("COMMISSION_PCT >>"); //FK
		Double comm = sc.nextDouble();
		System.out.println("MANAGER_ID >>"); //FK
		int mid = sc.nextInt();
		System.out.println("DEPARTMENT_ID >>"); //FK
		int deptid = sc.nextInt();
		
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setLast_name(lname);
		emp.setHire_date(hdate);
		emp.setJob_id(jobid);
		emp.setManager_id(mid);
		emp.setSalary(sal);
		emp.setPhone_number(phone);
		return emp;
		
		/* desc employees; 칼럼명 복사
		 EMPLOYEE_ID                              
		 FIRST_NAME                                         
		 LAST_NAME                                
		 EMAIL                                    
		 PHONE_NUMBER                                     
		 HIRE_DATE                               
		 JOB_ID                                    
		 SALARY                                           
		 COMMISSION_PCT                                  
		 MANAGER_ID                                     
		 DEPARTMENT_ID                                 
		*/
		
	}

	private static int menuDisplay() {
		System.out.println("=================");
		System.out.println("1.모든 직원 조회");
		System.out.println("2.특정 직원 조회");
		System.out.println("3.특정부서의 직원 조회"); //값:숫자
		System.out.println("4.특정 JOB인 직원 조회"); //값:문자
		System.out.println("5.조건 조회(부서/직책/입사일/급여)"); //4가지 입력받기
		System.out.println("6.직원입력");
		System.out.println("7.직원수정");
		System.out.println("8.직원삭제");
		System.out.println("9.Procedure호출(직원번호/정보OUT)");
		System.out.println("10.Function호출(f_bonus)");
		System.out.println("0.종료");
		System.out.print("작업선택>>");
		int job = sc.nextInt();
		System.out.println("=================");
		return job;

	}
}
