package day04.lab4;

public class Book {
	private String title;
	private int price;
	
	Book(String title, int price){
		this.title = title;
		this.price = price;
	}
	
	
	//마우스우클릭>Source>General Constructor... 생성자 만들어줌.
	/* 
	 public Book(String title, int price) {
		super(); //super()가 자동으로 생성됨.
		this.title = title;
		this.price = price;
	}
	*/

	//getter,setter
	public void setTtile(String title) { //외부에서 접근 가능하도록 public.
		this.title = title;
	}
	public String getTitle() {  //return이 있어서 void 없음.
		return title;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}

	//source > General toString..
	@Override
	public String toString() {
		return "Book정보 [title=" + title + ", price=" + price + "]";
	}
	
}
