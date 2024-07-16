// window.onload=function(){
    console.log("footer JS");
    
    // footer
    const fBtn = document.querySelector(".family>.link_btn>button");
    const gBtn = document.querySelector(".global .link_btn");
    const global = document.querySelector(".global .link_list");
    const family = document.querySelector(".family .link_list");
    console.log(fBtn);
    fBtn.addEventListener("click",()=>{
        family.classList.toggle('on');
    });
    gBtn.addEventListener("click",()=>{
        global.classList.toggle('on');
    });    
// }


