package com.shinhan.day09.lab;

import java.util.Objects;
//기본 형식 
//알아야 롬복,record도 사용한다.
public class Student {
	private String studentNum;

	public Student(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentNum() {
		return studentNum;
	}

	// 여기에 코드를 작성하세요.
	@Override
	public int hashCode() { //해시코드를 받아서 재정의 해야 각 번호를 알 수 있음.
		return Objects.hash(studentNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studentNum, other.studentNum);
	}


}