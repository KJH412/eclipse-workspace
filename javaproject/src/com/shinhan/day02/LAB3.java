package com.shinhan.day02;


public class LAB3 {

	public static void main(String[] args) {
		gcd(2, 5);
		gcd(5,15);
		gcd(250,30);

	}

	private static void gcd(int su1, int su2) {
		 //int su3 = su1>su2?su2:su1;
		int su3 = Math.min(su1, su2);
		
		int result = 1;
		for(int i=su3;i>1;i--) {
			if(su1%i==0 && su2%i==0) {
				result = i; break;
			}
		}
		System.out.println(result);
		
		
	}

}
/*
 * 최대 공약수는 두 숫자를 공통된 숫자로 나누어도 나머지가 0이 되는 가장 큰 수를 의미합니다. 예를 들어 2와 5의 최대 공약수는 1입니다. 왜냐하면, 1부터 2까지의 숫자중 공통으로 나눌 수 있는 숫자는 1 뿐이기 때문입니다. 다른 예로, 5와 15의 최대 공약수는 5가 됩니다. 메소드의 이름은 gcd로 하며, 매개변수는 두개의 정수를 받으며, 리턴 하는 타입 역시 정수입니다.

[입력값]
2, 5
5,15
250,30

[실행결과]
1
5
10

 */