package day04;

public class NoteBook {
	
	//1.field : object 마다 다른 객체와 구별되는 값을 저장하기 위함.
	//field 구분: none-static(instance변수)->반드시 생성후 사용가능, 
	//			static(class변수, 공유변수) -> 객체 생성과 무관하다.
	private String model;
	private int price;
	
	// satatic 공유영역에 count가 있어야한다.
	static int count;
	
	//2.constructor : 값 초기화
	public NoteBook(String model, int price) {
		this.model = model;
		this.price = price;
		count++; //new 생성할 때마다 증가
	}

	//3.일반메서드
	//3.getter(얻기)/setter(변경)
	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NoteBook [model=" + model + ", price=" + price + "]";
	}
	
	
}
