package com.shinhan.frontpattern;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.filter.MySessionListener;

public class LoginController implements CommonControllerInterface{

	@Override
	public String execute(Map<String, Object> dataMap) {
		
		//페이지 (get방식)
		String page = "login.jsp";
		
		//Map타입 dataMap에서 로그인한 이메일과 패스워드를 가져온다.
		String method = (String)dataMap.get("method"); 
		
		if(method.equals("get")) return page;
		
		EmpService service = new EmpService();
		String email = (String)dataMap.get("email");
		String phone = (String)dataMap.get("pswd");
		EmpDTO emp = service.loginCheck(email, phone);
		
		//System.out.println(emp);
		
		if(emp==null || emp.getEmployee_id() == -1) {
			//존재하지 않는 직원
			dataMap.put("message", "존재하지 않는 직원");
		}else if(emp.getEmployee_id() == -2) {
			//비밀번호 오류
			dataMap.put("message", "비밀번호 오류");
		}else {
			//로그인 성공...Home(요청한 페이지로 가기)
			dataMap.put("loginEmp", emp); 
			HttpSession session = (HttpSession)dataMap.get("session");//세션
			String lastRequest = (String)session.getAttribute("lastRequest");
			if(lastRequest == null || lastRequest.equals("")) {
				return "redirect:";
			}else {
				return "redirect:" + lastRequest; 
			}
			//return "redirect:";
		}
		//로그인 실패하면 결과 페이지 보여주기
		return "result.jsp";
	}
	
}
