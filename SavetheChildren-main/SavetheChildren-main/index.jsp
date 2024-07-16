<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="images/logo/shortcut_logo.png">
    <title>세이브더칠드런</title>    
    <!-- css -->
    <link rel="stylesheet" href="css/common.css?after">
    <link rel="stylesheet" href="css/main.css">
    <!-- jquery 불러오기 -->
    <script src="//code.jquery.com/jquery-3.6.1.min.js"></script>
    <!-- slick 불러오기 -->
    <script src="js/slick.min.js"></script>
    <link rel="stylesheet" href="css/slick/slick.css">
    <link rel="stylesheet" href="css/slick/slick-theme.css?after">
</head>
<body>
    <!-- 팝업 창 -->
    <!-- <div class="popup-1">
        <h1>개인 포트폴리오용으로 제작한 사이트입니다.</h1>
        <p>해상도 1920px*1080px 최적화 되어 있습니다.</p>
    </div> -->

    <!-- header -->
    <div>
        <jsp:include page="header.jsp" />
    </div>
    <!-- 본문 -->
    <div class="container">
        <!-- main banner -->
        <div class="main_banner_wrap">
            <div class="banner_wrap">
                <div class="banner_list">
                    <div class="banner ban1"> 
                        <div class="banner_tit">
                            <h1 class="h_tit">2023년 국제 어린이 마라톤</h1>
                            <p class="h_sub_tit"><span>5월 5일, 달리는 것만으로도</span><br/>
                                <span>전 세계 아동에게 든든한 한 끼를 전할 수 있습니다.</span>            
                            </p>
                            <a class="h_link" href="#void">자세히 보기</a>
                        </div>
                    </div>                   
                </div>
                <div class="banner_list">
                    <div class="banner ban2"> 
                        <div class="banner_tit">
                            <h1 class="h_tit">아동권리를 더, 당신과 함께</h1>
                            <p class="h_sub_tit">
                                <span>Save 더 Children 캠페인</span>    
                            </p>
                            <a class="h_link" href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="banner_list">
                    <div class="banner ban3">
                        <div class="banner_tit">
                            <h1 class="h_tit">규모 7.8의 강진으로 무너진<br/> 튀르키예·시리아 아이들을 구해주세요</h1>
                            <p class="h_sub_tit"></p>
                            <a class="h_link" href="#void">자세히 보기</a>
                        </div>
                        <!-- </div> -->
                    </div>
                </div>
                <div class="banner_list">
                    <div class="banner ban4"> 
                        <div class="banner_tit">
                            <h1 class="h_tit">아이를 채우는 한 끼</h1>
                            <p class="h_sub_tit">
                                <span>아픈 엄마가 입원할 때마다
                                혼자 먹는 연수의 컵라면</span>	                                              
                            </p>
                            <a class="h_link" href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>                  
            </div>       
            <div class="main_spon">
                <a href="#void" class="support_btn choice" title="정기후원">
                    <div class="choice_area">정기후원</div>
                </a>
                <a href="#void" class="support_btn" title="일시후원">
                    <div class="choice_area">일시후원</div>
                </a>
                <div class="select_sum">
                    <select class="sel_price" id="sel_01"  name="prices">
                        <option value="write">금액 직접입력</option>
                        <option value="100,000">100,000</option>
                        <option value="50,000">50,000</option>
                        <option value="30,000">30,000</option>
                        <option value="20,000">20,000</option>
                    </select>
                </div>
                <div class="price_input">
                    <input type="text" value="0" name="selectprice" class="prInput">
                    <span>원</span>
                </div>
                <button type="button" class="mainsupport_btn">후원하기</button>
            </div>
        </div>
        <!-- main board 1 -->
        <div class="main_board_storyWrap">
            <div class="title_wrap">
                <h1>나눔이야기</h1>
                <button type="button" class="board_morebtn"></button>
            </div>
            <div class="contents_wrap">
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_1.png" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>  
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_2.jpg" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>          
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_3.jpg" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>          
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_4.jpg" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>          
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_5.jpg" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>          
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_6.jpg" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>          
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_7.jpg" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>          
                <div>
                    <a href="#void">
                        <div class="board_img">
                            <img src="images/nanum/nanum_8.jpg" alt="우크라이나 전쟁">
                        </div>
                        <div class="board_text">
                            <h1>우크라이나 전쟁,긴급구호 1년간의 기록</h1>
                            <p>
                                러시아 군의 우크라이나 공격으로 전쟁이 발생한지 1년이 지났습니다.
                                 1년이 지났음에도 우크라이나에서는 여전히 러시아 군의 폭격이 계속되고 있으며, 
                                 전쟁속에서 아동을 포함한 많은 사람들이 고통에 시달리고 있습니다.
                                 ▲러시아 군의 폭격으로 인해 파괴된 우크라이나 현지의 건물공식 데이터에 의하면, 
                                 지난 1년 동안 우크라이나에서는 총 16,207 건의 공습경보가 발령되었으며, 
                                 아동과 가족들은 지속적인 폭격으로 인하여 최대 8시간까지 지하 대피소에 갇혀 있었던 것으로 알려졌습니다.
                                 전쟁으로 인해 피해를 본 건 군인들 뿐만이 아닙니다. 
                                 UN에 따르면, 러시아-우크라이나 전쟁으로 인하여 현재까지 아동을 포함한 18,657 명의 민간인 사상자가 발생하였다고 합니다.
                            </p>
                        </div>
                    </a>
                </div>                          
            </div>
        </div>
        <!-- main  board 2 -->
        <div class="main_board">
            <div class="board_banner_imgWrap">
                <a href="#void">
                    <img src="images/mainweb_1593480080216.jpg" alt="세이브더칠드런">
                </a>
            </div>
            <div class="board_banner_bottomWrap">
                <div>
                    <a href="#void">
                        <img src="images/mainweb/mainweb_1568857039646.jpg" alt="투명경영">
                    </a>
                </div>
                <div>
                    <a href="#void">
                        <img src="images/mainweb/mainweb_1565231273839.jpg" alt="연차보고">
                    </a>
                </div>
            </div>
        </div>
        <!-- main campaign -->
        <div class="main_campaign_wrap">
            <div class="campaign_list_wrap">
                <div class="campaign_slide on">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_11.jpg" alt="Save One">
                        <div class="campaign_text">
                            <h1>Save One</h1>
                            <p>전 세계의 재난 속 아이들을 구하기 위해
                                <br/>긴급구호 팔찌를 착용해주세요.</p>
                            <a href="#void">팔찌 신청하기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_12.jpg" alt="어린이날 선언문">
                        <div class="campaign_text">
                            <h1>어린이가 쓰는 어린이날 선언문</h1>
                            <p>빨간염소 고티와 함께
                                <br/>아이들의 삶에 티가나는 변화를 만들어주세요.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_13.jpg" alt="빨간염소">
                        <div class="campaign_text">
                            <h1>아프리카에 빨간염소 보내기</h1>
                            <p>빨간염소 고티와 함께
                                <br/>아이들의 삶에 티가나는 변화를 만들어주세요.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_14.jpg" alt="차별없이 잘 키우기">
                        <div class="campaign_text">
                            <h1>차별없이 잘 키우기</h1>
                            <p>궁금했던 내 아이의 말과 행동<br/>
                                말썽번역기를 돌려 확인해보세요</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_15.jpg" alt="아동학대">
                        <div class="campaign_text">
                            <h1>슬픈 기록을 멈추기 위해 아동학대를 기억합니다.</h1>
                            <p>더 이상 고통 받는 아동이 없도록, 함께해 주세요.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_16.jpg" alt="긴급구호아동기금">
                        <div class="campaign_text">
                            <h1>긴급구호아동기금</h1>
                            <p>세이브더칠드런의 인도적지원 활동은<br/>
                                재난 발생 72시간 내에 즉각적으로 이뤄집니다.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_17.jpg" alt="좋아서하는기념일">
                        <div class="campaign_text">
                            <h1>좋아서하는기념일</h1>
                            <p>다양한 기념일을<br/>
                                기부로 기억하는 후원입니다.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_18.jpg" alt="놀이터를 지켜라">
                        <div class="campaign_text">
                            <h1>놀이터를 지켜라</h1>
                            <p>아동의 놀 권리를 함께 지켜주세요.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_slide">
                    <div class="campaign_img">
                        <img src="images/mainweb/mainweb_19.jpg" alt="아동을 살리는 가게">
                        <div class="campaign_text">
                            <h1>아동을 살리는 가게</h1>
                            <p>매장에는 착한가게의 자부심을, 고객들에게는 소비가<br/>
                                나눔이 되는 경험을 선물하는 WE SAVE와 함께 해주세요.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="campaign_btn_wrap">
                    <button class="camaign_btn this" type="button">Save One</button>
                    <button class="camaign_btn" type="button">어린이가 쓰는 어린이날 선언문</button>
                    <button class="camaign_btn" type="button">아프리카에 빨간염소 보내기</button>
                    <button class="camaign_btn" type="button">체벌없이 잘 키우기(말썽번역기)</button>
                    <button class="camaign_btn" type="button">아동학대 아카이브</button>
                    <button class="camaign_btn" type="button">긴급구호아동기금</button>
                    <button class="camaign_btn" type="button">좋아서하는기념일</button>                
                    <button class="camaign_btn" type="button">놀이터를 지켜라</button>                
                    <button class="camaign_btn" type="button">아동을 살리는 가게</button>                
                </div>
            </div>           
        </div>
        <!-- main media board -->
        <div class="main_board_mediaWrap">
            <div class="innerBox">
                <div class="media_list">
                    <div class="media_slide act">
                        <iframe src="https://www.youtube.com/embed/NoM4wGWln10" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
                    </div>
                    <div class="media_slide">
                        <!-- <iframe src="https://www.youtube-nocookie.com/embed/4FPma65_mgY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe> -->
                    </div>
                    <div class="media_slide">
                        <!-- <iframe src="https://www.youtube-nocookie.com/embed/AyaNS05kd0M" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe> -->
                    </div>
                </div>
            </div>
        </div>
        <!-- main sponsorship -->
        <div class="main_sponsorship_wrap">
            <div class="sponsorship_grid">
                <div class="big">
                    <div class="big_wrap">
                        <div class="big_text_box">
                            <h1>정기후원</h1>
                            <p>전 세계 모든 아동, 마지막 한 아동까지 
                                함께합니다.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="small s-1">
                    <div class="small_wrap">
                        <div class="small_text_box">
                            <h1>해외결연후원</h1>
                            <p>결연아동의 성장단계에 맞춰 
                                프로그램을 지원합니다.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="small s-2">
                    <div class="small_wrap"> 
                        <div class="small_text_box">
                            <h1>선물가게</h1>
                            <p>도움이 절실한 아동들에게
                                꼭 필요한 물품을 선물합니다.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="small s-3">
                    <div class="small_wrap"> 
                        <div class="small_text_box">
                            <h1>기업·단체 후원</h1>
                            <p>기업에 맞춘 사회적 책임 실천과
                                사회 공헌 방안을 제공합니다.</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
                <div class="small s-4">
                    <div class="small_wrap">
                        <div class="small_text_box">
                            <h1>고액·유산기부</h1>
                            <p>노블리스 오블리주로서
                                아동의 삶에 더 큰 변화를 만듭니다</p>
                            <a href="#void">자세히 보기</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- main news -->
        <div class="main_news_wrap">
            <div class="news_title">
                <h1>세이브더칠드런<br>소식이<br>궁금하세요?</h1>
                <button type="button" class="news_morebtn"></button>
            </div>
            <div class="news_board_wrap">                  
                <div class="news_board">
                    <span>보도자료</span>
                    <p>세이브더칠드런-HD현대 1%나눔재단,  보호대상아동 양육시설 환경 개선 나서</p>
                    <a class="link" href="#void"></a>
                </div>
                <div class="news_board">
                    <span>보도자료</span>
                    <p>세이브더칠드런, 3일 아동기본법 발의 공동 기자회견 개최</p>
                        <a class="link" href="#void"></a>
                </div>                  
                <div class="news_board">
                    <span>공지사항</span>
                    <p>은행/증권사 점검으로 인한 홈페이지 결제 서비스 중단 안내(5월)</p>
                        <a class="link" href="#void"></a>
                </div>                  
                <div class="news_banner">  <!-- 교육 신청 -->
                    <a href="#void">
                        <img src="images/newsbanner.jpg" alt="newsbanner">
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <div>
        <jsp:include page="footer.jsp" />
    </div>    
    <script>
        document.cookie = "safeCookie1=foo; SameSite=Lax"; 
        document.cookie = "safeCookie2=foo";  
        document.cookie = "crossCookie=bar; SameSite=None; Secure";
    </script> 
    <script src="js/main.js"></script>
</body>  
</html>
