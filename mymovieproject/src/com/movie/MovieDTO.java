package com.movie;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
public class MovieDTO {
	 private int movie_id;
	 private String movie_title;
	 private Date m_release;
	 private int running_time;
	 private double grade;
	 private String director;
	 private String movie_age;
	 private String m_country;
	 private String g_kind; //장르
	 private String cinema;
	 private String m_start; //영화시간
	 
	@Override
	public String toString() {
		return "[" + movie_id +"] " + "🎬" +movie_title+ "(" + running_time  + "분)"+ " | 상영관:" +cinema+ ", 🕗영화시작:" + m_start 
				+ " | " + m_country  +" | " + movie_age + " |"
				+ "\n " + "개봉: " + m_release
				+ "\n " + "평점: ☆" + grade
				+ "\n " + "감독:" + director
				+ "\n "+ "장르:"+  g_kind 
				+ "\n----------------------------------------------";
	}

	 
}
