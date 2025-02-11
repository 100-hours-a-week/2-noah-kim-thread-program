package lib;

import java.util.InputMismatchException;
import java.util.Scanner;

// 각 함수에 맞는 올바른 자료형을 입력받는지 확인하는 유틸리티 클래스
public class SafeInput {

  private static final Scanner scanner = new Scanner(System.in);

  // 정수 입력 검증 메소드
  public static int getValidInteger(String message) {
    int value;
    while (true) {
      System.out.print(message);
      try {
        value = scanner.nextInt();
        scanner.nextLine();
        return value;
      } catch (InputMismatchException e) {
        System.out.println("잘못된 입력입니다. 정수를 입력해주세요");
      }

    }
  }

  // 문자열 입력 검증 메소드
  public static String getValidString(String message) {
    System.out.print(message);
    return scanner.nextLine();
  }

  // Scanner 객체 종료 (필요시 명시적으로 호출 가능)
  public static void closeScanner() {
    scanner.close();
  }

}
