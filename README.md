# 프로젝트 정보 정리

### **사용 데이터**

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
    

### **데이터 전처리**

- Data에서 필요한 feature를 추출 진행
    - 기존 Dataset에 없는 사진이나 가격 정보 등을 추가로 Python을 이용해 크롤링 하여 수집
    - 추천 시스템을 위해 맛 별 데이터를 수집
- 추천 시스템 구축
    - 주종별 다양한 맛 column을 기준으로 Contents Based Filtering을 위해 Python으로 코사인 유사도를 계산하여 가장 맛이 비슷한 상위 5개의 술을 저장함
    - 유저가 높은 평점을 매긴 술을 기준으로 맛의 유사도가 높은 술들을 모아서 제공
    - 평점을 매긴 적이 없는 유저라면 회원가입 시 진행되는 취향 설문을 통해 선호하는 맛에 따른 주류를 추천하여 cold start 문제를 해결함
    
    ### **프로젝트 목표**
    

평소 술을 즐겨마시는 애주가들과 술에 대해 잘 모르는 사람들이 모두 취향에 따라 술을 추천받고 마신 술을 기록하며 커뮤니티에서 소통할 수 있는 서비스를 만들고자 했다.
또한 홈술족의 증가로 집에서 쉽게 구할 수 있는 재료로 주조 능력이 없어도 누구나 간단하게 만들 수 있는 ‘홈텐더’ 서비스로 유저들만의 비법 레시피를 공유할 수 있게 해 누구나 집에서 간편하지만 맛있는 술을 즐기는 것을 목표로 했다.

### **프로젝트 기능 설명**

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

### **프로젝트 한계점**

- 서비스 초반에는 CBF로 유사도 기반 술을 추천한 뒤 유저들의 평가데이터를 충분히 쌓고 CF(협업필터링)을 적용하려 했으나 시간 관계상, 또한 배포 기간이 짧아 충분히 의미있는 리뷰데이터를 얻을 수 없었던 이유로 CBF에 그침
- 또 생각나는 것 추가로 작성

### 사용기술

### FrontEnd

|  | STACK |
| --- | --- |
| Language | JavaScript, HTML5, CSS3 |
| UI Library | ReactJS |
| HTTP Libarary | Axios |
| Linter & Formatter | ESLint, Prettier |

vite, typescript 

### BackEnd

|  | STACK |
| --- | --- |
| Language | Java 11.0.17, Python |
| Framework | Spring Framework (Spring Boot 2.7.9, Spring Security) |
| Data(RDBMS) | JPA/Hibernate, QueryDSL, MySQL, Redis |
| Build Tool | Gradle |
| Library | Pandas, Scikit Learn |
| Infra | AWS, GCP, Jenkins, Docker, Nginx |

**협업툴**

- Git
- Jira
- Notion

### ERD
![erd](https://user-images.githubusercontent.com/42470768/230769762-6f793395-950f-4cbc-a5eb-25dbcbaeeb31.png)



## **프로젝트 진행 기간**

**2023/02/20(월) ~ 2023/04/07(금) (7주)**
SSAFY 8기 2학기 특화프로젝트 빅데이터 추천 트랙

### 역할분담

김호정: [FE]. UI/UX 개발, 피드 및 마이페이지

이예진: [FE] UI/UX 개발, 홈 칵테일 페이지

조한이: [FE] UI/UX 개발, 메인 페이지

남이랑: [BE] 추천 시스템, 술 추천(날씨/취향) API 개발, 사용자 인증/인가

양주연: [BE] 추천 시스템, 피드 및 마이페이지 API 개발

이상원: [BE] 팀장, 발표, CI/CD 자동화, 비로그인 API 개발

### 프로젝트 회고

****김호정****

Typescript 를 처음 사용하며 그 유용성을 조금이나마 이해할 수 있어 굉장히 뜻깊었습니다. 다양한 페이지에서 api 연결을 하고 상태관리를 하며 react 훅에 대한 이해도를 높였으나 처음 목표와는 달리 api 연결이 늦어져 redux를 사용하지 못해 아쉬웠습니다. 또한 오류를 더욱 쉽게 해결하고 애플리케이션의 성능을 개선하기 위해 비동기 처리 순서와 렌더링사이클, 브라우저의 작동 원리에 대한 더 깊은 이해가 필요하다고 느꼈습니다.

****이예진****

****조한이****

****남이랑****

빅데이터라는 특수한 트랙에서 파이썬을 사용해 추천 모델은 만드는 과정이 즐거웠습니다. 웹개발 측면에서 여러가지 시도를 했던 것이 뜻깊었습니다. 이전 프로젝트보다 컨벤션을 지켜 좀 더 짜임새 있는 코드를 구현하고자 했는데 어느 정도는 발전이 있었다고 생각합니다. 

****양주연****

mapstruct와 dto를 사용해 형식을 제대로 갖춘 API 코드를 짜려고 노력한 점이 뜻깊었습니다. JPA와 Querydsl을 사용하면서 발생할 수 있는 여러 에러 사항을 해결하면서 각 기술스택에 대해 한 층 더 깊이 이해하게 된 것 같습니다.

****이상원****

테이블 설계를 제대로 하지 못한 것과 무중단 배포를 적용하지 못한 것, 다수의 중복되는 코드에 대한 아쉬움이 있습니다.
