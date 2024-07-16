package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Car implements Comparable<Car> { //implements Comparable<Car>추가
	
	String model;
	int price;
	String color;
	
	public void run() {
		System.out.println("자동차가 달립니다.");
	}

	//< = >
	//ASC : 나의값,들어온값 (앞값-뒤값=음수를 앞에 둔다.)
	//값이 같으면 자리이동 없음.
	//DESC : 들어온값, 나의값(양수가 되면 자리를 바꿈. 뒤값을 앞에 둠)
	@Override
	public int compareTo(Car obj) {
		//가격desc, model desc, color asc
		//가격과 이름이 같고 색이 다름
		int result = obj.price - price;
		if(result == 0) {
			int result2 = obj.model.compareTo(model);
			if(result2 == 0) return color.compareTo(obj.color);
			return result2;
		}
		return result;
	}
}
