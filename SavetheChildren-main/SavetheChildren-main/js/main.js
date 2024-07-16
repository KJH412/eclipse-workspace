/* Main Banner Slide */
$( document ).ready(function() {
    $('.banner_wrap').slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 5000,
        infinite : true,
        dots:true,
        fade:true
    });           
    $('.contents_wrap').slick({
        slidesToShow: 5,
        slidesToScroll: 5,
        responsive: [ 
            { 
                breakpoint: 1680, 
                settings: {	
                    slidesToShow:4, 
                    slidesToScroll: 1
                } 
            },
            {  
                breakpoint: 1380, 
                settings: {
                    slidesToShow:3,
                    slidesToScroll: 1
                } 
            },
            {  
                breakpoint: 1000, 
                settings: {
                    slidesToShow:2,
                    slidesToScroll: 1
                } 
            }
        ]
    })


/* Main Banner Support Button */
const supportBtn = $(".support_btn");
let idx = 0;
function support(){
    supportBtn.removeClass('choice');
    supportBtn.eq(idx).addClass('choice');
}
supportBtn.on({
    click:function(){        
      let tg = $(this);
      let i = tg.index();

      if(i == idx){ return }
      idx = i;
      support();
    }
}) 

/* Price Select Input */
const selectEl = document.getElementById("sel_01");
const inputPr = document.querySelector(".prInput");

function updateInputValue() {
    if (selectEl.value === "write") {
      // "금액 직접입력"을 선택한 경우, input 요소의 값을 0으로 설정.
      inputPr.value = "0";
    } else {
      // 다른 옵션을 선택한 경우, 해당 값을 input 요소의 값으로 설정.
      inputPr.value = selectEl.value;
    }
  }
  selectEl.addEventListener("change", updateInputValue);


/* Main Canmpain Banner */
let currentIndex = 0;

const cpBtn = $(".campaign_btn_wrap>button");
// const cpList = $(".campaign_list_wrap");
const cpSlide = $(".campaign_slide");

function cpBanner(){
    cpSlide.removeClass('on');
    cpSlide.eq(currentIndex).addClass('on');
    
    cpBtn.removeClass('this');
    cpBtn.eq(currentIndex).addClass('this');
}

cpBtn.on({
    mouseenter:function(){
        let target = $(this);
        let i = target.index();

        if(i == currentIndex){ return }
        currentIndex = i;
        cpBanner();
    }
});

const pageTop = $(".pageTop_btn>button");
pageTop.on({
    click:function(){
        window.scrollTo({top:0, behavior:'smooth'});
    }
})

});