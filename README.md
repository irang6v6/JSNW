# 🍹 **주상낙원 - 취향 기반 술 추천 및 레시피 공유 커뮤니티 서비스** 

<br>

## 💡 **주상낙원 소개**
- 평소 술을 즐겨마시는 애주가들과 술에 대해 잘 모르는 사람들 모두 취향에 따라 술을 추천받고 마신 술을 기록하며 커뮤니티에서 소통할 수 있는 서비스.
- 또한 유저들만의 커스텀 칵테일 레시피를 공유할 수 있게 해 누구나 집에서 간편하지만 맛있는 술을 즐길 수 있도록 함.

<br>

## 📅 **프로젝트 진행 기간**

**2023/02/20(월) ~ 2023/04/07(금) (7주)**
SSAFY 8기 2학기 특화프로젝트

<br>

## 💻 **프로젝트 기능 설명**

1. **술 추천**
- 다양한 주종별(와인,맥주,위스키,칵테일,전통주) 술 정보, 인기 순위 제공
- 사용자 취향을 기반으로 Contents Based Filtering 을 이용한 술 추천 시스템
- 사용자 커스텀 칵테일 신규 등록 및 추천 기능
- 기상청 공공 API를 이용한 재미있는 날씨별 술 추천

1. **커뮤니티**
- 게시글, 댓글을 이용한 다른 사용자들과의 소통

1. **주류 정보 제공**
- 주종별 입문자 가이드로 유저가 낯선 주종에도 쉽게 유입될 수 있도록 함

1. **유저 기능**
- 카카오, 구글 간편 소셜로그인 기능
- 캘린더에서 유저의 리뷰를 분석해 날짜마다 마신 술을 달력에 이모지로 보여줌

<br>

### **프로젝트 한계점**

- 서비스 초반에는 CBF로 유사도 기반 술을 추천한 뒤 유저들의 평가데이터를 충분히 쌓고 CF(협업필터링)을 적용하려 했으나 시간 관계상, 또한 배포 기간이 짧아 충분히 의미있는 리뷰데이터를 얻을 수 없었던 이유로 CBF에 그침

<br>

### **사용한 데이터 출처**

1. 와인
WINE21 크롤링
    
    [전체와인 - 와인21닷컴](https://www.wine21.com/13_search/wine_list.html)
    
2. 위스키
Kaggle Whisky Dataset
    
    [Scotch Whisky Dataset](https://www.kaggle.com/datasets/koki25ando/scotch-whisky-dataset)
    
3. 전통주
네이버 전통주 지식백과 크롤링
    
    [traditional-liquor-RS/traditional_liquor_df_final.csv at main · learning-human/traditional-liquor-RS](https://github.com/learning-human/traditional-liquor-RS/blob/main/traditional_liquor_df_final.csv)
    
4. 맥주
BeerRate
    
    [https://github.com/quipu1/Bear-Recommendation](https://github.com/quipu1/Bear-Recommendation)
    

1. 칵테일
**Cocktail Wheel Dataset**
    
    [](http://dachang.github.io/CocktailViz/cocktailWheel.JSON)
    
2. 커스텀레시피
만개의 레시피 무료 레시피 Dataset
    
    [KADX 농식품 빅데이터 거래소](https://kadx.co.kr/product/detail/0c5ec800-4fc2-11eb-8b6e-e776ccea3964)
    
<br>

### **데이터 전처리**

- Data에서 필요한 feature를 추출 진행
    - 기존 Dataset에 없는 사진이나 가격 정보 등을 추가로 Python을 이용해 크롤링 하여 수집
    - 추천 시스템을 위해 맛 별 데이터를 수집
- 추천 시스템 구축
    - 주종별 다양한 맛 column을 기준으로 Contents Based Filtering을 위해 Python으로 코사인 유사도를 계산하여 가장 맛이 비슷한 상위 5개의 술을 저장함
    - 유저가 높은 평점을 매긴 술을 기준으로 맛의 유사도가 높은 술들을 모아서 제공
    - 평점을 매긴 적이 없는 유저라면 회원가입 시 진행되는 취향 설문을 통해 선호하는 맛에 따른 주류를 추천하여 cold start 문제를 해결함

<br>

## 📃 **API 명세서**
<img width="70%" src="https://user-images.githubusercontent.com/52191425/230813396-4e72a078-794b-49d8-83fb-10456af6e0ac.png"/>

[API 명세서 노션 링크](https://oil-badge-a9f.notion.site/API-a992c465bc474ba0bb068f8dee68b6e5)

<br>

## 🏗️ **아키텍처**

<img width="70%" src="https://user-images.githubusercontent.com/52191425/230812435-c87806c1-d925-42de-9f89-ee99de5dc293.png"/>


<br>

## 🛠️ **기술 스택**

### **FrontEnd**

|  | STACK |
| --- | --- |
| Language | TypeScript, HTML5, CSS3 |
| UI Library | ReactJS |
| HTTP Libarary | Axios |
| Linter & Formatter | ESLint, Prettier |

vite, typescript

<br>

### **BackEnd**

|  | STACK |
| --- | --- |
| Language | Java 11.0.17, Python |
| Framework | Spring Framework (Spring Boot 2.7.9, Spring Security) |
| Data(RDBMS) | JPA/Hibernate, QueryDSL, MySQL, Redis |
| Build Tool | Gradle |
| Library | Pandas, Scikit Learn |
| Infra | AWS, GCP, Jenkins, Docker, Nginx |

<br>

**협업툴**

- Git
- Jira
- Notion

<br>

## 🗃️ ERD

<img width="70%" src="https://user-images.githubusercontent.com/52191425/230811037-5a8575b1-1ad2-47ee-813a-47eb125b1389.png"/>

<br>

## 👥 역할분담

김호정: [FE]. UI/UX 개발, 피드 및 마이페이지

이예진: [FE] UI/UX 개발, 홈 칵테일 페이지

조한이: [FE] UI/UX 개발, 메인 페이지

남이랑: [BE] 추천 시스템, 술 추천(날씨/취향) API 개발, 사용자 인증/인가

양주연: [BE] 추천 시스템, 피드 및 마이페이지 API 개발

이상원: [BE] 팀장, 발표, CI/CD 자동화, 비로그인 API 개발

<br>

## 프로젝트 회고

**김호정**
<br>
Typescript 를 처음 사용하며 그 유용성을 조금이나마 이해할 수 있어 굉장히 뜻깊었습니다. 다양한 페이지에서 api 연결을 하고 상태관리를 하며 react 훅에 대한 이해도를 높였으나 처음 목표와는 달리 api 연결이 늦어져 redux를 사용하지 못해 아쉬웠습니다.

또한 오류를 더욱 쉽게 해결하고 애플리케이션의 성능을 개선하기 위해 비동기 처리 순서와 렌더링사이클, 브라우저의 작동 원리에 대한 더 깊은 이해가 필요하다고 느꼈습니다.

**이예진**
<br>
비전공자 3인이 프론트를 담당하게 되면서 걱정도 있었지만 처음 계획했던 프로토타입 그 이상으로 결과물을 낼 수 있어 의미가 있었다고 생각합니다. redux를 고려하지 못한채로 로직을 짰을 때와 redux를 사용했을 때에 코드 양이 확연히 줄어들고 로직이 클린해지는 것을 느끼면서 간단한 부분이었지만 redux의 사용성을 느낄 수 있었습니다.

이번 프로젝트에서 처음으로 경험한 typescript는 초반에는 불편함을 느꼈지만, 나중에는 type을 선언한 후에 typescript가 잡아주는 오류 덕분에 api로 받는 데이터의 형태나 props 되는 변수명에서 발생되는 혼선이 줄어드는 편리성을 느낄 수 있었습니다.

아쉬웠던 점은 빅데이터 특성계획했던 것보다 데이터 가공과 api 연결이 늦어지면서 component 재사용성을 고려한 리팩토링이나 성능개선 단계까지 도달하지 못했다는 점입니다.

**조한이**
<br> 
타입스크립트를 처음 사용해보는 거라 걱정이 많았지만, 컴파일 시 타입 체크가 이루어져 런타임 에러를 미리 방지하고 코드의 안정성을 높일 수 있어서 좋은 점이 많다는 것을 느꼈습니다. 하지만 익숙하지 않은 규칙과 문법으로 코드 작성 시 어려움을 느꼈던 부분도 있었습니다. 또한 API 연결과 동기/비동기 처리에 대한 이해가 부족하다는 것을 느꼈습니다. 

axios나 fetch api를 사용하여 api를 호출하고 응답을 처리하는 방법을 더욱 학습해야 할 필요성을 느꼈고, 동기/비동기 처리에 대해서도 콜백, 프로미스, async, await에 대해 더 공부해야겠다고 생각했습니다. 다음 프로젝트에서는 이러한 부분들을 보완해서 좀 더 안정적이고 가독성 높은 코드를 작성하기 위해 노력해야할 것 같습니다.

**남이랑**
<br>
빅데이터라는 특수한 트랙에서 파이썬을 사용해 추천 모델은 만드는 과정이 즐거웠습니다. 웹개발 측면에서 여러가지 시도를 했던 것이 뜻깊었습니다. 이전 프로젝트보다 컨벤션을 지켜 좀 더 짜임새 있는 코드를 구현하고자 했는데 어느 정도는 발전이 있었다고 생각합니다. 

**양주연**
<br>
mapstruct와 dto를 사용해 형식을 제대로 갖춘 API 코드를 짜려고 노력한 점이 뜻깊었습니다. JPA와 Querydsl을 사용하면서 발생할 수 있는 에러 사항을 해결하면서 각 기술스택에 대해 한 층 더 깊이 이해하게 된 것 같습니다. 데이터베이스를 몽고DB에서 MySQL로 마이그레이션하게 되면서 API 연결이 늦어지게 되어 프론트와 협업이 촉박하게 이루어졌던 점이 아쉬웠습니다.

**이상원**
<br>
테이블 설계를 제대로 하지 못한 것과 무중단 배포를 적용하지 못한 것, 다수의 중복되는 코드에 대한 아쉬움이 있습니다.
