package com.shinhan.day12;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable<Student>, Serializable { //implements Comparable<Student> :TreeSet()사용
	private String name;
	private int score;
	private String gender;
	
	public Student(String name, int score, String gender) {
		this.name = name;
		this.score = score;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Student (String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() { return name; }
	public int getScore() { return score; }
	
	

	@Override
	public int hashCode() {
		return Objects.hash(gender, name, score);
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
		return Objects.equals(gender, other.gender) && Objects.equals(name, other.name) && score == other.score;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=").append(name).append(", score=").append(score).append(", gender=")
				.append(gender).append("]");
		return builder.toString();
	}

	//hashCode(), equals()
//	@Override
//	public int hashCode() {
//		return Objects.hash(name, score);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		return Objects.equals(name, other.name) && score == other.score;
//	}
//
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Student [name=");
//		builder.append(name);
//		builder.append(", score=");
//		builder.append(score);
//		builder.append("]");
//		return builder.toString();
//	}

	//compareTo : 비교하고 싶은 내용 작성.
	@Override
	public int compareTo(Student obj) {
		//score asc(앞에것-작은것) 어센딩
		if(score == obj.score) return obj.name.compareTo(name); //문자라서 "-" 안돼고, compareTo()사용
		return score - obj.score;
	}
	
	
}