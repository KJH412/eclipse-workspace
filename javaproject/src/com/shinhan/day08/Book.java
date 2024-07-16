package com.shinhan.day08;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JavaBeans 기술 규격 : field는 private, getter/setter, default생성자
//DTO(Data Transfer Object) : data를 전송하기 위해  
//VO(Value Object) : 값을 저장하기 위해 만듦. (업무로직이 아님)

//롬복
/*@ToString(exclude = "price") price만 빼고 출력됨 (배제) */ 
//@EqualsAndHashCode(of = {"title","author"}) 두개를 갖고있다면 같다. (포함)
//@EqualsAndHashCode(exclude = {"price"})  //---> 롬복으로 설정해뒀으면 우클릭 Source>hashCode and equals 자동완성 안됌! 롬복으로 해두면 내용을 굳이 추가안해도됨.
@ToString 
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	private String title;
	private int price;
	private String autor;
	
	public void Book() {
		System.out.println("com.shinhan.day08패키지에 있는 Book");
	}
	
	

	//자동으로 만들기. 우클릭>Source>해시코드 and equals...
	
	
	@Override
	public int hashCode() {
		return Objects.hash(autor, price, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj; //형변환
		return Objects.equals(autor, other.autor) && price == other.price && Objects.equals(title, other.title);
	}
	
	
	
	// 직접 생성
//	@Override
//	public int hashCode() {
//		return title.hashCode(); // title이 같으면 hashCode도 같음
//	}
	
	
	/* 직접작성
	@Override
	public boolean equals(Object obj) {   // obj에는 equals가 내용 비교가 아니므로 상속 받았을때 재정의 하지 않으면 주소 비교 그대로 사용
		if(obj instanceof Book) {
			Book book = (Book)obj;
			
			// Object는 최상위 이므로 아무거나 들어올 수 있기 때문에 조건 부여
			if(title.equals(book.title) && autor.equals(book.autor)) { //문자열같은지비교는.equals
				return true;
			}else {
				return false; 
			}
		}else {
			return false; //obj가 Book일때만 한다.
		}
	}
	*/
	
	
	
}
