package com.shinhan.day09;

/* record : (직접작성하거나 롬복말고도)자바에서 사용하는 방법인데 이렇게 써도 데이터사용이 가능함. 
 * ObjectTest.java의 메소드f2()에서 확인해보기 
 * 
 * record는 전송용으로만 쓴다.
 * 
 * 보통 롬복을 많이 씀.
 * */

//constructor, getter,setter,toString equals 자동 추가된다.
public record ComputerVO2(String model,int price,String company) {

}
