package com.shinhan.frontpattern;

import java.util.Map;

//인터페이스 - 나머진 Class로 구현
public interface CommonControllerInterface {
	
	//여러정보를 보낼 때 Map키(문자열)-값은 다양하므로(오브젝트)으로 보낸다.
	String execute(Map<String,Object> dataMap);
	
	
	
}
