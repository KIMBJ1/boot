# boot_miniProject3
## 📚 너의 책은. 📚

+ 🐱 팀원 : 김민준, 김병조, 반철준
+ 🐹 프로젝트 소개 : 네이버 검색 API를 활용한 도서 검색 사이트 구축
+ 💪 소요 기간 : 22/02/23 ~ 22/02/24
+ 🛠️ Tech
  + HTML
  + CSS
  + Javascript

## 🐭 실행 화면
![image](https://user-images.githubusercontent.com/57746855/155629481-3865930a-4078-491d-9f01-2e984cdef5dd.png)
+ 메인 페이지
![127 0 0 1_3000_ (1)](https://user-images.githubusercontent.com/57746855/155629561-2aba7cab-f94e-47a5-95e2-75a380d9232a.png)
+ 검색어(java) 입력 후 페이지 총 10건 검색
![book naver com_bookdb_book_detail nhn_bid=10191151](https://user-images.githubusercontent.com/57746855/155629662-250ab431-e5bf-4b86-8bab-ed6613da4b4b.png)
+ 상세 보기 이후 페이지 이동(새 탭에서 열기)

## 🎨 LightHouse 측정
![image](https://user-images.githubusercontent.com/57746855/155629775-5249fe00-1562-4055-b6dc-8db696ac0b9c.png)
+ Mobile
![image](https://user-images.githubusercontent.com/57746855/155629822-495f4dfa-81fb-4f56-82b4-98a5cdffe083.png)
+ Desktop

## 🐯 Issue
+ html, nodejs, API 간의 통신 메카니즘 개념이 제대로 잡히지 않아 일어나는 이슈들이 많았음
+ 다른 책을 검색하고자 할 때 검색 데이터가 이전 데이터에 이어서 출력되는 이슈 : Search 이벤트 호출마다 결과 데이터 출력 영역을 ''로 초기화
+ 검색어로 한글을 넣었을 때 인식하지 못하는 이슈 : encodeURI 메소드를 이용하여 해결


## 🐻 개선해야 할 점
+ 데이터 갈무리를 좀 더 정갈하게 할 필요 있음
+ 검색 개수를 client가 조정할 수 있었더라면 !
+ aside 영역을 활용하여 날씨, 시계 등의 API를 추가
+ 아무 텍스트를 입력하지 않았을 때의 예외 처리
