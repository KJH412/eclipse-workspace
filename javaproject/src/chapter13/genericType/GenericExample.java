package chapter13.genericType;

public class GenericExample {

	public static void main(String[] args) {
		//K는 TV로 대체, M은 String으로 대체
		Product<TV,String> product1 = new Product<TV, String>();
		
		//Setter매개값은 반드시 TV와 String을 제공
		product1.setKind(new TV()); //TV객체만 대입되어야 한다. 왜? setKind(K kind)가 K타입 매개변수라서 TV타입으로 대체됨
		product1.setModel("스마트TV"); //setModel(M model)은 String타입
		
		//Getter리턴값은 TV와 String이 됨.
		TV tv = product1.getKind();
		String tvModel = product1.getModel();
		
		//--------------------------------------------------------------
		
		//K는 Car로 대체, M은 String으로 대체
		Product<Car, String> product2 = new Product<Car, String>();
		
		//Setter매개값은 반드시 Car와 String을 제공
		product2.setKind(new Car());
		product2.setModel("SUV자동차");
		
		//Getter리턴값은 Car와 String이 됨.
		Car car = product2.getKind();
		String carModel = product2.getModel();
		
		System.out.println(car);
		System.out.println(carModel);
	}

}
