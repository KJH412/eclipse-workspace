package com.firstzone.pack2;


public class Car {
	String model;
	int price; //다른패키지에서 접근이 안될때 getter,setter사용
	
	public Car() {
	}
	
	public Car(String model, int price) {
		this.model = model;
		this.price = price;
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
	
	
}

