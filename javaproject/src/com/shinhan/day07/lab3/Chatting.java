package com.shinhan.day07.lab3;

class OtherClass{
	void method1() {
		Chatting.Chat aa = new Chatting().new Chat();
	}
}

public class Chatting {
	class Chat {
		void start() {}
		void sendMessage(String message) {}
	}
	
	void method1() {
		Chat aa = new Chat();
	}	
	void startChat(String chatId) {
		String nickName = null;
		//nickName = chatId; //nickName은 final이라 null>chatId로 값을 변경해서 익명클래스에서 접근못함. 변경하면 안됀다.
		
		//익명구현class, local inner class는 지역변수를 참조하는 경우 무조건 지역변수는 final이다.
		Chat chat = new Chat() { //익명클래스(내부클래스)
			@Override
			public void start() {
				while (true) {
					String inputData = "안녕하세요";
					String message = "[" + nickName + "] " + inputData;
					sendMessage(message);
				}
			}
		};
		chat.start();
	}
}