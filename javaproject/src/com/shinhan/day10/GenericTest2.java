package com.shinhan.day10;

import java.util.Arrays;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
class Student implements Comparable<Student> {
	String name;
	int score;

	@Override
	public int compareTo(Student obj) { // int타입이여서 int로 꼭 리턴해야함
		//점수로 desc, 같은점수는 이름으로 asc
		if(obj.score == score) return name.compareTo(obj.name);
		return obj.score - score;
//		return obj.name.compareTo(obj.name)*(-1); //name이름으로 어센딩 sort함
//		return score - obj.score;
//		return obj.score - score ;
	}
}

public class GenericTest2 {
	public static void main(String[] args) {
		// f1();
		// f2();
		// f3();
		//f4();
		f5();
	}

	private static void f5() {
		Car[] arr = {
				new Car("A",100,"black"),
				new Car("C",200,"red"),
				new Car("B",300,"blue"),
				new Car("B",300,"green"),
				new Car("C",300,"red"),
		};
		print2(arr, "orginal");
		Arrays.sort(arr); //ClassCastException발생:
		print2(arr, "가격desc, model desc, color asc");
		/*
		Arrays.sort(arr, (Car obj1, Car obj2)-> {
			int result = obj2.price - obj1.price;
			if(result == 0) {
				int result2 = obj2.model.compareTo(obj1.model);
				if(result2 == 0) return obj1.color.compareTo(obj2.color);
				return result2;
			}
			return result;
		});
		 */
		//람다식 간단
		Arrays.sort(arr, ( obj1, obj2)-> {
			return obj1.price - obj2.price;
		});
		print2(arr, "가격asc, model desc");
		
		//가격asc
		Arrays.sort(arr, (obj1, obj2) -> {
			int result = obj1.price - obj2.price;
			if(result==0) {
				int result2 = obj2.model.compareTo(obj1.model);
				if(result==0) return obj2.color.compareTo(obj1.color);
				return result2;
			}
			return result;
		});
		print2(arr, "가격asc, model desc, color desc");
	}
	
	static void print2(Car[] arr, String title) {
		System.out.println("******** " + title + " ********");
		for (Car car : arr) {
			System.out.println(car);
		}
	}

	private static void f4() {
		Student[] arr = { new Student("A", 10),
						new Student("C", 20), 
						new Student("E", 20), 
						new Student("A", 50),
						new Student("D", 30), 
						};
		print(arr, "orginal");
		// Comparable interface를 구현해야 Sort가능하다. (String,Integer에서 된 이유는 구현하고 )
		Arrays.sort(arr); // ClassCastException발생
		print(arr, "score descending, 이름 Ascending");
		//이미구현 Sort기준을 변경
		Arrays.sort(arr, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				// 이름으로 desc(중요,이걸먼저), 점수로 asc
				int result = o2.name.compareTo(o1.name);
				if(result == 0) return o1.score - o2.score;
				return result;
			}
		});
		print(arr, "이름 desc, 점수 asc");
		Arrays.sort(arr, (o1,o2)->{
			int result = o1.name.compareTo(o2.name);
			if(result == 0) return o2.score - o1.score;
			return result;
		
		});
		print(arr, "이름 asc, 점수 desc");
	}

	static void print(Student[] arr, String title) {
		System.out.println("=======" + title + "=======");
		for (Student st : arr) {
			System.out.println(st);
		}
	}

	private static void f3() {
		// TODO Auto-generated method stub

	}

	private static void f2() {
		String[] arr = { "Hello", "Coffee", "JAVA", "Computer", "java" };
		System.out.println("original:" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Ascending Sort:" + Arrays.toString(arr));
		// A(65), a(97)

		// 2.익명구현class
		/*
		 * Arrays.sort(arr, new Comparator<String>() {
		 * 
		 * @Override public int compare(String o1, String o2) { // TODO Auto-generated
		 * method stub // return o2.compareTo(o1); //더 큰 소문자 j부터 먼저 나옴. return
		 * o2.compareToIgnoreCase(o1); //대소문자 상관x } });
		 */
		// 3.람다식
		Arrays.sort(arr, (String o1, String o2) -> o2.compareToIgnoreCase(o1));

		System.out.println("Descending Sort:" + Arrays.toString(arr));
	}

	private static void f1() {
		Integer[] arr = { 100, 55, 22, 99, 49, 88 };
		System.out.println("original:" + Arrays.toString(arr));
		Arrays.sort(arr);
		// System.out.println("Ascending Sort:" + Arrays.toString(arr)); //작은숫자->큰숫자

		// descending Sort
		// 1.구현class
		Arrays.sort(arr, new MyDescendingSort()); // arr은 기본형타입이 오면 안됌. //sort([T] a , Comparator<?>super<T> c) :void
		// 2.익명class
		/*
		 * Arrays.sort(arr, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) {//Comparator :
		 * Annominus inner class return o2 - o1; } });
		 */
		// 3.람다표현식
		Arrays.sort(arr, (o1, o2) -> o2 - o1);
		System.out.println("Descending Sort:" + Arrays.toString(arr));

	}
}
