package day04;

//day04

public class BookTest {

	public static void main(String[] args) {
		method2();
	}

	private static void method2() {
		//Book이 6개 있다.
		Book[] arr = new Book[6];
		
		arr[0] = new Book(); 
		arr[1] = new Book(); 
		arr[2] = new Book("JavaScript", 30000);
		arr[3] = new Book("HTMl,CSS", 20000);
		arr[4] = new Book("SpringFramework");
		arr[5] = new Book(40000);
		
		arr[0].title="이것이 자바다";
		arr[0].price=36000;
		arr[1].title="Oracle";
		arr[1].price=25000;
		
		for(Book b:arr) {
//			System.out.println(b.title);
			b.bookInfoPrint();
		}
	}

	private static void method1() {
		//1.객체참조변수선언
		Book b1=null, b2=null, b3, b4, b5, b6;
		
		//2.객체생성 
		//b1과 b2는 각자 Book클래스의 title,price값을 가진다.
		b1 = new Book(); //기본생성자 호출
		b2 = new Book(); //Book(String어쩌구){}이러면 안불러와짐. 클래스Book(){}과 형태가 같아야함.
		b3 = new Book("JavaScript", 30000);
		b4 = new Book("HTMl,CSS", 20000);
		b5 = new Book("SpringFramework");
		b6 = new Book(40000);
		
		//3.객체사용
		b1.title="이것이 자바다";
		b1.price=36000;
		b2.title="Oracle";
		b2.price=25000;
		
		
		//같은함수를 많이씀..배열에 넣기
		b1.bookInfoPrint();
		b2.bookInfoPrint();
		b3.bookInfoPrint();
		b4.bookInfoPrint();
		b5.bookInfoPrint();
		b6.bookInfoPrint();
		/*
		System.out.println(b1.title+":"+b1.price);
		System.out.println(b2.title+":"+b2.price);
		System.out.println(b3.title+":"+b3.price);
		System.out.println(b4.title+":"+b4.price);
		System.out.println(b5.title+":"+b5.price);
		System.out.println(b6.title+":"+b6.price);
		*/
	}
	

}
