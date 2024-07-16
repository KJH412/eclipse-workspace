package chapter12;

import java.util.Objects;

//오브젝트의 이퀄스와 해시코드메소드 오버라이딩해서 학번이 같으면 동등객체가 될 수 있도록
//해시코드()메소드의 리턴값은 studentNum필드값으로 설정
public class Student {
	private String studentNum;

	public Student(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentNum() {
		return studentNum;
	}
	
	// 여기에 코드를 작성하세요
	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}

//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Student) {
//			Student student = (Student) obj;
//		}
//		
//	}
	
}
