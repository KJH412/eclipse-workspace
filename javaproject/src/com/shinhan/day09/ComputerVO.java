package com.shinhan.day09;

import java.util.Objects;

//class : 틀(template), object를 만들기 위해 사용
//object : instance(실체)

//VO(Value Object) : 데이터(data)를 저장한다. (field가 여러개), C언어의 스트럭처 비슷
//DTO(Data Transfer Object):data전송목적.
//JavaBeans기술 : default생성자가 반드시 있어야한다. 
public class ComputerVO {
	//1.field (data저장)
	String model;
	int price; //접근지정자(public)가 안정해져있으면 다른패키지?에서 못씀. -> 게터세터가필요.
	String company;
	
	public ComputerVO(){}; //필수
	public ComputerVO(String model, int price, String company) { //필요하면 함. 값을 넣어 줄 떄
		this.model = model;
		this.price = price;
		this.company = company;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	//toString 재정의 
	//PC에서는 괜찮은데 모바일에서는 안좋은 코드다.
	/*
	@Override
	public String toString() { 
		return "ComputerVO!! [model=" + model + ", price=" + price + ", company=" + company + "]";
	}
	*/
	
	
	//toString 재정의 Builder (StringBuilder는 내부 버퍼에 문자열을 저장해두고 그 안에서 추가,수정,삭제 작업)
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComputerVO [model=");
		builder.append(model);
		builder.append(", price=");
		builder.append(price);
		builder.append(", company=");
		builder.append(company);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(company, model, price);
	}
	

	//equals 재정의
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComputerVO other = (ComputerVO) obj;
		return Objects.equals(company, other.company) && Objects.equals(model, other.model) && price == other.price;
	}
	
	
	

}
