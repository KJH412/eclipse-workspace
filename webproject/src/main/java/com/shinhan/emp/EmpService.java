package com.shinhan.emp;

import java.sql.Date;
import java.util.List;
import java.util.Map;

//Controller (요청)-> Service -> DAO  (1)
//Controller <- Service <- DAO  (2)
//Service: 비즈니스 로직을 수행한다.
public class EmpService { //DB와 관련없는 것들

	EmpDAO empDAO = new EmpDAO();
	
	//email
	public int selectByEmail(String email) { 
		return empDAO.selectByEmail(email);
	}
	
	
	//8.삭제(Delete)
	public int empDelete(int empid) {
		return empDAO.empDelete(empid);
	}
	
	//7.수정
	public int empUpdate(EmpDTO emp) {
		return empDAO.empUpdate(emp);
		
	}
	
	//6.입력(Insert) 
	public int empInsert(EmpDTO emp) { 
		return empDAO.empInsert(emp);
	}
	
	//5.다양한 조건으로 조회하기
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) { 
		return empDAO.selectByCondition(deptid,jobid,hdate,salary);
	}
	
	//4.특정 JOB인 직원 정보
	public List<EmpDTO> selectByjob (String jobid) {
		return empDAO.selectByjob(jobid);
	}
	//3.특정 부서 직원
	public List<EmpDTO> selectByDeptId (int deptid) {
		return empDAO.selectByDeptId(deptid);
	}
	
	//2.특정 직원의 상세보기
	public EmpDTO selectById(int empid) { 
		return empDAO.selectById(empid);
	}
	//1.직원 모두 조회
	public List<EmpDTO> selectAll() { 
		
		return empDAO.selectAll(); //DAO호출,변수로 받음
	}

	//직원번호를 이용해서 직원의 이름과 직책과 급여를 조회한다. 
	public Map<String, Object> empInfo(int empid) {
		return empDAO.empInfo(empid);
	}
	public double callFunction(int empid) {
		return empDAO.callFunction(empid);
	}
	
}
