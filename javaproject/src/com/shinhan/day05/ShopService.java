package com.shinhan.day05;

//18번 싱글톤 패턴 사용.
public class ShopService {
//	private static ShopService shop; //shop선언. private로 외부접근막음.
//	
//	//생성자의 접근 지정자를 private
//	private ShopService() { //싱글톤
//	
//	}
//	public static ShopService getInstance() { //static이니까 shop도 static
//		if(shop==null) {
//			shop = new ShopService();
//		}
//		return shop;
//	}
	
	private static ShopService shop;
	private ShopService() {
		
	}
	public static ShopService getInstance() {
		if(shop==null) {
			shop = new ShopService();
		}
		return shop;
	}
	
	
}
