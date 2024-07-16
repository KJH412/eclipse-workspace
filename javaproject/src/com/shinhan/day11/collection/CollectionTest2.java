package com.shinhan.day11.collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Properties;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

//Map(키,값 쌍) 키중복 불가, hascode(),equals()
//: HashMap, TreeMap(순서있음, Comparable구현), 
// Hashtable (동기화 가능) :싱글스레드에서 변화없음, 멀티스레드에도 안정적

public class CollectionTest2 {
	public static void main(String[] args) {
		ArrayList<String> a;
//		f1(); //Map
//		f2(); //Properties
//		f3(); //TreeSet
//		f4(); //TreeMap
//		f5(); //stack
//		f6(); //Queue
		f7();
	}

	//변경불가
	private static void f7() {
		String[] arr = {"자바","디비","웹","프레임워크"};
		List<String> alist = Arrays.asList(arr);
		List<String> alist2 = List.of("자바","디비","웹","프레임워크");
		Set<String> aset = Set.of("자바","디비","웹","프레임워크"); //중복data는 불가
		Map<Integer, String> map = Map.of(1,"자바",2,"디비",3,"웹",4,"프레임워크"); 

		List<String> alist3 = new ArrayList<String>();
		alist3.add("A1");
		alist3.add("A2");
		alist3.add("A3");
		List<String> alist4 = List.copyOf(alist3);
		//불가 alist4.add("AA4"); copyOf사용해서 만든 컬렉션List는 수정불가.
		
		//불가 alist.add("AAAA"); 
		//불가 alist2.add("AAAA");
		//불가 map.put(5, "aaa");
		for(Integer key:map.keySet()) {
			System.out.println(key + "==" + map.get(key));
		}
	}

	private static void f6() {
		//FIFO(선입선출) 먼저들어간 게 먼저 나온다.
		//offer, poll
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(100);
		queue.offer(300);
		queue.offer(400);
		queue.offer(500);
		queue.offer(200);
		while(queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

	private static void f5() {
		//LIFO(후입선출) stack은 나중에 넣은게 먼저 나온다.
		//push, pop
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(100);
		stack.push(300);
		stack.push(400);
		stack.push(200);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop()); 
		}
	}

	private static void f4() {
		TreeMap<String, Integer> treeMap = new TreeMap<>();
		treeMap.put("apple1", 10);
		treeMap.put("apple2", 20);
		treeMap.put("apple3", 40);
		treeMap.put("apple4", 50);
		treeMap.put("apple5", 30);
		//print(treeMap, "original");
		print2(treeMap, "original");
		//print3(treeMap, "찾기");
		//treeMap.descendingMap(); //descendingMap->NavigableMap<String, Integer>타입임.
		print2(treeMap.descendingMap(),"descendingMap");
	}
	//
	private static void print3(TreeMap<String, Integer> treeMap, String title) {
		System.out.println("====" + title);
		System.out.println(treeMap.firstKey());
		System.out.println(treeMap.firstEntry());
	}
	//entrySet
	private static void print2(NavigableMap<String, Integer> treeMap, String title) {
		System.out.println("========" + title);
		for(Map.Entry<String, Integer> entry:treeMap.entrySet()) { //treeMap.keySet() 키들
			System.out.println(entry.getKey() + " ===> "+ entry.getValue()); //순서대로 나타남.
		}
		
	}
	//keySet
	private static void print(TreeMap<String, Integer> treeMap, String title) {
		for(String key:treeMap.keySet()) { //treeMap.keySet() 키들
			System.out.println(key + "==>"+ treeMap.get(key)); //순서대로 나타남.
		}
		
	}

	private static void f3() {
		//Set으로 하면 중복안돼서?
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		print(scores, "ascending"); //default
//		print2(scores);
//		NavigableSet<Integer> descScoreSet = scores.descendingSet();
//		for(Integer data:descScoreSet) {
//			System.out.println(data);
//		}
//		print(scores.descendingSet(), "Descending"); //>=80
//		print(scores.tailSet(80,true),"tailSet"); //>=80
		print(scores.subSet(80,true,90,false),"subSet"); //80<= <90
	}
	private static void print(Set<Integer> scores, String title) {
		System.out.println(title +" Sort----------------");
		for(Integer data:scores) {
			System.out.println(data);
		}
		
	}
	private static void print2(TreeSet<Integer> scores) {
		System.out.println("가장 낮은 점수: "+scores.first());//제일 낮은객체 리턴
		System.out.println("가장 높은 점수: "+scores.last()); //제일 높은객체 리턴
		System.out.println("바로 아래 점수: "+scores.lower(95));
		System.out.println("바로 위 점수: "+scores.higher(95)); 
		System.out.println("가장 낮은 점수: "+scores.floor(95)); 
		System.out.println(" 점수: "+ scores.ceiling(96));  //주어진 객체와 동등한객체리턴,없으면 주어진 값 바로 위 객체가 리턴 
	} 

	

	private static void f2() {
		Properties pro = new Properties();
		//변경사항이 생길 것 같은건 properties로 따로 빼주는게 좋다.
		try {
			pro.load(CollectionTest2.class
					.getResourceAsStream("oracleDB.properties"));//현재경로를 기준으로 파일찾음.
		
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			String myname = pro.getProperty("myname");
			String myname3 = pro.getProperty("myname3"); //null
			String myname2 = pro.getProperty("myname2", "AAA"); //파일에 없는건 default값으로 줄 수 있다.
			
			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(myname);
			System.out.println(myname3);
			System.out.println(myname2);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	private static void f1() {
//		Map<String, Integer> map = new HashMap<>(); //HashMap : 충돌됨. 값이 일정하지 않음.
		Map<String, Integer> map = new Hashtable<>(); //Hashtable: 동기화지원,멀티스레드환경에서 지원함.
		Thread t1 = new Thread() {
			//구현
			public void run() {
				for(int i=1; i<=1000; i++) {
					System.out.println(getName() + "!!!!");
					map.put(String.valueOf(i), i); //{"1":1, "2":2, ......"1000":1000}
				}
			}
		};
		Thread t2 = new Thread() {
			//구현
			public void run() {
				for(int i=1001; i<=2000; i++) {
					System.out.println(getName() + "@@@@@" + i);
					map.put(String.valueOf(i), i); //{"1":1, "2":2, ......}
				}
			}
		};
		t1.start(); t2.start();
		
		//기다리지 않으면 entry개수 0으로 뜸.
		try {
			t1.join(); //t1이 끝날(종료)때 까지 기다림
			t2.join();
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("entry개수:" + map.size());
	}
}
