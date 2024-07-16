package com.shinhan.day09.lab;


public class Member {
	private String id;
	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	// 여기에 코드를 작성하세요.
	//toString을 builder나 bffer로 로드해서 원하는 데이터만 남기고 지워주면 된다.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id);
		builder.append(": ");
		builder.append(name);
		return builder.toString();
	}
}

/* 롬복
	@
	@
	public class Member {
		private String id;
		private String name;

	}
*/