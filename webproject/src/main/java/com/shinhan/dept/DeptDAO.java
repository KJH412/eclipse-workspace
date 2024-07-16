package com.shinhan.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class DeptDAO { //비지니스 로직을 처리
	// 필드
	Connection conn; // DB연결
	Statement st; // sql문장
	ResultSet rs; // 결과
	PreparedStatement pst;

	// 1. 모든 부서 정보 조회
	public List<DeptDTO> selectAll() { 
		// 비즈니스로직
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = "select * from departments";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DeptDTO dep = makeDept(rs);
				deptlist.add(dep);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs); // 작업끊으면 꼭 끊기.
		}
		return deptlist;

	}

	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		DeptDTO dep = new DeptDTO();
		dep.setDepartment_id(rs.getInt("department_id"));
		dep.setDepartment_name(rs.getString("department_name"));
		dep.setManager_id(rs.getInt("manager_id"));
		dep.setLocation_id(rs.getInt("location_id"));
		return dep;
	}
	
	//2. 특정 부서 1건 상세보기
	public DeptDTO selectById(int depid) { 
		DeptDTO dep = null;
		String sql = "select * from departments where department_id = "+ depid;//가변변수. 특정(id)
		conn = DBUtil.dbConnection();
	
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				dep = makeDept(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return dep;
	}
	
	//3.다양한 조건으로 조회하기 (부서 번호=, 부서이름=,매니저아이디=, 위치번호=)
	public List<DeptDTO> selectByCondition(int deptid, String deptname, int manid, int locid) { 
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
		String sql = " ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, deptid); 	//첫번째 ? 
			pst.setString(2,deptname ); //두번째 ? 
			pst.setInt(3, manid); 	//세번째 ? 
			pst.setInt(4, locid); 	
			rs = pst.executeQuery();
			
			while (rs.next()) {
				DeptDTO dep = makeDept(rs);
				deptlist.add(dep);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs); // 작업끊으면 꼭 끊기.
		}
		return deptlist;
		
		
	}
	
	
	
}
