package com.shinhan.day11.collection;
//컬렉션자료구조
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import com.shinhan.day10.thread.Account;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@ToString
class Car implements Comparable<Car>{
	String model;
	int price;
	
	@Override
	public int compareTo(Car obj) { //순서 기준!
		//가격순 asc, model desc 
		if(price - obj.price == 0) return obj.model.compareTo(model);
		return price - obj.price;
	} //가격이같으면 desc
}

public class CollectionTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
		f8();
//		f9();
//		f10();
	}
	private static void f10() {
		Map<Car, Integer> data = new TreeMap<>();
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A", 1000), 2); //
		data.put(new Car("B", 3000), 3);
		data.put(new Car("C", 1000), 4);
		data.put(new Car("B", 3000), 5); //
		
		//containsKey / containsValue
		System.out.println(data.containsKey(new Car("C", 1000))); //true
		System.out.println(data.containsKey(new Car("C2", 1000))); //false
		System.out.println(data.containsValue(4)); //true
		System.out.println(data.containsValue(44)); //false
		
		for(Car key:data.keySet()) {
			System.out.println(key + " ==> " + data.get(key));
		}
	}
	private static void f9() {
		Map<Car, Integer> data = new HashMap<>(); //중복x,순서도x
		data.put(new Car("A", 1000), 1);
		data.put(new Car("A", 1000), 2); //!!!!
		data.put(new Car("B", 3000), 3);
		data.put(new Car("C", 1000), 4);
		data.put(new Car("B", 3000), 5); //!!!!
		
		for(Car key:data.keySet()) {
			System.out.println(key + " ==> " + data.get(key));
		}
	}
	private static void f8() {
		Map<String, Car> data = new HashMap<>(); //중복x,순서도x
		data.put("A", new Car("A", 1000));
		data.put("A", new Car("A2", 2000)); // 덮어쓰기, 이 값으로 들어감
		data.put("B", new Car("B", 1000));
		data.put("C", new Car("C", 1000));
		data.put("B", new Car("B2", 1000)); // 덮어쓰기, 이 값으로 들어감
		
		for(String key : data.keySet()) {
			System.out.println(key + " => " + data.get(key));
		}
	}
	private static void f7() {
		//배열(연속공간, 갯수 가변불가)
		//Collection : List(순서있고중복있음),Set(순서없고중복없음),Map(키와값의쌍)  => 고려해서 사용.
//		List<Car> alist = new LinkedList<>(); //순서있게 출력
		Set<Car> alist = new HashSet<>(); //순서있게 출력 (HashSet 순서보장할 수 없음?)
//		alist.add(0, new Car("B", 2000)); //원하는 위치에 삽입.

		alist.add(new Car("A", 3000)); //뒤에 추가
		alist.add(new Car("B", 2000)); //뒤에 추가
		alist.add(new Car("C", 2000)); //뒤에 추가
		alist.add(new Car("A", 5000)); //뒤에 추가
		for(Car car:alist) {
			System.out.println(car);
		}
	}
	private static void f6() {
		/* Map : key와 value의 쌍이다(Map.Entry), key는 Set으로 만듦(중복불가) 
		 * 구현class : HashMap,HashTable,TreeMap,Properties
		 */
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 99);
		data.put("B", 100);
		data.put("C", 77);
		data.put("B", 99);
		data.put("A", 88); //이미 존재하는 키가 있으면 덮어쓴다.
		System.out.println(data.size()); //3개(중복제외)
		System.out.println(data.get("A"));  //88찍힘
		System.out.println(data.get("B"));  //99찍힘
		
		//1.키의 이름을 모른다면 (key는 순서없다) keySet이 제일 간략하다.
		System.out.println("=============== 1.keySet() =============");
		for(String key:data.keySet()) {
			System.out.println(key + "==>" + data.get(key));
		}
		//2.
		System.out.println("=============== 2.entrySet() =============");
		Set<Map.Entry<String,Integer>> entrySet = data.entrySet();
		for(Map.Entry<String,Integer> entry:data.entrySet()) {
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
		//3.
		System.out.println("=============== 3.iterator =============");
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "==>" + entry.getValue());
		}
	}

	private static void f5() {
		/*Set : 순서가 없고 중복불가 interface => 구현class: HashSet, TreeSet(순서있)*/
		Set<Car> data = new HashSet<>(); 
//		Set<Car> data = new TreeSet<>();  //ClassCastException에러
		data.add(new Car("A", 1000));
		data.add(new Car("A", 1000));
		data.add(new Car("C", 4000));
		data.add(new Car("D", 4000));
		data.add(new Car("C", 5000));
		
		System.out.println("개수" + data.size()); //3개
		
		System.out.println("=============== 일반FOR 불가=============");
		System.out.println("=============== 확장FOR =============");
		for(Car s:data) { 
			System.out.println(s); 
		}
		System.out.println("=============== 반복자이용(Iterator) =============");
		Iterator<Car> it = data.iterator();
		while(it.hasNext()) { 
			System.out.println(it.next());
		}
	}
	private static void f4() {
		/*Set : 순서가 없고 중복불가 interface => 구현class: HashSet, TreeSet(순서있)*/
		TreeSet<String> data = new TreeSet<>(); //TreeSet타입은 순서가 있음.
		data.add("C");
		data.add("B");
		data.add("C");
		data.add("A");
		data.add("B"); 
		
		System.out.println("개수" + data.size()); //3개
		
		System.out.println("=============== 일반FOR 불가=============");
		
		System.out.println("=============== 확장FOR =============");
		for(String s:data) { 
			System.out.println(s); 
		}
		System.out.println("=============== 반복자이용(Iterator) =============");
		Iterator<String> it = data.iterator();
		while(it.hasNext()) { 
			System.out.println(it.next());
		}
		//출력결과 : A  B C (sort됨 순서대로나옴)
		
	}
	private static void f3() {
		/*Set : 순서가 없고 중복불가 interface => 구현class: HashSet, TreeSet(순서있음)*/
		
		Set<String> data = new HashSet<>();
		data.add("월");
		data.add("화");
		data.add("토");
		data.add("토"); //add안됨(중복check)
		data.add("월"); //add안됨(중복check)
		
		System.out.println("개수" + data.size()); //3개
		
		System.out.println("=============== 일반FOR 불가=============");
		//for(int i=0; i<data.size(); i++) {
		//	System.out.println(data.get(i));
		//}
		System.out.println("=============== 확장FOR =============");
		for(String s:data) { 
			System.out.println(s); //순서가 없이 출력됨.
		}
		System.out.println("=============== 반복자이용(Iterator) =============");
		Iterator<String> it = data.iterator();
		while(it.hasNext()) { //hasNext : 값이 있는지 체크
			System.out.println(it.next());
		}
		
	}
	private static void f2() {
		/*List:순서있고 중복가능 interface ==>구현class (ArrayList, LinkedList, Vector)*/
		
		//ArrayList : 연속공간필요, 공간이 부족하면 자동증가, 중간 삽입, 삭제시 비효율적(당기거나 밀거나 이동이 있음)
		//LinkedList : 연속공간 불필요,전요소나 후요소의 주소기억(공간차지), 중간삽입, 삭제시 효율적
		//Vector : Multi Thread에서 동기처리 가능
		
		//ArrayList<String> data = new ArrayList<>(); //모든 타입의 객체를 저장
		//LinkedList<String> data = new ArrayList<>(); 
		//Vector<String> data = new Vector<>(); //멀티스레드에서는Vector를 쓴다. synchronized 지원

		List<String> data1 = new ArrayList<>(); 
		List<String> data2 = new LinkedList<>(); 
		List<String> data3 = new Vector<>(); 
	
		insertData(data1);
		insertData(data2);
		insertData(data3);
		
		displayData(data1, "ArrayList");
		displayData(data2, "LinkedList");
		displayData(data3, "Vector");
		
		
		/*
		System.out.println("=============== 일반FOR =============");
		for(int i=0; i<data.size(); i++) {
			System.out.println(data.get(i));
		}
		System.out.println("=============== 확장FOR =============");
		for(String s:data) {
			System.out.println(s);
		}
		*/
	}
	
	private static void displayData(List<String> data, String title) {
		System.out.println(title + "=============== 일반FOR =============");
		for(int i=0; i<data.size(); i++) {
			System.out.println(data.get(i));
		}
		System.out.println(title + "=============== 확장FOR =============");
		for(String s:data) {
			System.out.println(s);
		}
		
	}
	private static void insertData(List<String> data) { //List로 구현된 클래스는 다 올 수 있다.
		data.add("월");
		data.add("토");
		data.add("화");
		data.add("토");
	}
	
	private static void f1() {
		//List:순서있고 중복가능 interface ==>구현class (ArrayList, LinkedList, Vector)
		ArrayList data = new ArrayList(); //모든 타입의 객체를 저장
		data.add("문자"); //add는 순서대로 값 들어감.
		data.add(100);
		data.add(new Account());
		
		String a = (String)data.get(0);
		int b = (Integer)data.get(1);
		Account acc = (Account)data.get(2);
		
	}
	
}
