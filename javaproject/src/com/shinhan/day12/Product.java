package com.shinhan.day12;

import java.io.Serializable;

public class Product implements Comparable<Product>, Serializable{ //implements Comparable<Product>,Serializable:직렬화(day13)
	private int pno;
	private String name;
	private String company;
	private int price;
	
	public Product(int pno, String name, String company, int price) {
		this.pno = pno;
		this.name = name;
		this.company = company;
		this.price = price;
	}

	public int getPno() { return pno; }
	public String getName() { return name; }
	public String getCompany() { return company; }
	public int getPrice() { return price; }
	
	@Override
	public String toString() {
		return new StringBuilder()
				.append("{")
				.append("pno:" + pno + ", ")
				.append("name:" + name + ", ")
				.append("company:" + company + ", ")
				.append("price:" + price)
				.append("}")
				.toString();
	}

	//어떻게 비교할 건지 기준 정한다.
	@Override
	public int compareTo(Product obj) {
		//1)상품가격으로 sort>desc, 2)상품이름 asc, 3)상품id desc
		int a = obj.price - price; //뒤에것(값) - 앞의것
		if(a==0) { //<--가격이다 같다면 상품이름으로 어센딩(오름차순)
			int b = name.compareTo(obj.name);
			if(b==0) return obj.pno - pno; 
			return b;
		}
		return a;
	}
}






