package com.shinhan.day10.exam;

public class Util {
	public static <P extends Pair<K, V>, K, V> V getValue(P pair, K k) {
		//Pair를 상속받은 P
		if(pair.getKey().equals(k))
			return pair.getValue();
		return null;
	}
	//<A,B>:제네릭타입
	//B:리턴타입
	public static <A,B> B getValue3(Pair<A, B> pair, String str) {

		if(pair.getKey().equals(str))
			return pair.getValue();
		return null;
	}


	public static Integer getValue1(Pair<String, Integer> pair, String str) {

		if(pair.getKey().equals(str))
			return pair.getValue();
		return null;
	}
	
}

