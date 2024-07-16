package com.shinhan.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String file_repo = getServletContext().getRealPath("./upload");
		String fileName = (String) request.getParameter("fileName");
		System.out.println("fileName=" + fileName);
		
		OutputStream out = response.getOutputStream();
		String downFile = file_repo + "\\" + fileName;
		File f = new File(downFile);//파일
		
		//commons-fileupload-1.3.3.jar 라이브러리 lib에 추가 
		//한글이름파일 다운로드시 깨짐방지를 위해 추가함.
		String fname = URLEncoder.encode(fileName, "utf-8");
		response.setContentType("application/download;utf-8");
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment; fileName=" + fname);
		FileInputStream in = new FileInputStream(f); //파일 읽음
		byte[] buffer = new byte[1024 * 8];
		while (true) {
			int count = in.read(buffer);
			if (count == -1)
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
		
		//response.sendRedirect("selectAll.do");
	}

}