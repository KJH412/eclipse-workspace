package chapter18;

import java.io.FileReader;
import java.io.Reader;

/* 문자읽기 
 * 
 * Reader : 출력단위가 문자(char)이다.
 * 문자를 하나씩 읽거나 문자 배열로 읽는 방법을 보여준다.
 * 
 */
public class ReadExample {
	public static void main(String[] args) {
		try {
			Reader reader = null;
			
			//1.문자씩 읽기
			System.out.println("1.문자씩 읽기"); //이전 예제에서 만든 파일을 읽어보기.
			reader = new FileReader("C:/eclipse-workspace/javaproject/test.txt");
			while(true) {
				int data = reader.read(); //문자 읽음
				if(data == -1) break; //다 읽으면 while문 종료
				System.out.print((char)data); //출력
			}
			reader.close();
			
			
			//2.문자 배열로 읽기
			System.out.println("\n2.문자 배열로 읽기");
			reader = new FileReader("C:/eclipse-workspace/javaproject/test.txt");
			char[] data = new char[100]; //읽은문자 저장할 배열
			while(true) {
				int num = reader.read(data);//읽은문자 배열에 저장, 읽은 문자수는 리턴
				if(num==-1) break;//다 읽으면 while문 종료 (100이 아니라 num인걸 주의)
				for(int i=0; i<num; i++) { //읽은 문자 수 만큼 출력
					System.out.print(data[i]);
				}
			}
			reader.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	
	}

}
