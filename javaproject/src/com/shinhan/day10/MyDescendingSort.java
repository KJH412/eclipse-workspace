package com.shinhan.day10;

import java.util.Comparator;

public class MyDescendingSort implements Comparator<Integer> {//구현클래스

	@Override
	public int compare(Integer o1, Integer o2) {
		//앞-뒤 (ASC어선딩) 뒤-앞(DESC디센딩)
		return o2 - o1;
	}
	
	
/*  오브젝트로오면 형변환해서 비교해야해서 제네릭 써줘야함.
	@Override
	public int compare(Object o1, Object o2)
		// TODO Auto-generated method stub
		return 0;
	}
*/
}
