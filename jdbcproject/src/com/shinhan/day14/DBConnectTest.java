package com.shinhan.day14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.net.aso.f;

public class DBConnectTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1.jdbc driver를 class path추가
		//2. jdbc드라이버를 load
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1.oracle driver load성공");
		//2.DB연결
		String url="jdbc:oracle:thin:@localhost:1521:xe", userid="hr", password="hr";
		Connection conn = DriverManager.getConnection(url, userid, password);
		System.out.println("2.DB연결성공");
		String sql = "select first_name,salary,department_id \r\n"
				+ " from employees \r\n"
				+ " where salary>=15000"; //sql문 복사해옴 (주의)""안의 쿼리문에 ;(세미콜론) 들어가면 X => invalid character오류남.
		//3.Statement : 자바와 DB의 대화통로
		Statement st = conn.createStatement();  //여기서 Statement는 java.lang아니고 java.sql.Statement로 작성
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) { //data가 있을 때 까지 반복.
			String fname = rs.getString(1); //첫번째 칼럼 (DB는 1번째부터시작. 0번쨰없음)
			int salary = rs.getInt(2);
			int deptid = rs.getInt(3);
			System.out.printf("%-10s\t%d\t%d\n", fname, salary, deptid);
			
		}
		rs.close();
		st.close();
		conn.close();
	}
}
