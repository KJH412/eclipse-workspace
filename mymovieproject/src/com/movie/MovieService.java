package com.movie;

import java.util.List;

public class MovieService {
	MovieDAO movieDAO = new MovieDAO();
	
	//영화 전체 검색
	public List<MovieDTO> movieSelectAll() {
		return movieDAO.movieSelectAll();
	}
	//장르별 영화 검색
	public List<MovieDTO> searchByGenre(String genre) {
		return movieDAO.searchByGenre(genre);
	}
	//영화ID번호로 영화 제목 조회 
	public List<MovieDTO> titleByMovieId(int movieid) {
		return movieDAO.titleByMovieId(movieid);
	}

}
