package com.shinhan.dept;

import java.util.List;

//Service: 비즈니스 로직을 수행한다.
public class DeptService {
	
	DeptDAO deptDAO = new DeptDAO();
	
	public List<DeptDTO> selectAll() { 
		
		return deptDAO.selectAll();
	}
	
	public DeptDTO selectById(int depid) { 
		return deptDAO.selectById(depid);
	}
}
