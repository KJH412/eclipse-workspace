package com.movie;

import com.movie.dao.SeatDAO;

public class SeatService {
	
	SeatDAO seatDAO = new SeatDAO();
	
	public boolean seatCheck(String srow, int snum, int movieid) {
		return seatDAO.seatCheck(srow, snum,movieid);
	}
}
