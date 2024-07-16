package com.shinhan.boardcontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.dto.BoardDTO;
import com.shinhan.emp.EmpDTO;
import com.shinhan.model.BoardService;


//@WebServlet("/board/boardInsert.do")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("boardinsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * String title = request.getParameter("title"); String content =
		 * request.getParameter("content"); String pic = request.getParameter("pic");
		 * 
		 * HttpSession session = request.getSession(); EmpDTO emp = (EmpDTO)
		 * session.getAttribute("loginEmp"); String writer = emp.getFirst_name() +
		 * emp.getLast_name();
		 * 
		 * BoardDTO board = new BoardDTO(0, title, content, writer, pic, null);
		 * 
		 * int result = new BoardService().insertBoard(board); System.out.println(result
		 * + "건 입력 완료");
		 * 
		 * response.sendRedirect("selectAll.do");
		 */
		
		String encoding = "utf-8"; // 파일 이름에 한글이 들어있을 경우가 있으므로
		request.setCharacterEncoding(encoding);
		
		String path = getServletContext().getRealPath("."); // 현재 경로 얻기
		File currentDirPath = new File(path + "/upload");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory); // 업로드 된 파일 얻기
		
		BoardDTO board = new BoardDTO();

		//이미지 서버에 저장
		
		try {
			List items = upload.parseRequest(request); // 요청이 request 안에 들어오기 때문에 list로 바꿔서 읽어주기
			
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				// 입력 text field
				// 글씨 읽기 (isFormField : 입력하는 input)
				if (fileItem.isFormField()) {
					// title, content 읽기
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					
					// 필드 생성 부분
					if (fileItem.getFieldName().equals("title")) board.setTitle(fileItem.getString(encoding));
					if (fileItem.getFieldName().equals("content")) board.setContent(fileItem.getString(encoding));
					
				// 이미지 읽기
				} else {
					if (fileItem.getFieldName().equals("pic")) board.setPic(fileItem.getName());
					
					// System.out.println("getFieldName:" + fileItem.getFieldName());
					// System.out.println("getName:" + fileItem.getName()); // 이걸 저장 해야 함
					// System.out.println("getSize:" + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx + 1);
						
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile); // 파일 upload (저장)
						
					} // end if
				} // end if
			} // end for
			
			// DB 저장하기
			HttpSession session = request.getSession();
			EmpDTO emp = (EmpDTO) session.getAttribute("loginEmp");
			
			String writer = emp.getFirst_name() + emp.getLast_name();
			board.setWriter(writer);
			
			int result = new BoardService().insertBoard(board);
			System.out.println(result+ "건 입력 완료");
			
			response.sendRedirect("selectAll.do");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}