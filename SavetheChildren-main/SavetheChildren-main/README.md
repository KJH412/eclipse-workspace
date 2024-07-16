# SavethieChildren : 세이브더칠드런 웹
## 프로젝트 설명

### :bulb:선택한 이유
Slick-slider 플러그인 사용, 유튜브 영상 삽입, 그리드 등 웹 페이지를 구성하는 기본적인 기능을 경험해 볼 수 있을 것 같아 선택했습니다.

### :calendar: 기간
2023.5 마크업 및 스타일, 동작 구현 약 1주(5일)

### 개발환경
- HTML5, CSS3
- Javascript, jQuery
- JSP
- VSCode
- Tomcat

### :tv: 웹사이트 시연 영상
- 메인페이지 : <a href="https://www.youtube.com/embed/idH5S7thS58">시연 영상</a>

## :mag: 기능 설명
### 1.메인페이지
![nav1](https://user-images.githubusercontent.com/108113992/236616909-75b217a4-e79e-444b-b028-0b5ae2e43897.png)
![nav](https://user-images.githubusercontent.com/108113992/236616415-7a7256af-81bc-454e-86a7-e623dc563e1c.png)
- Header의 네비게이션 메뉴는 hover가 아닌 mouse이벤트로 동작시켰습니다.
- Header와 Footer의 파일을 분리해서 jsp를 활용해 페이지를 include 하였습니다.

![option](https://user-images.githubusercontent.com/108113992/236616446-0263e7d1-6a59-471a-aa3a-5be0935faf43.png)
- javascript를 사용해 원하는 금액을 선택하면 입력 창에 선택된 금액의 숫자가 나타나도록 만들었습니다.

![grid](https://user-images.githubusercontent.com/108113992/236616545-1a4f4c59-9d9d-4cda-be5b-8ed3142f3b4e.png)
- 그리드 레이아웃을 기존 사이트에선 float을 사용했지만 새로 만들어 보면서 display grid를 사용해 레이아웃을 배치했습니다.



## 아쉬웠던 점
- 처음에는 javascript로 header와 footer를 분리하여 재사용하려 했지만 script 파일만 로드되지 않는 문제로 어려움을 겪었고 
결국 jsp를 활용해 include 하는 방식으로 사용했습니다.
- slick 플러그인를 처음 사용해서 화살표, 버튼 등 커스텀 할 때 시간이 오래 걸린 것과 더 깔끔하고 효율성 있는 코드로 작성하지 못 한 것이 아쉽습니다. 
- 현재는 메인 페이지뿐이지만 로그인, 회원가입, 금액 후원 기능을 추가로 만들고 싶습니다.

## 느낀점
VSCode로 Tomcat을 연결하고 환경설정을 하는 것이 처음이라 오래 걸렸지만 서버를 연결하고 구현된 화면을 봤을 때 뿌듯했습니다.
기존 페이지와 100% 완벽히 구현하지 못했지만 사용해 보지 못했던 기능과 구성으로 페이지를 만들 수 있어서 많은 공부가 되었던 프로젝트였습니다.
