package com.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.util.DBUtil;

public class BookView {
	public static void print(List<BookDTO> booklist , String title) {
		System.out.printf("| %s |============================\n",title);
		if(booklist.size()==0) {
			System.out.println("[알림] 예매 내역이 없습니다.  ");
			return;
		}
		for(BookDTO book:booklist) {
			System.out.println("▶ 예매번호:" + book.getBook_id() + " 예약날짜:" + book.getBook_time());
			System.out.print(" 상영관: " + book.getCinema()+ " 상영시간: " + book.getM_start() );
			System.out.print("| 영화제목: "  +book.getMovie_title()+"("+book.getRunning_time()+"분)");
			System.out.print(" | 좌석번호: " + book.getS_row()+book.getS_num());
			System.out.println(" | 예매상태: " +book.getS_check());
		}
		
	}



}
