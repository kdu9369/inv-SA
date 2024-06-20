import java.util.Random;    // 난수 생성을 위한 클래스
import java.util.Scanner;   // 입력 스트림 및 다양한 입력 소스로부터 데이터를 읽어오기 위한 클래스
import java.util.Arrays;    // 배열 사용을 도와주는 클래스
import java.util.Objects;

// 라이브러리 : 여러 관련 클래스와 패키지의 모음.
// 패키지 : 관련된 클래스의 묶음. (java.util은 라이브러리의 한 부분인 패키지)
// 클래스 : 개별 기능을 수행하는 코드 단위. (java.util.Random은 패키지의 한 부분인 클래스)

public class Main {
    public static void main(String[] args) {

        // 사용될 변수
        int[] randomNumberArray = new int[3];   // 랜덤 숫자 배열
        int randomNumber = 0;   // 사용자 입력 숫자 (과정에서 배열로 변환)
        int num1 = 0;           // 랜덤 숫자 1의 자리
        int num10 = 0;          // 랜덤 숫자 10의 자리
        int num100 = 0;         // 랜덤 숫자 100의 자리
        int[] userNumberArray = new int[3];     // 사용자 입력 숫자 배열
        int userNumber = 0;     // 사용자 입력 숫자 (과정에서 배열로 변환)
        int attempt = 0;        // 시도 횟수 (try를 사용하여 했지만 예약어라서 사용 불가)
        int strike = 0;         // 맞춘 숫자 : 스트라이크
        int ball = 0;           // 틀린 숫자 : 볼

        /* 객체 생성은 한번만 하면 좋다는데 왜그럴까? -> 반복생성하면 메모리 누수 발생 */
        /**
         * 객체 생성 방법
         * 1) 변수 선언과 동시에 생성 : 코드가 짧아서 명확하게 보이고 목적성이 분명해짐
         *  Random 객체를 생성하면서 int형 랜덤 숫자 생성 후 randomNumber에 할당
         *   int randomNumber = new Random().nextInt(999);
         * 2) 객체 생성 후 변수에 할당 : 단계가 드러나기 때문에 이해하기 쉽고 디버깅이 쉬움
         *  Random 객체 생성
         *   Random random = new Random();
         *  int형 랜덤 숫자 생성 후 randomNumber에 할당
         *   int randomNumber = random.nextInt(999);
         */

        Random random = new Random();               // Random 객체 생성
        Scanner scanner = new Scanner(System.in);   // scanner 객체 생성

        num1 = random.nextInt(10);           // nextInt() 메서드를 호출하여 0~9 랜덤 숫자를 생성

        do {
            num10 = random.nextInt(10);      // nextInt() 메서드를 호출하여 0~9 랜덤 숫자를 생성
        } while (num10 == num1);                    // 1의 자리 숫자 = 10의 자리 숫자 같으면 루프반복

        do {
            num100 = random.nextInt(9) + 1;   // nextInt() 메서드를 호출하여 1~9 랜덤 숫자를 생성 (+1 해서 0 방지)
        } while (num100 == num1 || num100 == num10);   // 1의 자리 숫자 = 10의 자리 숫자 = 100의 자리 숫자 같으면 루프반복

        // randomNumber = num100 * 100 + num10 * 10 + num1; // 각 자리의 숫자를 하나의 변수로 합치기
        randomNumberArray[0] = num100;  // 100의자리 숫자, 배열의 [0] 할당
        randomNumberArray[1] = num10;   // 10의자리 숫자, 배열의 [1] 할당
        randomNumberArray[2] = num1;    // 1의자리 숫자, 배열의 [2] 할당

        // System.out.println("#변수확인 num100 : " + num100);
        // System.out.println("#변수확인 num10 : " + num10);
        // System.out.println("#변수확인 num1 : " + num1);
        // System.out.println("#변수확인 randomNumber : " + randomNumber);
        System.out.println("#변수확인 randomNumberArray : " + Arrays.toString(randomNumberArray)); // toString 배열을 한번에 출력하는 메서드
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        // 볼, 스트라이크 판단 (3S 되기 전까지 숫자 입력 -> 숫자 찾기를 반복)



        팀장님 꿀팁
        1) 반복문 : 일단 계속 반복 돌리고
        특정 조건이 만족이 되면 그때서는 탈출! << 요것이 자주쓰는 방법
        2) 배열은 위치가 정해져있다. 하나씩 안넣고 반복문 돌리면 편하고 이쁘고 유연함
                array[i]
                        for (int i = 0; i < userNumberArray.length; i++) {
                            array[i] =
                        }
        3) 쉬프트 + 탭
        4) 모르면 물어보면 빠름

        while (strike < 3) { // "== 3" 초기값이 0이라서 진입 안함/ "<= 3" 같거나라는 조건때문에 완벽한 조건이 되지 못함
            // 사용자 숫자 입력
            System.out.print(attempt + 1 + "번째 시도 : ");    // 카운터는 0부터 시작이니까 +1 해줌으로써 첫회는 1회로 표시되게
            if (scanner.hasNextInt()) {                      // hasNextInt() 메서드로 입력받은 숫자가 정수인지 확인
                userNumber = scanner.nextInt();              // nextInt() 메서드를 호출하여 입력받은 숫자 -> userNumber 변수에 할당
                userNumberArray[0] = userNumber / 100;       // 100의 자리
                userNumberArray[1] = (userNumber / 10) % 10; // 10의 자리
                userNumberArray[2] = userNumber % 10;        // 1의 자리
                System.out.println("#변수확인 userNumberArray : " + Arrays.toString(userNumberArray)); // toString 배열 출력 메서드

                strike = 0;     // 누적된 스트라이크 값 초기화 -> 안하면 숫자가 바뀌어도 이전값이 누적됨
                ball = 0;       // 누적된 볼 값 초기화 -> 안하면 숫자가 바뀌어도 이전값이 누적됨

                // randomNumberArray 와 userNumberArray 비교
                for (int i = 0; i < randomNumberArray.length; i++) {
                    for (int j = 0; j < userNumberArray.length; j++) {
                        if (randomNumberArray[i] == userNumberArray[j]) {
                            if (i == j) {
                                strike++;
                            } else {
                                ball++;
                            }
                        }
                    }
                }

                System.out.println(ball + "B" + strike + "S");  // 볼카운트 표시
                attempt++;                                      // 시도횟수 증가

            } else {
                scanner.next(); // scanner 데이터 삭제 -> 안하면 hasNextInt() 호출 시 남은 데이터로 인해 "무한 루프"
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                attempt++;  // 시도횟수 증가
            }
        }

        // 조건문 성립 (strike < 3) -> 프로그램 종료
        System.out.println(attempt + "번만에 맞히셨습니다."); // 시도횟수 표시
        System.out.println("게임을 종료합니다.");            // 종료 시스템 알림

        scanner.close(); // 명시적으로 스트림(입력 또는 출력)을 닫아줌으로써 메모리 누수 방지

    }
}