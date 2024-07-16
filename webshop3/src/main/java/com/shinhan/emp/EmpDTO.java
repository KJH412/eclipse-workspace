package com.shinhan.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
//칼럼이름은 복사해 오는게 정확하고 소문자로 바꿔준다. 
//롬복사용 - 빌드패스에 추가한다.

//=VO(Value Object) 데이터를 담아서 전송하는게 목적.
//DTO(Data Transfer Object)
//JavaBeans 기술에서 이용(Jsp, Spring, Mybatis는 자바빈즈기술을 이용한다.)

@AllArgsConstructor
@NoArgsConstructor //자바빈즈는 기본 생성자 필수
@Getter@Setter@ToString
public class EmpDTO {
	 private int employee_id;                               
	 private String first_name;                                         
	 private String last_name;                                
	 private String email;                                  
	 private String phone_number;                                    
	 private Date hire_date;                                
	 private String job_id;                                 
	 private int salary;                                         
	 private double commission_pct;                                  
	 private int manager_id;                                       
	 private int department_id;
}
