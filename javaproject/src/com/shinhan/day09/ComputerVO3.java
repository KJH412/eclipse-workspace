package com.shinhan.day09;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//class : 틀(template), object를 만들기 위해 사용
//object : instance(실체)

//VO(Value Object) : 데이터(data)를 저장한다. (field가 여러개), C언어의 스트럭처 비슷
//DTO(Data Transfer Object):data전송목적.
//JavaBeans기술 : default생성자가 반드시 있어야한다. 

//@NoArgsConstructor //기본생성자
//@AllArgsConstructor //아규먼트 전부 있는 생성자
//@ToString 
//@EqualsAndHashCode
//@Getter@Setter

@AllArgsConstructor
@Data //위에 것 다 만들어줌. But..deafault생성자만 만들어줘서 all argument생성자는 추가
public class ComputerVO3 {
	//1.field (data저장)
	
	@NonNull //Null주면 안돼 (필드에 선언된 데이터 model를 안주면 못만든다는 뜻)
	String model;
	
	//@NonNul String model; 한줄로 써도 됨
	
	int price; 
	String company;
	

}
