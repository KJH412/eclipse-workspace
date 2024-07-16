package com.shinhan.dept;

import java.util.List;
import java.util.Scanner;

//1 사용자가 요청 -> Controller -> Service
//2 사용자display <-View <-Controller <- Service
//나중에 Servlet서블릿으로 작성할 예정이다.(서버에서 실행되는 자바프로그램)
public class DeptController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean isStop = false;
		DeptService deptService = new DeptService();
		while (!isStop) {
			int selectJob = menuDisplay(); // 메뉴보여줌
			switch (selectJob) {
			case 0 -> { isStop=true;}
			case 1 -> {
				List<DeptDTO> deptlist = deptService.selectAll();
				DeptView.print(deptlist, "모든 부서 정보 조회");
			
			}
			case 2 -> {
				 System.out.println("조회할 부서 번호 >> ");
				 int depid = sc.nextInt();
				 DeptView.print(deptService.selectById(depid), "특정 부서 정보 조회");
			
			}
			case 3 -> {
				
			
			}
			default -> {}
			}
		}
		System.out.println("=============메인END===============");
	}

	
	private static DeptDTO insertMenu() {
		//나중에 HTML로 입력받을 것
		System.out.println("DEPARTMENT_ID >>"); //FK
		int depid = sc.nextInt();
		System.out.println("DEPARTMENT_NAME >>");  
		String depname = sc.next();
		System.out.println("MANAGER_ID >>");
		int manager = sc.nextInt();
		System.out.println("LOCATION_ID >>");
		int location = sc.nextInt();

		DeptDTO dep = new DeptDTO();
		dep.setDepartment_id(depid);
		dep.setDepartment_name(depname);
		dep.setManager_id(manager);
		dep.setLocation_id(location);
		return dep;
		
	}
	

	private static int menuDisplay() {
		System.out.println("=================");
		System.out.println("1.모든 부서 정보 조회");
		System.out.println("2.특정 부서 정보 조회");
		System.out.println("3.조건 조회(부서/직책/입사일/급여)"); 
//		System.out.println("4.부서 입력");
//		System.out.println("5.부서 수정");
//		System.out.println("6.부서 삭제");
		System.out.println("0.종료");
		System.out.print("작업선택>>");
		int job = sc.nextInt();
		System.out.println("=================");
		return job;

	}
}
