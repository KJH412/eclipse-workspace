package com.shinhan.day12;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) throws URISyntaxException, IOException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
		f7();
	}
	//파일로 부터 스트림얻기
	private static void f7() throws URISyntaxException, IOException {
		//나를 기준으로 파일 읽기. toURI가 URI타입임.
		//getResource()를 안쓴다면 src/com/../모드경로를 써줘야함.
		URI uri = StreamTest.class.getResource("data.txt").toURI(); 
		Path path = Paths.get(uri); //path얻기.
		
		//Stream: Files.lines(path) : path를 Stream으로
		Files.lines(path).forEach(line->{
			System.out.println(line);
		});
	}
	private static void f6() {
		//range,rangeClosed 뒤의값?데이터가 차이가 있는지 보기
		IntStream.range(1, 6).forEach(i->System.out.println(i));
		System.out.println("----------------------");
		IntStream.rangeClosed(1, 6).forEach(i->System.out.println(i));
		
	}
	private static void f5() {
		String[] arr = {"홍길동","심은정","정민교"};
		int[] scores = {100,99,88,77};
		Arrays.stream(arr).forEach(name->System.out.println(name));
		double result = Arrays.stream(scores).average().getAsDouble();
		System.out.println(result);
	}
	private static void f4() {
		List<Product> list = new ArrayList<Product>();
		//1<= <6  range():for와 같은 동작
		IntStream.range(1, 6).forEach(i -> {
			Product p = new Product(i, "상품"+i, "멋진회사", (int)(Math.random()*10000));
			list.add(p);
		});
		//내부반복자 이용하여 출력
		list.stream().forEach(p->System.out.println(p));
		//내부반복자 이용하여 가격합계구하기
		int total = list.stream().mapToInt(p -> p.getPrice()).sum();
		System.out.println(total);
		
	}
	private static void f3() {
		List<Student> data = new ArrayList<Student>();
		data.add(new Student("A", 100));
		data.add(new Student("C", 400));
		data.add(new Student("A", 100));
		data.add(new Student("D", 200));
		data.add(new Student("B", 100));
		
		//mapToInt(): super Student임. 
		//map: 변형하다
		double avg = data.stream().mapToInt(s -> s.getScore()).average().getAsDouble(); //getAsDouble() 값을 double로받음.
								 //중간처리↑						//↑집계처리(최종처리)
		System.out.println(avg);
		System.out.println(923/5.0);
		
		
	}
	private static void f2() {
		//Set 컬렉션 생성
		List<String> data = new ArrayList<>();
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		data.add("김자바");
		data.add("김자바");
		data.add("김자바2");
		data.add("김자바2");
		
		//내부반복자(Stream)
		data.stream().forEach(a->{
			System.out.println(a + "====thread이름:" + Thread.currentThread().getName());
		}); //최종적으로결과를얻고싶어서forEach사용
		
		//**병렬처리
		data.parallelStream().forEach(a ->{ //forEach 소비자(Consumer)로 바꿈, 들어간게있지만나오는것이없다.
			System.out.println(a + "====thread이름:" + Thread.currentThread().getName());
		});
		
		
		
	}
	private static void f1() {
		//Set 컬렉션 생성
		Set<String> data = new HashSet<>();
		data.add("홍길동");
		data.add("신용권");
		data.add("김자바");
		
		//외부반복자(Iterator)
		for(String s:data) { //여기가 외부
			System.out.println(s); //처리
		}
	}
}
