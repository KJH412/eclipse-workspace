package com.shinhan.lab.lab8;
//Resizable 인터페이스를 작성하고, Rectangle 클래스가 implement 하도록 하십시오. 
//resize 메쏘드는 double type의 argument 하나를 받아서, 
//기존 width와 height를 해당 인자를 곱한 값으로 변경합니다
public interface Resizable {
	
	public abstract void resize(double s);
}
