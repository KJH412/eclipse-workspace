package com.shinhan.day07.lab3;

public interface Machine {
	
	void powerOn(String title); //문자가 들어가고 리턴은 없다.
}

//1.interface 구현class를 만든다... 만약 만들어야하는 경우가 많다면 좋은 방법이 아니다.
//2.익명구현class를 만든다. ...필요시마다 만들고 제거된다.
//3.interface내에 메서드가 하나밖에 없다면 람다표현식을 이용한다. <----예제