package chapter18;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharConvertStreamExample {
	//write메소드로 분리
	public static void write(String str) throws IOException {
		OutputStream os = new FileOutputStream("C:/eclipse-workspace/javaproject/test2.txt");
		Writer writer = new OutputStreamWriter(os,"UTF-8");
		writer.write(str); 
		writer.flush();
		writer.close();
	}
	//read메소드로 분리
	public static String read() throws IOException {
		/* 이것도 char배열이 깔끔하지가 않다.
		InputStream is = new FileInputStream("C:/eclipse-workspace/javaproject/test2.txt");
		Reader reader = new InputStreamReader(is,"UTF-8");
		char[] data = new char[20]; //문자수 20자 읽어들임.
		int num = reader.read(data); //실제 문자 수 
		reader.close();
		String str = new String(data, 0,  num); //0~num까지 문자수 읽겠다.
		return str;
		*/
		
		//BufferedReader 보조스트림 또 연결.
		InputStream is = new FileInputStream("C:/eclipse-workspace/javaproject/test2.txt");
		Reader reader = new InputStreamReader(is,"UTF-8");
		BufferedReader br = new BufferedReader(reader);
		String str = br.readLine(); //0~num까지 문자수 읽겠다.
		return str;
	}
	public static void main(String[] args) {

		try {
			write("문자 변환 스트림을 사용한다.");
			String str = read();
			System.out.println(str);
			
			/* 1. 문자쓰기(바이트>문자열)
			//바이트 기반
			OutputStream os = new FileOutputStream("C:/eclipse-workspace/javaproject/test2.txt");
			//바이트기반 -> 문자열기반 , 보조스트림:OutputStreamWriter
			Writer writer = new OutputStreamWriter(os,"UTF-8");
			String str = "문자 변환 스트림을 사용한다.";
			*/
			
			/* 가독성 BAD , str을 바로 출력해보자. 보조스트림 이용! */
//			byte[] data = str.getBytes("UTF-8"); //이 문자열을 utf-8을 이용해서 인코딩하겠다.(한글 한 자는 3바이트)
			
			//os가 아니라 writer로 바꿔준다. 보조스트림 사용!
			//writer.write(str); //->메소드가 바이트배열을 원한다.
			
			//writer.flush();
			//writer.close();
			
			
			/* 2. 문자읽기(문자>문자열)
			InputStream is = new FileInputStream("C:/eclipse-workspace/javaproject/test2.txt");
			Reader reader = new InputStreamReader(is,"UTF-8");
			char[] data = new char[20]; //문자수 20자 읽어들임.
			int num = reader.read(data); //실제 문자 수 
			String str2 = new String(data, 0,  num); //0~num까지 문자수 읽겠다.
			System.out.println(str2);
			*/
			
			/* 가독성 BAD
			byte[] data = new byte[100]; //str문자 읽을 수 있게 넉넉하게 100주었음.
			int num = is.read(data); //여기서 read는 100바이트를 읽는다.
			//바이트배열->스트링만들 때 생성자를 이용한다.
			String str2 = new String(data, "UTF-8");
			System.out.println(str2);
			*/
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
