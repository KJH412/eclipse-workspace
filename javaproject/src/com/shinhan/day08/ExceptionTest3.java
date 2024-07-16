package com.shinhan.day08;

import java.io.IOException;
/*
 * 7번
 *  login() 메소드에서 존재하지 않는 ID를 입력하면 NotExistIDException을 발생시키고, 잘못된 패스워드를 입력하면 WrongPasswordException을 발생
 * 
 * */
class NotExistIDException extends Exception {
	public NotExistIDException() {}

	public NotExistIDException(String message) {
		super(message);
	}
}

class WrongPasswordException extends Exception {
	public WrongPasswordException() {} //생성자

	public WrongPasswordException(String message) { //생성자
		super(message);
	}
}

class FileWriter implements AutoCloseable {
	public FileWriter(String filePath) throws IOException {
		System.out.println(filePath + " 파일을 엽니다.");
	}

	public void write(String data) throws IOException { // import IOException
		System.out.println(data + "를 파일에 저장합니다.");
	}

	@Override
	public void close() throws IOException {
		System.out.println("파일을 닫습니다.");
	}
}

public class ExceptionTest3 {

	public static void main(String[] args) {

		// 확인문제8 더 단순하게 바꿈.
		try(FileWriter fw = new FileWriter("file.txt")) {
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	public static void f3(String[] args) {

		// 확인문제8
		FileWriter fw = null;
		try {
			fw = new FileWriter("file.txt");
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
			}
		}
	}

	public static void f2(String[] args) {

		// 챕터 11 확인문제 7번
		try {
			f2("admin", "1234");
		} catch (NotExistIDException e) { // 빨간줄 오류
			// TODO: handle exception
			e.printStackTrace();
		} catch (WrongPasswordException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			System.out.println("---------------------");
		}
		System.out.println("method end~~~");
	}

	// 챕터 11 확인문제 7번
	private static void f2(String id, String pw) throws NotExistIDException, WrongPasswordException {
		if (id.equals("admin"))
			throw new NotExistIDException("아이디가 존재하지 않습니다"); 
		if (pw.equals("admin"))
			throw new WrongPasswordException("패스워드가 존재하지 않습니다");

	}

	// 챕터 11 확인문제 6번
	public static void f1(String[] args) {
		String[] strArray = { "10", "2a" };
		int value = 0;
		for (int i = 0; i <= 2; i++) {
//			value = Integer.parseInt(strArray[i]); 이렇게만 쓰면 에러가 남. 예외처리필요.

			try {
				value = Integer.parseInt(strArray[i]); // strArray[2]없음 -> 인덱스초과
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("인덱스를 초과했음");
			} catch (NumberFormatException e) { //2a -> 숫자아님.
				System.out.println("숫자로 변환할 수 없음");
			} finally {
				System.out.println(value);
			}
		}

	}

}
