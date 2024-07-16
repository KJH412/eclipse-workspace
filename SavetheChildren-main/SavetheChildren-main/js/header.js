// document.addEventListener("DOMContentLoaded", function() {
window.onload=function(){
  
  console.log("header Js");
  // header
  const nav = document.querySelector(".nav_list"), //nav>ul
        header = document.querySelector(".stc_header"), //header태그
        navBg = document.querySelector(".nav_sub_bg"), 
        navSub = document.querySelectorAll(".sub"),
        logo = document.querySelector(".logoImg"), //img태그
        loginBtn = document.querySelector(".login_btn"),
        loginTxt = document.querySelector(".loginTxt"),
        searchIcon = document.querySelector(".search_btn"),
        // hamBtn = document.querySelector(".ham_btn"),
        ham = document.querySelector(".ham");
  
  // 네비게이션 바
  function Menu(){
    logo.src="images/logo/logo_on.png";
    header.style.background="#fff";
    loginBtn.style.background="url(images/btn/login_on.png) no-repeat center 10px";
    loginTxt.style.color="#000";
    searchIcon.style.background="url(images/btn/search_on.png) no-repeat center";
    navBg.style.display="block";
    ham.style.background="url(images/btn/gnb_on.png) no-repeat center";
  }
  
  nav.addEventListener("mouseenter",() => {
    Menu();
  });

  function CloseMenu(){
    logo.src="images/logo/logo.png";
    header.style.background="rgba(0,0,0,.5)";
    loginBtn.style.background="url(images/btn/login-active.png) no-repeat center 10px";
    loginTxt.style.color="#fff9d2";
    searchIcon.style.background="url(images/btn/search.png) no-repeat center";   
    navBg.style.display="none";
    ham.style.background="url(images/btn/gnb.png) no-repeat center"
  }
  nav.addEventListener("mouseleave",() => {
    CloseMenu();
  });

  // 로그인 아이콘 클릭 이벤트
  const loginMenu = document.querySelector(".login_menu");
  loginBtn.addEventListener("click",()=>{
    loginMenu.classList.toggle("open");
  });
}
// })
  