package chapter13;

/* 제네릭이란? 
 :선언할때는 파라미터<>로 처리, 실제사용할 때 파라미터를 구체적인타입<String>으로 대체시킨다.
 
 
Box box = new Box();
box.content = 모든객체;
=> Object타입(모든클래스의 최상위 부모클래스), 그렇기 떄문에 모든 객체는 부모타입인 Object로 자동차입변환됨.
=> content필드에 어떤 객체든 대입 가능.


String content = (String)box.content
=> BUT! 저장된것을 다시 끄집어 올 때 구체적인 저장된 객체 타입을 알아야한다.
=> Box안의 내용물을 얻을때가 문제임. content는 Object타입이므로 어떤 객체가 대입되어 있는지 확실하지 않다.

Box<String>box = new Box<String>();
box.content = "안녕하세요"
String content = box.content; 강제 타입 변환 필요X

* 제네릭 타입?
 : 결정되지 않은 타입을 파라미터<>로 가지는 클래스와 인터페이스.
 public class 클래스명<A,B,...>{....}


타입파라미터는 기본적으로 오브젝트 타입으로 간주되기 때문에 오브젝트가 갖고있는 메소드를 호출할 수 있다.

*/