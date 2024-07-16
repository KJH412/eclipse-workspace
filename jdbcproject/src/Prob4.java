import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class Prob4 {

	public static void main(String[] args) {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP") };
		
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
		
	}

	
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		//구현하시오...return값 수정하기 
		//stream도 가능.
		HashSet<Product> datas = new HashSet<Product>();
		System.out.println("특정 금액 이상의 상품 결과입니다.********");
		for(Product p:prodList) {
			if(p.getPrice() >= price) {
				datas.add(p);
				System.out.println(p);
			}
		}
		return datas;
	}


	private static void makeFile(HashSet<Product> product_hs)  {//파일에저장
		//구현하시오. (던지란 말이 없기 때문에 try-catch)
		try {
			FileOutputStream fos = new FileOutputStream("prob.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			for(Product p:product_hs) {
				oos.writeObject(p);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private static void readFile()  {
		//구현하시오. 
		System.out.println("readFile입니다.********");
		try (FileInputStream fis = new FileInputStream("prob.txt");){ //try가끝나면 자동으로 닫힘.
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			while(true) {
			Object obj = ois.readObject();
			if(obj == null) break;
			Product p= (Product) obj;
			System.out.println(p);
			}
			
//			ois.close();
//			fis.close();
			
		}catch (EOFException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { //fis,ois예외. 한번에 처리해도 됨.
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}


class Product implements Serializable{ 
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	

}