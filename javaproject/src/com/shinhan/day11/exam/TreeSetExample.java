package com.shinhan.day11.exam;

import java.util.TreeSet;

class StudentTree implements Comparable<StudentTree> {
	public String id;
	public int score;

	public StudentTree(String id, int score) {
		this.id = id;
		this.score = score;
	}

	@Override
	public int compareTo(StudentTree obj) {
		
		return score - obj.score;
	}
	
}

public class TreeSetExample {
	public static void main(String[] args) {
		TreeSet<StudentTree> treeSet = new TreeSet<StudentTree>();
		treeSet.add(new StudentTree("blue", 96));
		treeSet.add(new StudentTree("hong", 86));
		treeSet.add(new StudentTree("white", 92));

		StudentTree student = treeSet.last();
		System.out.println("최고 점수: " + student.score);
		System.out.println("최고 점수를 받은 아이디: " + student.id);
	}
}
