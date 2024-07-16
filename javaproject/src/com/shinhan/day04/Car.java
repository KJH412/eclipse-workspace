package day04;

public class Car {
	
	//1.feild(특징, 변수, data저장, 멤버변수)
	//접근지정자가(Modifier) private인 경우 외부에서 접근불가능하다.
	//접근하고자 한다면 기능이 추가되어야한다.
	//읽기기능 : getter
	//쓰기기능 : setter
	//JavaBeans기술의 규칙:setCompany,getCompany -> set/get+대문자
	private String company="현대자동차";
	private String model;
	private String color;
	private int maxSpeed;
	
	public void setCompany(String company){
		this.company = company;
	}
	public String getCompany() {
		return company;
	}
	
	
	//2.constructor(생성자)...생성하는 여러가지 방법을 정의(Overloading)
	Car(){
		System.out.println("default생성자...arg없음");
	}
	Car(String model, String color, int maxSpeed){ //argument속 변수 순서 바꾸지 x..
		//super(); 부모생성된다.
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	Car(String color, int maxSpeed, String model){
		this(model, color, maxSpeed); //생성자를 호출. Car(String model, String color, int maxSpeed){...}
		//생성자 호출 첫번째 줄에서만 가능. super()부분이 수행안함.
	}
	Car(String color, int maxSpeed){
		this(null,color,maxSpeed);
	}
	Car(String model){
		this(model,null,0);
	}
	
	//멤버변수 (new하면 자동으로 초기화 됨.)
	String first;
	
	//3.메서드(기능,동작,문장들의 묶음), return type이 반드시 필요, retrun값이 없으면 void
	//??
	String carInfoPrint(String title){
		//지역변수 (지역변수는 반드시 초기화하고 사용.)
		String second = null;
		
		System.out.println("========Car의 정보========");
		System.out.println("company:"+ company);
		System.out.println("모델:"+ model);
		System.out.println("color:"+ color);
		System.out.println("maxSpeed"+ maxSpeed);
		System.out.println("first:"+ first);
		System.out.println("second:"+ second);
		powerOn(); // 내부에서 호출
		
		return "###########";
	}
	
	void powerOn() {
		System.out.println("====== powerOn ======");
	}
	
	//마우스 우클릭>Source>General Getter and Setter>클릭하면 만들어줌.
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	
	
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed
				+ ", first=" + first + "]";
	}

	
}
