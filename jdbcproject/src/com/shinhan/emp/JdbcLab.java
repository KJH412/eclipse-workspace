package com.shinhan.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcLab {

	static Scanner sc = new Scanner(System.in); //static으로 공유

	public static void main(String[] args) {
		
		boolean isStop = false;
		//여기서 DB연결?(X) 작업끝나면 DB를 끊어야한다.
		while(!isStop) {
			int selectJob = menu();
			switch(selectJob) {
			case 1 -> {
				//Connection conn = dbConnection(); //DB연결, 메소드로 넣음.
				//Statement st = conn.createStatement(); //예외처리하면 코드길어져서 메소드로 분리
				
				//이 문장(sql)을 실행. (쿼리문 앞 뒤 공백주기!, 명령어 붙을 수 도 있음.)
				String sql = " select salary, hire_date "
						+ " from employees"
						+ " where first_name = INITCAP( 'adam')"; 
				method1(sql);
			}
			case 2 -> {
				String sql = " select * "
						+ " from countries\r\n"
						+ "where lower(country_name) = 'united states of america'"; 
				method2(sql);
			}
			case 3 -> { //칼럼이 하나뿐.. 문자열 하나
				String sql = "select 'Adam의 입사일은'||first_name||'의 입사일은'|| hire_date||'급여는' ||salary||'입니다.' "
						+ " from employees";
				method3(sql);
			}
			case 4 -> {
				String sql = " select FIRST_NAME, SALARY, HIRE_DATE"
						+ " from employees "
						+ " where length(FIRST_NAME) <=  "; //글자수>입력 받은 값으로 비교해보기.
				method4(sql);
			}
			case 5 -> {
				String sql =" select first_name, salary, hire_date "
						+ " from employees\r\n"
						+ " where to_char(hire_date,'yyyy') = "; //년도 가변숫자 입력받기.
				method5(sql);
			}
			case 6 -> {
				String sql =" select first_name, hire_date, "
						+" trunc(MONTHS_BETWEEN(SYSDATE,hire_date)/12) 년차 "
						+ " from employees "
						+ "where  MONTHS_BETWEEN(SYSDATE,hire_date)/12 >= "; //가변숫자 입력받기
				method6(sql);
			}
			case 7 -> {isStop = true;} //end
			default ->{System.out.println("입력한 작업은 지원되지 않음. 다시선택~");}
			}
		}
		//여기서 해제?(X)
		System.out.println("====시스템 종료====");
	}

	
	private static void method6(String sql) {
		Connection conn = dbConnection(); 
		try {
			Statement st = conn.createStatement(); //통로만듦
			
			System.out.println("근무년수 몇년이상?>>");
			int num = sc.nextInt();
			
			ResultSet rs = st.executeQuery(sql + num); //년도 입력 받기
			int i = 0;
			while(rs.next()) { 
				i++;
				String name = rs.getString(1);
				int sal = rs.getInt(3);
				Date hdate = rs.getDate(2);
				System.out.println(i + "==>" + name + "\t" + sal + "\t" + hdate);
			}
			dbDisconnect(conn,st,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	private static void method5(String sql) {
		Connection conn = dbConnection(); 
		try {
			Statement st = conn.createStatement(); //통로만듦
			
			System.out.println("근무년수 몇년이상?>>");
			int num = sc.nextInt();
			
			ResultSet rs = st.executeQuery(sql + num); //년도 입력 받기
			int i = 0;
			while(rs.next()) { 
				i++;
				String name = rs.getString(1);
				int sal = rs.getInt(2);
				Date hdate = rs.getDate(3);
				System.out.println(i + "==>" + name + "\t" + sal + "\t" + hdate);
			}
			dbDisconnect(conn,st,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	private static void method4(String sql) {
		Connection conn = dbConnection(); 
		try {
			Statement st = conn.createStatement(); //통로만듦
			
			System.out.println("이름이 몇글자 이하>>");
			int num = sc.nextInt();
			
			ResultSet rs = st.executeQuery(sql + num); //글자 수 입력 받기
			int i = 0;
			while(rs.next()) { 
				i++;
				String name = rs.getString(1);
				int sal = rs.getInt(2);
				Date hdate = rs.getDate(3);
				System.out.println(i + "==>" + name + "\t" + sal + "\t" + hdate);
			}
			dbDisconnect(conn,st,rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private static void method3(String sql) { 
		//DB연결
		Connection conn = dbConnection(); 
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			int i = 0;
			while(rs.next()) { 
				i++;
				String info = rs.getString(1);
				System.out.println(i + "==>" + info);
			}
			dbDisconnect(conn, st, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}


	private static void method2(String sql) {
		//DB연결
		Connection conn = dbConnection(); 
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) { //쿼리문이 있을 때 까지
				String country_id = rs.getString(1); //칼럼번호1
				String country_name = rs.getString("country_name"); //칼럼이름 읽어도 된다.
				int regionId = rs.getInt("region_id"); 
				System.out.println(country_id+ " : "+country_name+ " : "+regionId);
			}
			//DB연결 끊기(메소드로 보냄)
			dbDisconnect(conn,st,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


	private static void method1(String sql) {
		//DB연결
		Connection conn = dbConnection(); 
		try {
			Statement st = conn.createStatement();//통로
			ResultSet rs = st.executeQuery(sql);
			
			/* 이런방식도 있다.
			 * ResultSetMetaData metaData = rs.getMetaData();
 			 * System.out.println(metaData.getColumnName());
			 */
			while(rs.next()) { //쿼리문이 있을 때 까지
				int salary = rs.getInt(1);
				Date hdate = rs.getDate(2);
				System.out.println(salary + "\t" + hdate);
			}
			//DB연결 끊기(메소드로 보냄)
			dbDisconnect(conn,st,rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void dbDisconnect(Connection conn, Statement st, ResultSet rs) throws SQLException {
		// 닫을 때는 자바와 가까운 순서부터 닫는다.
		//method1()에 catch가 있어서 예외 던짐.
		rs.close(); 
		st.close();
		conn.close();
		System.out.println("3.실행 후 DB해제");
	}


	//DB연결
	private static Connection dbConnection() {//conn을 리턴하니까 메소드 리턴타입은 Connection
		//1.JDBC Driver load 
		//2. Connection생성
		//ip ->  192.168.0.151 localhost 127.0.0.1
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; //외울 수 X -> Java EE로바꿔서>Data Sourse Explorer에서 복사
		String userid = "hr";
		String password = "hr";
		Connection conn = null; //초기화(아직 줄 수 있는게 없어서 null)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC 드라이버 로드 성공");
			conn = DriverManager.getConnection(url,userid,password);//catch
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
		
	}

	private static int menu() {
		System.out.println("=====================================");
		System.out.println("1.INITCAP 2.LOWER 3.CONCAT 4.LENGTH");
		System.out.println("5.TO_CHAR 6.MOTHS_BETWEEN 7.END");
		System.out.print("작업을 선택>");
		int job = sc.nextInt(); //작업 번호 선택
		System.out.println("=====================================");
		return job; //작업선택 후 넘어가도록 return함.
	}

}
