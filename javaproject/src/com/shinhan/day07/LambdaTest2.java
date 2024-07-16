package com.shinhan.day07;

//람다표현식 가능한지 컴파일 타임에 체크하기.
//추상메서드가 반드시 1개만 가능하다

//매개변수가 있고 리턴없는 경우
@FunctionalInterface
interface Calculable{
	public abstract void calculate(int x, int y); //void 리턴x
}
//리턴있는경우
@FunctionalInterface
interface Calculable2{
	public abstract int calculate(int x, int y);  //int 리턴있음
}

public class LambdaTest2 {

	public static void main(String[] args) {
		call2(new Calculable2() {//익명구현객체
			
			@Override
			public int calculate(int x, int y) {
				// TODO Auto-generated method stub
				return x+y;
			}
		});
		
		call2((x,y) -> x-y);
		call2((x,y) -> {
		System.out.println("문장이 여러개이면 {}로 묶는다. return있으면 반드시 return");
			return x-y;
		});
		
		call2((left, right) -> left>right? left:right); //삼항연산자도 가능.
		call2((left, right) -> Math.max(left, right));

		//static method를 사용하는 경우
		call2(Math::max); //<--더 간단히 쓸 수 있다. ::메소드이름
		
		//instance method를 사용하는경우
		
	
	}
	
	
	private static void call2(Calculable2 cal) { //기능이 cal에 들어옴.
		int result = cal.calculate(10, 6);
		System.out.println(result);
		
	}


	public static void f(String[] args) {
		call(new Calculable(){
			public void calculate(int x, int y) {
				System.out.println("익명구현class x+y= " + (x+y));
			}
		});
		call((int x, int y) -> System.out.println("람다식 x+y= " + (x+y))); 
		call((int a, int b) -> {
			System.out.println("---------------------"); 
			System.out.println("람다식 x+y= " + (a*b));  //내가 변수 정함.
			System.out.println("---------------------"); 
		});
	}

	private static void call(Calculable cal) {
		cal.calculate(1, 2);
		
	}

}
