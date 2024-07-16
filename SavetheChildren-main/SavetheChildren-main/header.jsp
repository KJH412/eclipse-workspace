<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>  
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/logo/shortcut_logo.png">
    <title>headerJSP</title>
    <!-- css -->
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/header.css?after">
</head>
<body>
    <header class="stc_header" data-sub="off">
        <div class="gnb_wrap">
            <div class="left_gnb">
                <h1 class="logo">
                    <a href="#void">
                        <img src="images/logo/logo.png" class="logoImg" alt="로고">
                    </a>
                </h1>
            </div>
            <div class="nav_sub_bg">
                <ul class="nav_campaign_wrap">
                    <li>
                        <a href="#">
                            <div class="nav_campaign_img">
                                <img src="images/maingnb/maingnb_1.jpg" alt="캠패인">
                            </div>
                            <div class="campaign_title">
                                <p>아이를 구하는 긴급구호 팔찌</p>
                            </div>
                        </a>
                    </li>
                    <li>
                        <div class="nav_campaign_img">
                            <img src="images/maingnb/maingnb_2.jpg" alt="캠패인">
                        </div>
                        <div class="campaign_title">
                            <p>아프리카에 빨간염소 보내기</p>
                        </div>
                    </li>
                    <li>
                        <div class="nav_campaign_img">
                            <img src="images/maingnb/maingnb_3.jpg" alt="캠패인">
                        </div>
                        <div class="campaign_title">
                            <p>골든타임 세이버</p>
                        </div>
                    </li>
                    <li>
                        <div class="nav_campaign_img">
                            <img src="images/maingnb/maingnb_4.jpg" alt="캠패인">
                        </div>
                        <div class="campaign_title">
                            <p>Save 더 Children</p>
                        </div>
                    </li>
                    <li>
                        <div class="nav_campaign_img">
                            <img src="images/maingnb/maingnb_5.jpg" alt="캠패인">
                        </div>
                        <div class="campaign_title">
                            <p>좋아서하는기념일</p>
                        </div>
                    </li>
                    <li>
                        <div class="nav_campaign_img">
                            <img src="images/maingnb/maingnb_6.png" alt="캠패인">
                        </div>
                        <div class="campaign_title">
                            <p>그리다. 100가지 말성처</p>
                        </div>
                    </li>
                    <li>
                        <div class="nav_campaign_img">
                            <img src="images/maingnb/maingnb_7.jpg" alt="캠패인">
                        </div>
                        <div class="campaign_title">
                            <p>놀이터를 지켜라</p>
                        </div>
                    </li>
                    <li>
                        <div class="nav_campaign_img">
                            <img src="images/maingnb/maingnb_8.png" alt="캠패인">
                        </div>
                        <div class="campaign_title">
                            <p>신생아살리기</p>
                        </div>
                    </li>
                </ul>
            </div>
            <div class="nav_wrap">
                <nav>
                    <ul id="nav" class="nav_list">
                        <li>
                            <a href="#void" class="menu">기관</a>
                                <ul class="sub">
                                    <li><a href="#void">세이브더칠드런<br/>100주년</a></li>
                                    <li><a href="#void">세이브더칠드런 정신</a></li>
                                    <li><a href="#void">연혁/조직</a></li>
                                    <li><a href="#void">투명경영/전략</a></li>
                                    <li><a href="#void">재정보고</a></li>
                                    <li><a href="#void">인사말</a></li>
                                    <li><a href="#void">홍보대사</a></li>
                                    <li><a href="#void">인재채용</a></li>
                                </ul>
                        </li>
                        <li>
                            <a href="#void" class="menu">사업</a>
                            <ul class="sub">
                                <li><a href="#void">해외사업</a></li>
                                <li><a href="#void">국내사업</a></li>
                                <li><a href="#void">권리옹호</a></li>
                            </ul>                        
                        </li>
                        <li>
                            <a href="#void" class="menu">후원</a>
                            <ul class="sub">
                                <li><a href="#void">해외결연후원</a></li>
                                <li><a href="#void">정기후원</a></li>
                                <li><a href="#void">기업·단체후원</a></li>
                                <li><a href="#void">소상공인후원</a></li>
                                <li><a href="#void">고액·유산기부</a></li>
                                <li><a href="#void">기념일기부</a></li>
                                <li><a href="#void">선물가게</a></li>
                                <li><a href="#void">후원가이드</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#void" class="menu">참여</a>
                            <ul class="sub">
                                <li><a href="#void">캠페인</a></li>
                                <li><a href="#void">후원자 프로그램</a></li>
                                <li><a href="#void">착한소비</a></li>
                                <li><a href="#void">서명하기</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#void" class="menu">소식</a>
                            <ul class="sub">
                                <li><a href="#void">나눔이야기</a></li>
                                <li><a href="#void">소식지</a></li>
                                <li><a href="#void">연차보고서</a></li>
                                <li><a href="#void">뉴스레터</a></li>
                                <li><a href="#void">동영상</a></li>
                                <li><a href="#void">보고서</a></li>
                                <li><a href="#void">공지/뉴스</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>         
            </div>
            <div class="right_gnb">
                <div class="login_search">
                    <ul class="login_search_list">
                        <li class="login">
                            <button type="button" class="login_btn">
                                <em class="loginTxt">로그인</em>
                                <span class="blind">로그인메뉴</span>
                            </button>
                            <div class="login_menu">
                                <div class="login_link_wrap">
                                    <a class="login_link" href="#void">로그인</a>
                                    <a class="join_link" href="#void">회원가입</a>
                                </div>
                                <div class="login_sub">
                                    <ul class="login_sub_list">
                                        <li><a href="#">나의 후원 내역</a></li>
                                        <li><a href="#">해외결연후원</a></li>
                                        <li><a href="#">후원자료실</a></li>
                                        <li><a href="#">나의 회원정보</a></li>
                                        <li><a href="#">FAQ</a></li>
                                        <li><a href="#">SNS로그인 설정</a></li>
                                        <li><a href="#">1:1문의</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li class="search">
                            <button type="button" class="search_btn">
                                <span class="blind">검색</span>
                            </button>
                        </li>
                    </ul>
                </div>
                <div class="ham_btn">
                    <a href="#void" class="ham">
                        <span class="blind">햄버거버튼</span>
                    </a>
                </div>
                <div class="sponsorship">
                    <button type="button" class="sponsorship_btn">후원하기</button>
                </div>
            </div>
        </div>
    </header>

    <script type="text/javascript" src="js/header.js?testNm=3"></script>   
</body>
</html>