package com.firstzone.pack1;

//JavaBeans 기술 규격 : field는 private, getter/setter, default생성자
//DTO(Data Transfer Object) : data를 전송하기 위해  
//VO(Value Object) : 값을 저장하기 위해 만듦. (업무로직이 아님)

//JavaBeans 기술 규격 : field는 private, getter/setter, default생성자
//DTO(Data Transfer Object) : data를 전송하기 위해  
//VO(Value Object) : 값을 저장하기 위해 만듦. (업무로직이 아님)
public class Book {
	
	String title;
	int price;
	String autor;
	
	public Book() {
		
	}
	public Book(String title, int price, String autor) {
		this.title = title;
		this.price = price;
		this.autor = autor;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", autor=" + autor + "]";
	}
	
	
	
}
