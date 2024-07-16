package com.shinhan.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;


//@SuppressWarnings("serial")

//.do가 붙은 주소이름을 가진 서블릿을 요청했을 때 이곳으로 오도록
@WebFilter("*.do")
public class LoginCheckFilter extends HttpFilter implements Filter {
  
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//로그인 하지 않으면 업무 로직 수행 못함
		
		//ServletRequest를 HttpServletRequest로 형변환한다(상위->하위)
		HttpServletRequest req = (HttpServletRequest)request; 
		HttpServletResponse rep = (HttpServletResponse)response; 
		HttpSession session = req.getSession();
		
		
		//webshop/auth/login.do <= req.getRequestURI()
		if(!req.getRequestURI().endsWith("login.do")) {//로그인이 아닐 때
			
			session.setAttribute("lastRequest", req.getRequestURI());//session에 저장
			//System.out.println(req.getRequestURI());
			EmpDTO emp = (EmpDTO)session.getAttribute("loginEmp");
			
			if(emp==null ) {
				//로그인 되어 있지 않으면 브라우저로 내려가서 로그인으로 재요청
				//파일 경로를 ../로 작성하면 다른위치에 있을 경우 404 오류
				String path = req.getServletContext().getContextPath();
				rep.sendRedirect(path + "/auth/login.do"); 
				return;
			}
		}
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
