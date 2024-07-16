package com.shinhan.day06.lab;
/*
<< 출력 결과 >>
a는 A의 인스턴스 이다.
a는 B의 인스턴스 이다.
a는 C의 인스턴스 이다.
100  100   100  1  10   100
*/

//A가 부모다.   상속: C(자식)->B(자식)->A(부모) 또는 C->A->B  !!부모는 두개가될 수 없음.
class C extends B{ 
    int meth()  { return 100; } 
    static int sMeth() { return 100; } 
} 
class B extends A { 
    int meth()  { return 10; } 
    static int sMeth() { return 10; } 
} 
class A { 
    int meth()  { return 1; } 
    static int sMeth() { return 1; } 
}
public class Inheritance {

	public static void main(String[] args) {
		        C c = new C(); //객체생성은 C, 자식 생성시 부모도 생성. 부모는 자식을 담을 수 있다.
		        B b = c; //(B) c; 
		        A a = c; //(A) c; 
		        
		        
		        //부모 객체는 어떤자식탑으로도 강제 타입 변환된다.X
		        //부모 객체는 본래만들어진 instance에 타입으로만 강제 타입 변환된다.O 
		        B var1= new C();
		        C var2 = (C)var1;
		        //오류 D var3 = (D)var1;
		        
		        //자동형변환
		        /* 
		        B var4= new D();
		        D var5 = (D)var4;
		        //실행오류C var6 = (C)var4;
		        */
		        
		        if( a instanceof A ) {
		            System.out.println( "a 는 A 의 인스턴스 이다.");
		        }        
		        if( a instanceof B) { 
		            System.out.println( "a 는 B 의 인스턴스 이다.");
		        }
		        if( a instanceof C) {
		            System.out.println( "a 는 C 의 인스턴스 이다.");
		        }
		        
		        System.out.println(a.meth() + " " + b.meth() + " "+ c.meth()+ " " 
		        + a.sMeth() + " " + b.sMeth() + " " + c.sMeth() );  //밑줄쳐진이유? sMeth가 static이여서
		      
		        //권장
		        System.out.println(A.sMeth()); 
		        System.out.println(B.sMeth());
		        System.out.println( C.sMeth());
		 
	}

}
