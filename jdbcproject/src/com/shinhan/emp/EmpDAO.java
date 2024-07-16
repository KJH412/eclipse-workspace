package com.shinhan.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement; //바인딩 변수(?)사용
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shinhan.util.DBUtil;

//DAO(Data Access하는 비지니스 로직을 처리하는 Object)
public class EmpDAO {
	//필드
	Connection conn; //DB연결
	Statement st; //sql문장받음
	ResultSet rs; //결과보냄
	PreparedStatement pst; //Statement를 상속받음, 바인딩 변수(?) 지원!
	
	//8.삭제(Delete)
	public int empDelete(int empid) {
		int result = 0;
		String sql = "delete from employees "
				+ " where EMPLOYEE_ID=? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,  empid);
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//7.수정(Update)
	public int empUpdate(EmpDTO emp) {
		int result = 0;
		String sql = "update employees "
				+ " set FIRST_NAME=?, "
				+ "     LAST_NAME=?, "
				+ "     EMAIL=?, "
				+ "     PHONE_NUMBER=?, "
				+ "     HIRE_DATE=?, "
				+ "     JOB_ID=?, "
				+ "     SALARY=?, "
				+ "     COMMISSION_PCT=?, "
				+ "     MANAGER_ID=?,"
				+ "     DEPARTMENT_ID=? "
				+ " where EMPLOYEE_ID=? ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(11, emp.getEmployee_id()); //순서마지막으로바뀜
			pst.setString(1, emp.getFirst_name());
			pst.setString(2, emp.getLast_name());
			pst.setString(3, emp.getEmail());
			pst.setString(4, emp.getPhone_number());
			pst.setDate(5, emp.getHire_date());
			pst.setString(6, emp.getJob_id());
			pst.setInt(7, emp.getSalary());
			pst.setDouble(8, emp.getCommission_pct());
			pst.setInt(9, emp.getManager_id());
			pst.setInt(10, emp.getDepartment_id());
			
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//6.입력(Insert) 
	public int empInsert(EmpDTO emp) {  //11개를 다 쓸 수 없으니 DTO만들어서 넣어줌.
		int result = 0;
		String sql = "insert into employees values ( ?,?,?,?,?,?,?,?,?,?,? )"; //칼럼명 생략=>칼럼순서대로 값넣어야함.
		conn = DBUtil.dbConnection(); //setAutoCommit(true)되어있음.
		try {
//			conn.setAutoCommit(true); 자동으로 커밋되어있음.
			
			pst = conn.prepareStatement(sql);
			//칼럼 순서를 맞춰서 써줘야 한다.
			pst.setInt(1, emp.getEmployee_id());
			pst.setString(2, emp.getFirst_name());
			pst.setString(3, emp.getLast_name());
			pst.setString(4, emp.getEmail());
			pst.setString(5, emp.getPhone_number());
			pst.setDate(6, emp.getHire_date());
			pst.setString(7, emp.getJob_id());
			pst.setInt(8, emp.getSalary());
			pst.setDouble(9, emp.getCommission_pct());
			pst.setInt(10, emp.getManager_id());
			pst.setInt(11, emp.getDepartment_id());
			
			//DML문장(insert)은 executeUpdate, Select문은 excuteQuery
			result = pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//5.다양한 조건으로 조회하기
	//부서별(=), 직책별(=), 입사일별(>=), 급여(>=)
	public List<EmpDTO> selectByCondition(int deptid, String jobid, Date hdate, int salary) { 
		List<EmpDTO> emplist = new ArrayList<EmpDTO>(); 
		String sql = "select * "
				+ " from employees "
				+ " where department_id = ?"
				+ " and job_id = ? "
				+ " and hire_date >= ? "
				+ " and salary >= ? "; 
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid); 	//첫번째 ?에 deptid넣기
			pst.setString(2, jobid); //두번째 ? jobid
			pst.setDate(3, hdate); 	//세번째 ? hdate
			pst.setInt(4, salary);  //네번째 ? salary
			rs = pst.executeQuery();
		
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs); 
		}
		return emplist;
		
	}
	
	
	//4.특정 JOB인 직원 정보 (여러건 조회 List)
		public List<EmpDTO> selectByjob(String jobid) { //여러건이라서 메소드 리턴타입List로!
			//비즈니스로직
			List<EmpDTO> emplist = new ArrayList<EmpDTO>(); 
			/*
			 * String sql = "select * from employees where job_id = '"
						+jobid
						+"'";  //sql문에서 문자열String을 ''안에 넣어줘야함
			*/
			//?:바인딩 변수,  PreparedStatement 지원받아야 사용 가능.
//			String sql = "select * from employees where job_id = ?";
			String sql = "select * from employees where job_id like ? || '%' "; //?만 가변
//			String sql = "select * from employees where job_id like '" + jobid + "%'";
			conn = DBUtil.dbConnection();
			try {
				//PreparedStatement ?바인딩 변수 사용.
				pst = conn.prepareStatement(sql);
				pst.setString(1, jobid); //첫번째(?)에 jobid를 넣음.
				rs = pst.executeQuery();
				/*
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				*/
				while(rs.next()) {
					EmpDTO emp = makeEmp(rs);
					emplist.add(emp);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.dbDisconnect(conn, pst, rs); //자식이 부모에 들어갈 수 있음.pst
			}
			return emplist;
			
		}
	
	//3.특정 부서 직원의 정보 (여러건 조회 List)
	public List<EmpDTO> selectByDeptId(int deptid) { //여러건이라서 메소드 리턴타입List로!
		//비즈니스로직
		List<EmpDTO> emplist = new ArrayList<EmpDTO>(); 
		String sql = "select * from employees where department_id = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid); //첫번째(?)에 넣음.
			rs = pst.executeQuery();
			
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs); //작업끊으면 꼭 끊기.
		}
		return emplist;
		
	}
	
	//2.특정 직원의 상세보기 (1건 조회)
	public EmpDTO selectById(int empid) { //EmpDTO타입-한건조회
		EmpDTO emp = null;
		String sql = "select * from employees where employee_id = "+ empid;//가변변수. 특정(id)직원
		conn = DBUtil.dbConnection(); //DB연결
		try {
			st = conn.createStatement();//통로
			rs = st.executeQuery(sql); //sql문장 실행
			if(rs.next()) { //있으면
				emp = makeEmp(rs); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
		return emp; //없으면 null 리턴.
	}
	
	//1.직원 모두 조회 (여러건 조회 List)
	public List<EmpDTO> selectAll() { //여러건이라서 메소드 리턴타입List로!
		//비즈니스로직
		List<EmpDTO> emplist = new ArrayList<EmpDTO>(); //new ArrayList부분은 바뀔 수 있음(그래서 변수 타입 List 줌.)
		String sql = "select * from employees";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				EmpDTO emp = makeEmp(rs);
				emplist.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs); //작업끊으면 꼭 끊기.
		}
		return emplist;
		
	}
	//특정 직원 1명 조회
	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(rs.getDouble("commission_pct")); //예외발생 던짐.
		emp.setDepartment_id(rs.getInt("department_id")); 
		emp.setEmail(rs.getString("email"));
		emp.setEmployee_id(rs.getInt("employee_id"));
		emp.setFirst_name(rs.getString("first_name"));
		emp.setLast_name(rs.getString("last_name"));
		emp.setJob_id(rs.getString("job_id"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setManager_id(rs.getInt("manager_id"));
		emp.setPhone_number(rs.getString("phone_number"));
		emp.setSalary(rs.getInt("salary"));
		return emp;
	}

	//저장 프로시저 호출
	//직원번호를 입력받아서 직원정보(이름,직책,급여)를 return
	public Map<String, Object> empInfo(int empid) {
		 Map<String, Object> empMap = new HashMap<>();
		 //3개 변수 초기화
		 String fname = null, job=null;
		 int salary = 0;
		 String sql = "{call sp_empInfo(?,?,?,?)}"; //call호출 프로시저이름(가변)
		 CallableStatement cstmt = null; //변수초기화
		 conn = DBUtil.dbConnection();
		 try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(1, empid);
			cstmt.registerOutParameter(2, Types.VARCHAR);  //받을 타입을 써준다.
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			boolean result =cstmt.execute(); //실행
			fname = cstmt.getString(2);
			job = cstmt.getString(3);
			salary = cstmt.getInt(4);
			empMap.put("fname", fname); //키와 값
			empMap.put("job", job); //키와 값
			empMap.put("salary", salary); //키와 값
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, cstmt, rs);
		}
		 
		return empMap;
	}
	
	//저장 함수 호출
	//직원번호가 들어오면 직원 보너스를 return하는 함수를 호출한다.
	public double callFunction(int empid) {
		double bonus = 0;
		String sql = "select f_bonus(?) from dual"; //f_bonus(?) : PreparedStatement  , 값 1개만 가져오려고 하기 때문에 employees X
		conn = DBUtil.dbConnection(); 
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empid);
			rs = pst.executeQuery();
			if(rs.next()) {
				bonus =rs.getDouble(1); //리턴값 넣어줘야함.
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bonus;
	}
	
}
