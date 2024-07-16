package com.shinhan.day12;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

//Collection은?
//List: add한순서있음, index가능,중복가능 
//		=>ArrayList(중간삽입-삭제 비효율적,추가효율) <-synchronized
//		=>LinkedList(다음데이터, 전 데이터의 주소가짐, 공간차지, 중산삽입-삭제 효율적) <-synchronized
//		=>Vector(동기화지원, 멀티쓰레드환경에 안정적)

//Set: 순서없음, 중복 불가 => HashSet(hashCode(), equals()), 
//						 TreeSet(add시 sort한다.. compareTo) <-sort 비교하기 위해 compareTo필요

//Map: 키와 값의 쌍(entry), 키는 set이다. (key는set이니까 중복불가,순서없음!)
//		=>HashMap, Hashtable, TreeMap, => 키와 값 타입은 내가 정한다.
//		 Properties => 키값이 String만 온다.
public class Review {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}
	private static void f6() {
//		Map<Student, Product> map = new HashMap<>();
//		Map<Student, Product> map = new TreeMap<>();
		Map<Student, Product> map = new Hashtable<>();
		map.put(new Student("A",100), new Product(1, "노트북1", "삼성", 200));
		map.put(new Student("A",100), new Product(1, "노트북2", "삼성", 200));
		map.put(new Student("B",500), new Product(1, "노트북3", "삼성", 200));
		map.put(new Student("C",500), new Product(1, "노트북4", "삼성", 200));
		map.put(new Student("D",400), new Product(1, "노트북5", "삼성", 200));
		print(map, "key가 Student");
	}
	//메서드이름, 매개변수개수와 타입이 같으면 Overloading이 안됨.
	private static void print(Map<Student, Product> map, String title /*형변환 안하려면 써준다.*/) { //에러: 제네릭만 다른print가 또 있다.(X불가)
		System.out.println("====== " + title);	
		for(Student key:map.keySet()) {
			System.out.println(key + "==>" + map.get(key) );
		}
		System.out.println("==========entrySet===========");	//4건
		for(Entry<Student, Product> entry:map.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getKey() );
		}
	}
	private static void print(Map<String, Integer> map) { //Map<String, Integer>
		System.out.println("==========keySet===========");	
		for(String key:map.keySet()) {
			System.out.println(key + "==>" + map.keySet() );
		}
		
		System.out.println("==========entrySet===========");	
		for(Entry<String, Integer> entry:map.entrySet()) { //Map에 있는 Entry
			System.out.println(entry.getKey() + "==>" + entry.getKey() );
		}
		
	}
	private static void f5() {
		/* Map HashMap	*/
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 100);
		map.put("A", 200); //덮어쓰기
		map.put("B", 100);
		map.put("C", 100);
		map.put("D", 100);
		//print(map.keySet());  
		//=>keySet() : key와 value중에서 key만 뽑기
        //=>key가 문자열이라서 Collection<String>을 받는 print메소드가 호출 됨. <String, Integer>받는 print메소드생성
		print(map);
	}

	private static void f4() {
		/*TreeSet*/
		Set<Student> data = new TreeSet<>(); //cast to class java.lang.Comparable에러=>Comparable로 형변환이 필요하다.
		data.add(new Student("A", 70));
		data.add(new Student("A", 70)); //X 
		data.add(new Student("B", 80));
		data.add(new Student("C", 70));	//X :점수로만 비교해서 제거됨. 
		data.add(new Student("B", 80)); //X 
		print(data);
	}
	private static void f3() {
		/*HashSet*/
		Set<Student> data = new HashSet<>();
		data.add(new Student("A", 70));
		data.add(new Student("A", 70)); //X 중복제거
		data.add(new Student("B", 80));
		data.add(new Student("C", 60));
		data.add(new Student("B", 80)); //X 중복제거
		print(data);
		
	}

	private static void print(Set<Student> data) { //Set인테 Student타입만 들어온다.
		for(Student s:data) {
			System.out.println(s); //-->주소가 찍힘. --> toString재정의 필요.
		}
	}

	private static void f2() {
		
		Set<String> data = new HashSet<>();
		data.add("월"); //add()데이터 집어넣기
		data.add("월"); 
		data.add("토"); 
		data.add("토"); 
		print(data);
		
	}

	private static void f1() {
		/* List는 3개 다 가능 ArrayList LinkedList Vector */
		
//		List<String> data = new ArrayList<>();
//		List<String> data = new LinkedList<>();
		List<String> data = new Vector<>();
		data.add("월"); //add()데이터 집어넣기
		data.add("월"); 
		data.add("토"); 
		data.add("토"); 
		print(data); //함수호출
	}

//	private static void print(List<String> data) { ▼
		private static void print(Collection<String> data) { //Collection은 List,Set,Map 다 들어올 수 있다.
		
		System.out.println("==========Collection<String>===========");	
		for(String s:data) { //(데이터타입 변수:여러건이들어옴)
			System.out.println(s);
		}
	}
	
}
