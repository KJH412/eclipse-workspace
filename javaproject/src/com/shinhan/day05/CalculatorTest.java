package com.shinhan.day05;

public class CalculatorTest {

	public static void main(String[] args) {
		System.out.println(Calculator.company);
		System.out.println(Calculator.company2);
		System.out.println(Calculator.plus(1,2)); 
		//System.out.println(Calculator.minus(1,2)); //객체생성안해서 사용불가.
		
		/*
		 * Calculator c = new Calculator();
		 * c.minus(1,2);
		 * */
		double result = new Calculator().minus(1,2); //new하고 리턴값을바로붙여도됨.
		System.out.println(result);
	}

}
