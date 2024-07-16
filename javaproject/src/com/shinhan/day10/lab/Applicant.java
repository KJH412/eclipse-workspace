package com.shinhan.day10.lab;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Applicant<T> {
	public T kind; 
	//T타입에 Student,Worker,Person...여러 타입이 올 수 있다.
	
//	public Applicant(T kind) {
//		this.kind = kind;
//	}
}
