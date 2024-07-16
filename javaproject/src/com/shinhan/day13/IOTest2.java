package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.day12.Product;
import com.shinhan.day12.Student;

public class IOTest2 {
	static String path = "src/com/shinhan/day13/"; //필드에 저장해서 계속 사용. static
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		f5();
	}

	private static void f5() {
		File f = new File(path +"Review.java");
		System.out.println(f.exists()); 
		System.out.println(f.length()); //byte개수로 나온다.
		System.out.println(f.getAbsolutePath()); 
		System.out.println(f.isDirectory()); 
	}

	private static void f4() throws IOException, ClassNotFoundException {
		Student st1 = new Student("홍길동1",100, "남자");
		Student st2 = new Student("홍길동2",100, "남자");
		Product	p = new Product(1,"TV","S", 100);
		FileOutputStream fos = new FileOutputStream(path + "data.dat");//파일이름 확장자맘대로
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(st1);
		oos.writeObject(st2);
		oos.writeObject(p);
		
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(path + "data.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student st3 =(Student)ois.readObject();
		Student st4 =(Student)ois.readObject();
		Product p2 = (Product)ois.readObject();
		
		System.out.println(st3);
		System.out.println(st4);
		System.out.println(p2);
		ois.close();
		fis.close();
		
	}

	private static void f3() {
		try {
			new IOTest2().reverseLine(path + "data4.txt", path + "data5.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void reverseLine(String inputFileName, String outputFileName) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader(inputFileName));
		BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName));
		List<String> datas = new ArrayList<String>(); //몇번인지 알 수 없어서 배열아니고 List에 담음.
		String s = null;
		while((s=br.readLine()) != null){
			datas.add(s);
		}
		for(int i=datas.size()-1; i>=0; i--) { //뒤에서부터 읽기
			bw.write(datas.get(i));
			bw.newLine(); //다음라인으로 이동
		}
		br.close();
		bw.close();
	}
	
	private static void f2() {
		
		new IOTest2().printScore(path+"data3.txt");	
	}
	private static void printScore(String fileName) {
		
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			
			String line;
			line = br.readLine();
			System.out.println(line.replaceAll("/", "\t") + "\t총점"); 
			while((line = br.readLine())!= null){
				
				String[] arr = line.split("/");
				int total = 0;
				for(int i=1; i<arr.length; i++) {
					total += Integer.parseInt(arr[i]);
				}
				System.out.println(line.replace("/", "\t") + "\t" + total);
			}
			
			
		}catch(FileNotFoundException e	) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	private static void f1() {
		//String path = "src/com/shinhan/day13/";
		try {
			ArrayList<String> datas = new IOTest2().compareFile(path+"data1.txt", path+"data2.txt");
			datas.stream().forEach(data->System.out.println(data));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//static이 아닌함수는 객체생성해야함.
	ArrayList<String> compareFile(String fstFileName, String scdFileName) throws Exception{
		ArrayList<String> result = new ArrayList<String>();
//		FileReader fr1 = new FileReader(fstFileName);
//		FileReader fr2 = new FileReader(scdFileName);
		BufferedReader br1 = new BufferedReader(new FileReader(fstFileName));
		BufferedReader br2 = new BufferedReader(new FileReader(scdFileName));
		LineNumberReader lineReader = new LineNumberReader(br2); //라인 찾기
		String s1, s2;
		while((s1 = br1.readLine())!=null){
			s2 = lineReader.readLine();
			if(!(s1.equals(s2))) {
				result.add("Line"+ lineReader.getLineNumber() +":" +s2);
			}
		}
		//닫을 때 자바에서 가까운것 부터
		br1.close();
//		fr1.close();
		br2.close();
//		fr2.close();
		
		
		return result;
	}

}
