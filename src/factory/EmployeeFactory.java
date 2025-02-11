package factory;

import employees.Employee;
import employees.manager.Manager;
import employees.marketer.Marketer;
import employees.web.Designer;
import employees.web.dev.Backend;
import employees.web.dev.Devops;
import employees.web.dev.Frontend;
import employees.web.dev.QA;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeFactory {

  // 역할에 따라 객체를 생성하는 메서드
  public static Employee createEmployee(String role, Scanner scanner) {
    System.out.println("📌 " + role + " 정보를 입력하세요.");

    // ✅ 공통 필드 입력 받기
    System.out.print("💰 급여: ");
    int salary = scanner.nextInt();
    System.out.print("⌛ 경력 (년): ");
    int experienceYears = scanner.nextInt();
    scanner.nextLine(); // 개행 문자 처리

    switch (role) {
      case "Manager":
        return createManager(scanner, salary, experienceYears, role);
      case "Frontend Developer":
        return createFrontend(scanner, salary, experienceYears, role);
      case "Backend Developer":
        return createBackend(scanner, salary, experienceYears, role);
      case "DevOps Developer":
        return createDevops(scanner, salary, experienceYears, role);
      case "UI/UX Designer":
        return createDesigner(scanner, salary, experienceYears, role);
      case "Quality Assurance":
        return createQA(scanner, salary, experienceYears, role);
      case "Marketing Specialist":
        return createMarketer(scanner, salary, experienceYears, role);
      default:
        throw new IllegalArgumentException("Unknown role: " + role);
    }
  }

  private static Manager createManager(Scanner scanner, int salary, int experienceYears,
      String role) {
    System.out.print("📜 전문 분야: ");
    String domain = scanner.nextLine();

    System.out.print("🎯 리더십 레벨 (1~10): ");
    int leadershipLevel = scanner.nextInt();

    System.out.print("📊 의사 결정 능력 (1~10): ");
    int decisionMakingLevel = scanner.nextInt();
    scanner.nextLine();

    return new Manager(salary, experienceYears, role, domain, leadershipLevel,
        decisionMakingLevel);
  }

  private static Marketer createMarketer(Scanner scanner, int salary, int experienceYears,
      String role) {
    // #1. 공통 필드
    System.out.print("📜 사용가능 언어 (띄어쓰기 구분): ");
    List<String> languageSkills = Arrays.asList(scanner.nextLine().split(""));

    System.out.print("💡️ 창의력 (1~10): ");
    int creativityLevel = scanner.nextInt();

    System.out.print("🗣️ 설득 능력 (1~10): ");
    int persuasionLevel = scanner.nextInt();

    return new Marketer(salary, experienceYears, role, languageSkills, creativityLevel,
        persuasionLevel);
  }

  private static Designer createDesigner(Scanner scanner, int salary, int experienceYears,
      String role) {
    System.out.print("🐺 애니메이션 구현 능력 (1 ~ 10): ");
    int animationLevel = scanner.nextInt();

    System.out.print("🧑‍🧒️ UI/UX 능력 (1~10): ");
    int UIUXLevel = scanner.nextInt();
    scanner.nextLine();

    System.out.print("🗣️ 사용가능한 디자인 툴 (띄어쓰기로 구분): ");
    List<String> designTools = Arrays.asList(scanner.nextLine().split(" "));

    return new Designer(salary, experienceYears, role, animationLevel, UIUXLevel, designTools);
  }

  private static Frontend createFrontend(Scanner scanner, int salary, int experienceYears,
      String role) {
    // #1. 공통 필드
    System.out.print("📜 전문 분야: ");
    String domain = scanner.nextLine();

    System.out.print("🎙️ 커뮤니케이션 레벨 (1~10): ");
    int communationLevel = scanner.nextInt();
    scanner.nextLine(); // 개행 문자 제거

    System.out.print("🖱️ 사용가능 스택 (띄어쓰기 구분): ");
    List<String> stacks = Arrays.asList(scanner.nextLine().split(" "));

    // #2. 개별 필드
    System.out.print("📜 CSS 레벨 (1~10): ");
    int cssLevel = scanner.nextInt();

    System.out.print("️🧪 테스팅 레벨 (1~10): ");
    int testinglevel = scanner.nextInt();

    return new Frontend(salary, experienceYears, role, domain, communationLevel, stacks, cssLevel,
        testinglevel);
  }

  private static Backend createBackend(Scanner scanner, int salary, int experienceYears,
      String role) {
    // #1. 공통 필드
    System.out.print("📜 전문 분야: ");
    String domain = scanner.nextLine();

    System.out.print("🎙️ 커뮤니케이션 레벨 (1~10): ");
    int communationLevel = scanner.nextInt();
    scanner.nextLine();

    System.out.print("🖱️ 사용가능 스택 (띄어쓰기로 구분): ");
    List<String> stacks = Arrays.asList(scanner.nextLine().split(" "));

    // #2. 개별 필드
    System.out.print("㏈ 데이터베이스 레벨 (1~10): ");
    int databaseLevel = scanner.nextInt();

    System.out.print("🔒️ 보안 레벨 (1~10): ");
    int securityLevel = scanner.nextInt();

    return new Backend(salary, experienceYears, role, domain, communationLevel, stacks,
        databaseLevel,
        securityLevel);
  }

  private static Devops createDevops(Scanner scanner, int salary, int experienceYears,
      String role) {
    // #1. 공통 필드
    System.out.print("📜 전문 분야: ");
    String domain = scanner.nextLine();

    System.out.print("🎙️ 커뮤니케이션 레벨 (1~10): ");
    int communationLevel = scanner.nextInt();
    scanner.nextLine();

    System.out.print("🖱️ 사용가능 스택 (띄어쓰기로 구분): ");
    List<String> stacks = Arrays.asList(scanner.nextLine().split(" "));

    // #2. 개별 필드
    System.out.print("🔃 CICD 레벨 (1~10): ");
    int CICDLevel = scanner.nextInt();

    System.out.print("☁ 클라우드 레벨 (1~10): ");
    int cloudPlatformLevel = scanner.nextInt();

    return new Devops(salary, experienceYears, role, domain, communationLevel, stacks,
        CICDLevel,
        cloudPlatformLevel);
  }

  private static QA createQA(Scanner scanner, int salary, int experienceYears, String role) {
    // #1. 공통 필드
    System.out.print("📜 전문 분야: ");
    String domain = scanner.nextLine();

    System.out.print("🎙️ 커뮤니케이션 레벨 (1~10): ");
    int communationLevel = scanner.nextInt();
    scanner.nextLine();

    System.out.print("🖱️ 사용가능 스택 (띄어쓰기로 구분): ");
    List<String> stacks = Arrays.asList(scanner.nextLine().split(" "));

    // #2. 개별 필드
    System.out.print("🧪 테스팅 레벨 (1~10): ");
    int testingLevel = scanner.nextInt();

    System.out.print("🐞 버그트래킹 레벨 (1~10): ");
    int bugTrackingLevel = scanner.nextInt();

    return new QA(salary, experienceYears, role, domain, communationLevel,
        stacks, testingLevel, bugTrackingLevel);
  }


}
