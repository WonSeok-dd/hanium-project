# ✈️ 프로젝트 소개
> **빅데이터/AI 기반 스마트 해상물류 챗봇 서비스**
- **스마트 해상물류 경진대회, 팀 멋진코끼리**
- **프로젝트기간** : 2021.03 ~ 2021.12 (10개월)
- **YouTube 요약 영상 링크** : https://www.youtube.com/watch?v=W6aqDtXJLNA
- **학술지** : https://scienceon.kisti.re.kr/srch/selectPORSrchArticle.do?cn=NPAP13484927&dbt=NPAP
- 해상 물류를 위해 화주사, 해운사, 항만운영사, 내륙운송 사업자 등 다양한 이해관계자들이<br> 해상 물류 정보등을 조회하고 선박입출항 및 물동량 데이터등을 확인하기 위해 해운항만물류정보시스템(PORT-MIS)를 활용하는데,<br> 시스템에 미숙한 사용자가  챗봇 서비스를 통해 대화형으로 각종 물류 서비스 정보를 쉽게 획득할 수 있도록 하는 **어플리케이션**

<br> <img src="https://i.esdrop.com/d/igmccyiogpxf/1oiPsiVWrx.jpg" width="225" height="450"/>

<br><br>
# 👉 사전 작업
#### GloVe Featurizer의 사전 임베딩 다운받기
#### GloVe 의 한글 사전 임베딩은 책 "한국어임베딩"의 github에서 가져왔습니다.

아래에서 다운 받을 수 있습니다. <br/>
https://drive.google.com/drive/folders/1K_pMeDTOYs2oiBN5g_0pXRH6ar_0RyaJ?usp=sharing{:target="_blank"}

walrus_chabot 디렉토리 내에서 glove.txt 파일을 아래 경로에 두어야 합니다.
./custom/gloVe_featurizer/model/glove.txt

<br><br>
# 📄 프로젝트 흐름도
![image](https://user-images.githubusercontent.com/75558861/214327813-44d105d5-d813-45dd-87e6-1e89d5087aa2.png)

<br><br>
# 🛠 개발 환경
> ![Java](https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white)
> ![Android](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)
> <br>
> ![JavaScript](https://img.shields.io/badge/JavaScript-323330?style=for-the-badge&logo=javascript&logoColor=F7DF1E)
> ![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white)
> <br>
> ![Python](https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white)
> ![Rasa](https://img.shields.io/badge/rasa-5A17EE?style=for-the-badge&logo=rasa&logoColor=white)
> <br>
> ![AWS](https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white)

<br><br>
# 🔍 사용 방법
<!--Table-->
|기능|설명|어플 화면|
|:------:|------|------|
|**대화형 정보 제공 서비스<br/>(CHAT-BOT)**|<U>**선박입출항 현황 정보 제공:**</U><br/>[항명 ,선명, 호출부호, 외내, 입출, 총 톤수, 입출항 일시, 국적, 선박용도] 정보를 대화형으로 제공<br/>대화 스토리 진행 순서:<br/>1. 사용자가 시설사용허가현황 정보 요청 질문<br/>2. 사용자 질문에서 날짜와 항구 추출<br/>3. 질문에 날짜 또는 항구가 없을 시 해당사항 재요청<br/>4. 해당 날짜의 시설사용허가현황 정보 제공<br/><br/><br/><br/><U>**시설사용허가현황 제공:**</U><br/>[항명, 선명, 총 톤수, 입항 횟수, 선사/대리점, 신청일시, 허가유무]를 대화형으로 제공<br/>대화 스토리 진행 순서:<br/>1. 사용자가 시설사용허가현황 정보 요청 질문<br/>2. 사용자 질문에서 날짜와 항구 추출<br/>3. 질문에 날짜 또는 항구가 없을 시 해당사항 재요청<br/>4. 해당 날짜의 시설사용허가현황 정보 제공|<img src="https://i.esdrop.com/d/igmccyiogpxf/Zlp8DP1ICh.jpg" width="250" height="500"/><img src="https://i.esdrop.com/d/igmccyiogpxf/dNL368Pu6R.jpg" width="250" height="500"/>|
|**사용료 계산**|<U>**사용료 계산:**</U><br/>[선박료, 화물료 연체료] 계산<br/>대화 스토리 진행 순서:<br/>1-1. 사용자가 사용료 계산 요청<br/>1-2. 버튼으로 선박료/화물료/연체료 선택<br/>1-3. 선택된 버튼에 따라서 사용료 계산<br/>2-1. 사용자가 선박료/화물료/연체료 계산 요청<br/>2-2. 사용자 질문에서 어떤 사용료인지 추출<br/>2-3.  해당 사용료 계산|<img src="https://i.esdrop.com/d/igmccyiogpxf/w7JAGI5PFJ.jpg" width="250" height="500"/>|
|**항만 날씨 위젯**|1. 주요 항구(부산/여수/포항/인천) 실시간 날씨 및 기상센서정보를 제공<br/>2. 사용자가 해당 항구의 Radio Button 체크하면 습도,풍향,풍속,기온 정보를 한눈에 확인 할 수 있음|<img src="https://i.esdrop.com/d/igmccyiogpxf/1oiPsiVWrx.jpg" width="250" height="500"/>
|**항구/항만 관련 News**|1. 항구 및 항만 관련 최신 기사 및 뉴스 리스트를 제공<br/>2. 관심 기사 선택 시 WebView로 해당 기사 및 뉴스에 접근 가능|<img src="https://i.esdrop.com/d/igmccyiogpxf/K1Wihvu9ge.jpg" width="250" height="500"/>
|**공지사항**|1. 주요 항만공사 웹사이트의 공지사항 리스트를 제공<br/>2. 해당 공지사항 선택시 WebView로 해당 공지사항에 접근 가능|<img src="https://i.esdrop.com/d/igmccyiogpxf/Qi5RVYpkTu.jpg" width="250" height="500"/>
|**음성인식 서비스<br/>(CHAT-BOT)**|<U>대화형 정보 제공서비스:</U><br/>1. 챗봇 서비스 이용 시 텍스트 입력 대신 음성인식을 통하여 텍스트로 전환하여 모바일 환경에 익숙하지 않은 사용자도 서비스 이용 가능|<img src="https://i.esdrop.com/d/igmccyiogpxf/9dd5NcezM1.JPG" width="250" height="500"/>

<br><br>
# 👩‍💻 기능 설계
## 1️⃣ RASA 오픈소스

   **가.** 챗봇의 종류
   
     - 열린 대화 구조: 어떤 질문이든 답할 수 있도록 열려 있는 구조를 기반으로 하는데, 
                      분명히 챗봇이 대답하지 못하는 것이 나올 수 있다는 것을 염두해야 한다. 
     - 닫힌 대화 구조: 원하는 목적지까지 갈 수 있도록 계속 가이드를 해주는 구조이다. 
                      버튼/선택형으로 구조를 설계해 대화를 이어 나가는 닫힌 구조의 챗봇은 룰 베이스(Rule-base) 챗봇, 시나리오형 챗봇이라고도 한다.

   **나.** FAQ형 챗봇 사용
   
     - FAQ형 챗봇은 시나리오 기반(룰베이스)과 지능형 대하 기반(인공지능) 두 가지를 혼합하여 만든 챗봇이다
     - 사용자가 버튼을 눌러가면서 답을 찾을 수 있도록 제안하는 방식의 ‘룰베이스(Rule Base)’와 사용자가 채팅하여 
       질문하면 답변을 제공하는 자연어 처리 방식의 지능형 대화’를 하나의 챗봇에 담았다.
   
   **다.** RASA의 구성
   
 ![image description](https://i.esdrop.com/d/igmccyiogpxf/W7gqi1YjWB.JPG)

<br/>

## 2️⃣ 필요 데이터 요청 

     - /api/portuse: 해운항만물류시스템-Portmis에서 제공하는 API 서버로 부터 POST요청을 통하여
                     시설사용허가현황 데이터를 수집후 정제하여 JSON형식으로 데이터를 제공  
     - /api/inout: 해운항만물류시스템-Portmis에서 제공하는 API 서버로부터 POST요청을 통하여 
                   선박입출항정보 데이터를 수집후 정제하여 JSON형식으로 데이터를 제공
     - /news : 네이버 뉴스 탭에서 항만 관련 뉴스를 크롤링 후 정제하여 JSON형식으로 데이터를 제공
     - /notice : 주요 항만공사(울산,부산,인천,여수) 사이트의 공지사항에서 크롤링 후 정제하여 JSON형식으로 데이터를 제공
     - /weather : 네이버 주요 항만(울산,부산,인천,여수) 날씨를 크롤링 후 정제하여 JSON형식으로 데이터를 제공

<br><br>
# 👥 멤버
|이름|담당 업무|
|:------:|--------------|
|박상준|RASA 챗봇 설계, 환경 개발 및 유지 보수|
|최용태|RASA 챗봇 설계, 환경 개발 및 유지 보수|
|이윤표|RASA 챗봇 설계, Android Application 개발|
|정원석|Data Crawling, API 서버 구축, Android Application 개발|
|홍진원|Data Crawling, API 서버 구축, Android Application 개발|
