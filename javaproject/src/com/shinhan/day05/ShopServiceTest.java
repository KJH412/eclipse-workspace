package com.shinhan.day05;

public class ShopServiceTest {

	public static void main(String[] args) {
		//클라이언트는 getInstance() 메서드를 통해 싱글톤 인스턴스를 얻을 수 있다.
		//getInstance() 메서드 내부에는 instance가 null이면 생성하고, null이 아니면 instance를 반환한다.
		//이로써 단 하나만의 객체를 생성하여 사용할 수 있도록 한다.
		
		ShopService obj1 = ShopService.getInstance(); //정적메소드호출하여 싱글톤 객체얻음.
		ShopService obj2 = ShopService.getInstance();
//		ShopService obj3 = new ShopService(); 에러
		
		if(obj1 == obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		}else {
			System.out.println("다른 ShopService 객체입니다.");
		}
	}

}
