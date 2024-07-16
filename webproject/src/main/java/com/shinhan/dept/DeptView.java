package com.shinhan.dept;

import java.util.List;


public class DeptView {
	public static void print(List<DeptDTO> deptlist, String title) {
		System.out.printf("=============%s============\n", title);
		if (deptlist.size() == 0) {
			System.out.println("조건에 해당하는 데이터가 없습니다.");
			return;
		}
		// stream으로 반복
		deptlist.stream().forEach(dep -> System.out.println(dep));
	}

	public static void print(DeptDTO dep, String title) {
		System.out.printf("=============%s============\n", title);
//		if (dep == null) {
//			System.out.println("존재하지 않는 부서입니다.");
//		} else {
//			System.out.println("부서 번호:" + dep.getDepartment_id());
//			System.out.println("부서 이름:" + dep.getDepartment_name());
//			System.out.println("매니저 번호:" + dep.getManager_id());
//			System.out.println("위치 번호:" + dep.getLocation_id());
//			
//			
//		}
		if (dep == null) {
			System.out.println("존재하지 않는 부서입니다.");
		} else if (dep.getManager_id() != 0 && dep != null) {
			System.out.println("부서 번호:" + dep.getDepartment_id());
			System.out.println("부서 이름:" + dep.getDepartment_name());
			System.out.println("매니저 번호:" + dep.getManager_id());
			System.out.println("위치 번호:" + dep.getLocation_id());
		}else {
			System.out.println("부서 번호:" + dep.getDepartment_id());
			System.out.println("부서 이름:" + dep.getDepartment_name());
			System.out.println("매니저 번호:" + dep.getManager_id()+" =>null (매니저 번호가 없습니다.)");
			System.out.println("위치 번호:" + dep.getLocation_id());
		}
	}

	public static void print(String message) { 
		System.out.printf("=============%s============\n", message);
	}

	
}
