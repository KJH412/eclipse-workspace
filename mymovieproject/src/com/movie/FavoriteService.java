package com.movie;

import java.util.List;

import com.movie.dao.FavoriteDAO;

public class FavoriteService {
	FavoriteDAO favDAO = new FavoriteDAO();
	//즐겨찾기
	public int favoriteMovie(int num, String userid) {
		return favDAO.favoriteMovie(num, userid);
		
	}
	public List<FavoriteDTO> favoriteMyMovie(String userid) {
		return favDAO.favoriteMyMovie(userid);
	
	}
	public int deleteChoose(int choose, String userid) {
		return favDAO.deleteChoose(choose,userid);
		
	}
	//중복체크
	public int checkFavoriteMovie(int num, String userid) {
		return favDAO.checkFavoriteMovie(num,userid);
		
	}
}
