## 자동차 경주 게임 설계

### 패키지 구조

```bash
|- domain
    |- gameservice
    |- racingcarservice
      |- CarService
      |- Cars
      |- Car
      |- CarName
      |- Position
|- ui
    |- controller
      |- Application
      |- GameController
    |- interfaces
      |- InputView
      |- OutputView
    |- view
      |- ConsoleInputView
      |- ConsoleOutputView
|- utils
  |- RandomNumberUtil
```

<br>

### 테스트 해볼 항목

1. 자동차의 이동
   - 입력받은 전략에 따라 이동하는가?
2. 자동차 이름 검증
   - 5자 이하일때만 생성이 되는가
   - 5자 초과면 에러 메세지를 발생시키나?
3. 반복 회수 검증
   - 숫자가 아닌 값이 들어올 경우 익셉션을 발생 시키는가?

<br>

### 구동 과정

1. 사용자가 앱을 실행 시킨다.
2. Game Controller 가 실행된다.
   - GameService 객체가 생성된다.
   - InputView를 통해 자동차 이름과 반복횟수를 입력받는다.
   - 자동차 이름과 반복 횟수를 멤버변수로 설정한다.
3. GameService에서 반복 횟수만큼 CarService의 게임 실행 메서드를 실행한다.
   - Strategy를 인자로 받아 동작하도록 한다.
   - Strategy에 따라 자동차는 이동하던지 멈춘다.
4. GameService에서 각 회차에 따른 결과를 반환 Controller에게 넘겨줘서 출력한다.
5. CarGameService를 통해 결과를 받아와서 출력하고 게임을 종료한다.
   

### 코딩 컨벤션

- 원시값들을 포장할 것.
- 일급 컬렉션을 사용할 것.