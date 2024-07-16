package com.shinhan.day13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		System.out.println("===== 클라이언트가 서버에 요청 =====");
		
//		Socket socket = new Socket("192.168.0.70", 5001);
		Socket socket = new Socket("192.168.0.39", 5001);
		
		System.out.println("===== client END =====");
		*/
		
		try {
			Socket socket = new Socket("localhost", 5001);

			System.out.println("[클라이언트] 연결 성공");

			// ------------------------------------------------------------

			// 데이터 보내기
			String sendMessage = "나는 자바가 좋아~~";
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(sendMessage);
			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄 : " + sendMessage);

			// 데이터 받기
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMessage = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음 : " + receiveMessage);

			// ------------------------------------------------------------

			// 연결 끊기
			socket.close();
			System.out.println("[클라이언트] 연결 끊음");
			
		} catch (Exception e1) {
		}
	}
}
