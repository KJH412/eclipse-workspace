package com.movie;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookDTO extends MovieDTO {
	private int book_id;
	private Date book_time;
	private int movie_id;
	private int mcode;
	private int bookSeq;
	private String s_row;
	private int s_num;
	
	private String userId;//?? 추가
	
	private String s_check; //예매여부체크
	private String m_start; //영화시간
	private int running_time;
	
	private String user_id;

	
}
