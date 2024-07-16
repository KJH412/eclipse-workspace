package com.movie;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.util.DateUtil;


public class MainControler {
	static Scanner sc = new Scanner(System.in);
	MovieService movieService = new MovieService();
	public static void main(String[] args) {

		MovieService movieService = new MovieService();
		MemberService memberService = new MemberService();
		SeatService seatService = new SeatService();
		BookService bookService = new BookService();
		FavoriteService favoriteService = new FavoriteService();
		
		//1. 로그인, 회원가입, 영화조회 while문  (로그인 완료시 isStop=true로 빠져나가고 다음 while문으로 이동.)
		boolean isLoginStop = false;
		String loginId = null ;
		
		while (!isLoginStop) {

			int selectjob = loginDisplay(); // 메뉴

			switch (selectjob) {
			case 0 -> {
				isLoginStop = true;
			}
			case 1 -> { //로그인
				System.out.print("아이디 입력 : ");
				String userid = sc.next();
				
				System.out.print("🔑비밀번호 입력 : ");
				String userpw = sc.next();
				
				int login = memberService.memberLogin(userid, userpw);
				
				if (login == 1) { //아이디 존재하면 로그인.
					MemberView.print(login); 
					isLoginStop = true;
					loginId = userid;
					
				} else { //해당하는 아이디가 없으면 회원가입을 진행.  
					System.out.println("-----------------------------");
					System.out.println("|    [알림]회원 정보가 없습니다.    |");
					System.out.println(" ---------------------------");
					System.out.println("|   회원 가입을 진행 하시겠습니까?   |");
					System.out.println("-----------------------------");
					boolean isStopSub = false;
					while(!isStopSub) {
						int memJoin = menuJoin();
						switch (memJoin) {
							case 0 ->{
								isStopSub = true;
							}
							case 1 ->{
								MemberDTO mem = memberInsert();
								int result = memberService.memberInsert(mem);
								MemberView.print(result > 0 ? "회원가입되었습니다. 로그인을 진행해주세요." : "회원가입에 실패했습니다.");
								isStopSub = true;
							}
							
						}
						
					}
				}
			}
			case 2 ->{ //회원가입
				 boolean isRegStop = false;
				    while (!isRegStop) {
				        MemberDTO mem = memberInsert();
				        int result = memberService.memberInsert(mem);
				        if (result > 0) {
				            MemberView.print("회원가입을 축하합니다.");
				            isRegStop = true;
				        } else {
				            MemberView.print("회원가입에 실패했습니다.");
				            System.out.println("다시 회원가입을 진행하시겠습니까? (Y/N)");
				            String userInput = sc.next();
				            if (!userInput.equalsIgnoreCase("Y")) {
				                break; //다시 회원가입을 진행하지 않을 경우 루프를 종료.
				            }
				        }
				    }
			}
			case 3 -> {searchAllFilm();}
			default -> {}
		}
	}
	
	//2.로그인 완료 후 예매하기,예매취소,정보수정,영화검색 및 즐겨찾기
	boolean isStop = false;
	while(!isStop) {

		int selectjob2 = myMenuDisplay(); 

		switch (selectjob2) {
			case 0 -> { isStop = true; }
			//예매하기
			case 1 -> {
			//>>날짜 입력:
				Date bookdate = null;
				do {
					System.out.print("예약 할 날짜 입력[ex)2024-04-12] >>");
					bookdate = DateUtil.getSQLDate(sc.next()); 
					
					if(bookdate == null) {
						System.out.println("잘못된 입력입니다. 조건에 맞춰 입력해주세요.");
					}
				
				}while(bookdate == null);
				
		    //>>영화 번호로 선택:1  => 해당 번호의 영화 제목 확인한다.
				int movieid;
				do {
					System.out.print("예매할 영화 번호 입력[1~10] >> ");
					movieid = sc.nextInt();
					
					if( movieid >=1  && movieid <= 10 ) {
						System.out.println("선택한 영화 정보 및 상영시간 확인:\n"+ movieService.titleByMovieId(movieid));
					}else {//없는 번호 입력했을 때
						System.out.println("영화 번호를 다시 입력해 주세요.");
					}
				}while(movieid<1 || movieid > 10);

			//>>좌석행 선택:A  
				String srow;
				do {
					System.out.print("좌석 행 번호 입력[ex)A, B, C ~ E] >> ");
					srow = sc.next();
					
					if (!srow.matches("[A-Ea-e]")) {
						System.out.println("잘못된 입력입니다. 'A'만을 입력해주세요.");
					}
				
				}while(!srow.matches("[A-Ea-e]"));
				
			//>>좌석번호: 1
				System.out.print("좌석 번호 입력[ex)1, 2 ,3 등] >> ");
				int snum = sc.nextInt();
				
			//예매 가능 여부 출력 
				boolean isSeat = seatService.seatCheck(srow, snum, movieid); 
				BookDTO book = new BookDTO();
				if (isSeat) {
					book.setMovie_id(movieid);
					book.setUserId(loginId);
					book.setS_row(srow);
					book.setS_num(snum);
					
					bookService.bookMovie(book);
				    // 좌석 예약 가능할 경우 
					System.out.println("영화 예매가 완료되었습니다.");
				} else {
				    // 좌석 예약 불가능할 경우 
				    System.out.println("[알림] 이미 예약된 좌석입니다. 다른 좌석을 선택해주세요.");
				}
			}
			//예매 취소 (예약상태를 Y -> N으로 수정) 
			case 2 -> {
				 System.out.print("회원 아이디 입력 >> ");
				 String userid = sc.next();
				 System.out.print("좌석 행 입력[ex)A,B,C] >> ");
				 String sRow = sc.next();
				 System.out.print("좌석 번호를 입력[ex)1,2,3] >> ");
				 int sNum = sc.nextInt();
			 	 System.out.println("예매 번호 >>");
				 int bookid = sc.nextInt();
				 
		
				 BookDTO book = new BookDTO();
				 book.setUser_id(userid);
				 book.setS_num(sNum);
				 book.setS_row(sRow);
				 book.setBook_id(bookid);
				 
				 int result =  bookService.bookCancle(book);
				 if(result == 1) {
					 System.out.println("[알림]예매 내역이 취소됐습니다.");
				 }
			}
			//예매 내역 확인
			case 3 -> { //예매 내역 확인
				System.out.print("아이디 입력 >> ");
				String userid = sc.next();
				List<BookDTO> booklist = bookService.myBookList(userid);
				BookView.print(booklist, "예매 내역 확인");
			}
			case 4 -> { //회원 정보 수정 (update)
				System.out.print("아이디 확인 : ");
				String userid = sc.next();
				
				System.out.print("🔑비밀번호 확인 : ");
				String userpw = sc.next();
				
				int login = memberService.memberLogin(userid, userpw);
				//System.out.println(login);
				
				//1.아이디, 비밀번호 수정
				System.out.println("변경 할 아이디 >>");
				String newid = sc.next();
				System.out.println("변경 할 비밀번호 >>");
				String newpw = sc.next();
				
				int result = memberService.myChangeInfo(newid, newpw);
				MemberView.printChange(result, "정보 변경 완료");
				
				
			}
			case 5 -> { searchAllFilm(); } 
			case 6 -> {//즐겨찾기
				System.out.print("아이디 확인 : ");
				String userid = sc.next();
				
				MovieDTO mov = new MovieDTO();
				
				List<MovieDTO> movielist = movieService.movieSelectAll();
				MovieView.print(movielist, "상영 영화 목록");
				
				System.out.println("찜 할 영화 번호 입력[1~10] >>");
				int num = sc.nextInt();
				// 중복체크
				int isExist = 0;
				isExist = favoriteService.checkFavoriteMovie(num, userid);
				
				if(isExist == 0) {
					favoriteService.favoriteMovie(num, userid);
					MovieView.printFavorite(num, userid);
				}else {
					System.out.println("[알림] 중복된 영화 번호는 입력할 수 없습니다.");
				}
				
				
			}
			case 7 -> {//즐겨찾기 내역 및 삭제
				System.out.print("아이디 확인 : ");
				String userid = sc.next();
				
				
				List<FavoriteDTO> favlist = favoriteService.favoriteMyMovie(userid);
				FavoriteView.print(favlist);
				
				System.out.print("즐겨찾기 삭제 할 영화의 번호 선택 >> ");
				int choose = sc.nextInt();
				favoriteService.deleteChoose(choose,userid);
				FavoriteView.printDelete(choose);
			}
			default -> {}
		}
	}
}
	//상영 영화 조회 메소드
	public static void searchAllFilm() { 
		MovieService movieService = new MovieService();
		
		boolean isMovieStop = false;
		while(!isMovieStop) {
			int selMovie = menuMovie();
			
			switch (selMovie) {
				case 0 -> {isMovieStop = true;}
				case 1 -> {
					List<MovieDTO> movielist = movieService.movieSelectAll();
					MovieView.print(movielist, "상영 영화 목록");
				}
				case 2 -> {
					System.out.println();
					System.out.print("장르 입력[ex)horor] >>");
					String genre = sc.next();
					MovieView.print(movieService.searchByGenre(genre), "장르별 영화 검색");
				}
			}
		}
	}
	//상영 영화 조회 선택 후 서브 메뉴
	private static int menuMovie() {
		System.out.println("1. 전체 상영 영화 조회 | 2. 장르별 영화 조회  | 0.뒤로가기");
		System.out.println("----------------------------------------------");
		System.out.print("번호 선택>> ");
		int job = sc.nextInt();
		
		return job;
	}
	//회원가입 메뉴 선택
	private static int menuJoin() { 
		System.out.println("선택 ▶ 1.회원가입  | 0.뒤로가기 ");
		System.out.println("-------------------------");
		System.out.print("번호 선택>> ");
		int job = sc.nextInt();

		return job;
	}
	
	// 회원가입 정보 입력 (아아디 비밀번호 이름 전화번호 나이)
	public static MemberDTO memberInsert() {
		// 아이디
		System.out.print("ID 입력 >>");
		String uesrid = sc.next();
		// 비밀번호
		System.out.print("🔑PW 입력 >>");
		String uesrpw = sc.next();
		
		System.out.print("이름 입력[ex)홍길동] >>");
		String uesrname = sc.next();

		System.out.print("📞전화번호 입력[ex)010-0000-0000] >>");
		String uesrphone = sc.next();
		
		System.out.print("생년월일 입력[ex)2000-01-01] >>");
		String uesrage = sc.next();

		MemberDTO mem = new MemberDTO();
		mem.setUser_id(uesrid);
		mem.setUser_pw(uesrpw);
		mem.setPhone(uesrphone);
		mem.setUser_name(uesrname);
		mem.setUser_age(uesrage);

		return mem;
	}

	//처음 메뉴
	private static int myMenuDisplay() {
		System.out.println("==========================================================================================================");
		System.out.println("                                        ★☆⋆⁺₊⋆ WELCOME MY MOVIE📽 ⋆⁺₊⋆★☆                                     ");
		System.out.println("==========================================================================================================");
		System.out.println(" 1.영화예매 |  2.예매취소  |  3.예매내역확인  | 4.회원정보수정 | 5.상영 영화 조회 | 6.영화 즐겨찾기 | 7.즐겨찾기 삭제 | 0.로그아웃 ");
		System.out.println("===========================================================================================================");
		System.out.print("번호 선택 >> ");
		int job = sc.nextInt();

		return job;
	}
	private static int loginDisplay() {
		System.out.println("===============================================");
		System.out.println("                  📽 MOVIE                   ");
		System.out.println("===============================================");
		System.out.println(" 1.로그인 |  2.회원가입  |  3.상영 영화 조회  | 0.종료");
		System.out.println("===============================================");
		System.out.print("번호 선택 >> ");
		int job = sc.nextInt();
		
		return job;
	}

}
