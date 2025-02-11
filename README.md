## 과제 설명

CLI 프로그램 제작 (동기 프로그램)
* 콘솔 형태의 프로그램은 어떠한 종류라도 상관 없습니다.
- 예시 [링크](https://www.youtube.com/watch?v=EKy4m5FxhjE)

* 과제는 다음 순서대로 진행을 합니다.

1. 프로그램 클래스 설계도(다이어그램) 작성하기

1.1 속성, 메서드, 상속의 관계를 먼저 정의 합니다.
- 예시 [링크](https://blog.kakaocdn.net/dn/KKHyA/btrb7uJR0y0/fCTJikYRHAQWhJP5yA3x00/img.png)
  `(만약 어렵다면 사람 클래스부터 해보세요. 조부모 클래스, 부모 클래스, 자식클래스 3개 클래스로 작성을 먼저 해보세요)`

1.1.1 2차 상속은 최소 하나가 있으면 좋겠습니다.

`* UML 프로그램 사용 금지, 손으로 그리세요! 
이유: 툴 학습법 익힐 시간 없음 
제출은 사진찍어 제출하시면 됩니다.`

2. 설계도 기반 콘솔 프로그램 제작
   2.1 사용자에게 입력을 받고 진행이 되는 형태가 되어야 합니다.

## 설계

[주제]

IT 스타트업 대표인 noah는 회사에 필요한 인원과 함께할 때 필요한 팀원들의 연봉을 계산해보기 위해 프로그램을 제작하고 있다.

noah가 생각했을때 필요한 직군은 다음과 같다. (각 직군별로 1명씩 배정)

- PM (Product employees.manager)

- Frontend employees.marketer
- Backend employees.marketer
- DevOps employees.marketer
- UI/UX employees.web
- Quality Assurance (employees.web.dev.QA)

- Marketing Specialist
- Finance employees.manager

noah는 직군에 맞는 연봉을 고르기 위한 다음과 같은 프로그램을 제작하기로 하였습니다.

Finance Manger

1. 각 직군별로 가능한 연봉 리스트를 입력합니다.

Noah

1. Finance Manager가 제공한 연봉 리스트를 토대로 각 직군의 연봉을 선택합니다.
2. 모든 직군의 연봉을 선택한 이후, 전체 연봉을 계산하여 noah에게 제공합니다.
3. noah가 특정 직군의 연봉을 재선택 할수있는 기회를 제공합니다.
4. noah가 선택을 완료하면, 총 연봉과 응원 문구를 출력합니다.

### 입력

1. Finance Manager로부터 각 직군별 가능 연봉 입력받기
    
    예외 처리
    
    - 숫자가 아닌 입력값 (재입력 요청)
    - 정수가 아닌 숫자
    - 연봉 범위를 벗어난 숫자 (3천 ~ 1억)
2. 각 직군별로 주어진 연봉에서 연봉을 선택하기
    
    예외 처리
    
    - 주어진 연봉 선택지 중에 선택하지 않는 경우 (OutofBound)

### 출력

1. 각 직군별 연봉 선택지
2. 연봉의 총 합

### 클래스 다이어그램(설계)

![classDiagram](https://github.com/user-attachments/assets/4b39d7e8-ea4e-44a9-8fdf-c6175cb7d170)


### 실행 결과 영상

![GIFMaker_me](https://github.com/user-attachments/assets/afa5c0cc-ec99-497b-a0b0-fd75a67119e0)



TODO List
- 추상 클래스 구현

