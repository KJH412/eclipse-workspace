package com.shinhan.frontpattern;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.shinhan.dto.BoardDTO;
import com.shinhan.emp.EmpDTO;
import com.shinhan.model.BoardService;

public class BoardInsertController implements CommonControllerInterface {

	@Override
	public String execute(Map<String, Object> dataMap) {
		String page = "/board/boardinsert.jsp";
		String method = (String) dataMap.get("method");

		if (method.equals("post")) {

			String encoding = "utf-8";

			EmpDTO loginEmp = (EmpDTO) dataMap.get("loginEmp");
			HttpServletRequest request = (HttpServletRequest) dataMap.get("request");

			String path = request.getServletContext().getRealPath("."); // 현재 경로 얻기

			File currentDirPath = new File(path + "/upload");
			DiskFileItemFactory factory = new DiskFileItemFactory();

			factory.setRepository(currentDirPath);
			factory.setSizeThreshold(1024 * 1024);

			ServletFileUpload upload = new ServletFileUpload(factory); // 업로드 된 파일 얻기

			BoardDTO board = new BoardDTO();

			try {
				List items = upload.parseRequest(request);

				for (int i = 0; i < items.size(); i++) {
					FileItem fileItem = (FileItem) items.get(i);

					// 입력 text field
					// 글씨 읽기 (isFormField : 입력하는 input)
					if (fileItem.isFormField()) {
						// title, content 읽기
						System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));

						// 필드 생성 부분
						if (fileItem.getFieldName().equals("title"))
							board.setTitle(fileItem.getString(encoding));
						if (fileItem.getFieldName().equals("content"))
							board.setContent(fileItem.getString(encoding));

						// 이미지 읽기
					} else {
						if (fileItem.getFieldName().equals("pic"))
							board.setPic(fileItem.getName());

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
				String writer = loginEmp.getFirst_name() + loginEmp.getLast_name();
				board.setWriter(writer);

				int result = new BoardService().insertBoard(board);
				System.out.println(result + "건 입력 완료");

				return "redirect:selectAll.do";

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return page;

	}
}
