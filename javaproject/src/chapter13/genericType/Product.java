package chapter13.genericType;

public class Product<K, M> { //파라미터<>로 K,M 정의
	//필드 (타입 파라미터를 필드타입으로 사용)
	private K kind;
	private M model;
	
	//타입파라미터<>를 사용하는 이유는? Product에 다양한 종류와 모델제품을 저장하기 위해서이다.!!!!
	
	//private 필드에 접근하기 위해서는 getter/setter를 이용한다.
	public K getKind() { //메소드()앞에 위치한 파라미터로 정의된 K가 메소드의 타입이다
		return kind;
	}
	public void setKind(K kind) { //setKind는 K타입의 매개변수(kind)다.
		this.kind = kind;
	}
	public M getModel() {
		return model;
	}
	public void setModel(M model) {
		this.model = model;
	}
	
}
