package com.shinhan.day10;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//상속
@Getter@Setter
@NoArgsConstructor
public class ChildProduct<K, V, P> extends Product<K, V> {
	P price;
	//변수가 1개뿐

	//아규먼트 3개짜리 생성자 만들기
	public ChildProduct(K kind, V model, P price) {
		super(kind, model);
		this.price = price;
	}

	//toString으로 문자열 만들기
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("model: ").append(getModel())
		.append("\nkind:").append(getKind())
		.append("\nprice:").append(price).append("\n------------");
		
		return builder.toString();
	}
	
	

	
}
