package factory;

import employees.Employee;
import employees.Role;
import employees.manager.Manager;
import employees.marketer.Marketer;
import employees.web.Designer;
import employees.web.dev.Backend;
import employees.web.dev.Devops;
import employees.web.dev.Frontend;
import employees.web.dev.QA;
import java.util.Arrays;
import java.util.List;
import lib.TypeSafeScanner;

public class EmployeeFactory {

  // 역할에 따라 객체를 생성하는 메서드
  public static Employee createEmployee(Role role) {
    System.out.println("📌 " + role + " 정보를 입력하세요.");

    // ✅ 공통 필드 입력 받기
    int salary = TypeSafeScanner.getValidInteger("💰 급여: ");
    int experienceYears = TypeSafeScanner.getValidInteger("⌛ 경력 (년): ");

    switch (role) {
      case Role.MANAGER:
        return createManager(salary, experienceYears);
      case Role.FRONTEND_DEVELOPER:
        return createFrontend(salary, experienceYears);
      case Role.BACKEND_DEVELOPER:
        return createBackend(salary, experienceYears);
      case Role.DEVOPS_DEVELOPER:
        return createDevops(salary, experienceYears);
      case Role.UIUX_DESIGNER:
        return createDesigner(salary, experienceYears);
      case Role.QUALITY_ASSURANCE:
        return createQA(salary, experienceYears);
      case Role.MARKETING_SPECIALIST:
        return createMarketer(salary, experienceYears);
      default:
        throw new IllegalArgumentException("Unknown role: " + role);
    }
  }

  private static Manager createManager(int salary, int experienceYears) {

    String domain = TypeSafeScanner.getValidString("📜 전문 분야: ");
    int leadershipLevel = TypeSafeScanner.getValidInteger("🎯 리더십 레벨 (1~10): ");
    int decisionMakingLevel = TypeSafeScanner.getValidInteger("📊 의사 결정 능력 (1~10): ");

    return new Manager(salary, experienceYears, domain, leadershipLevel,
        decisionMakingLevel);
  }

  private static Marketer createMarketer(int salary, int experienceYears) {
    // #1. 공통 필드
    List<String> languageSkills = Arrays.asList(
        TypeSafeScanner.getValidString("📜 사용가능 언어 (띄어쓰기 구분): ").split(""));

    int creativityLevel = TypeSafeScanner.getValidInteger("💡️ 창의력 (1~10): ");
    int persuasionLevel = TypeSafeScanner.getValidInteger("🗣️ 설득 "
        + "능력 (1~10): ");

    return new Marketer(salary, experienceYears, languageSkills, creativityLevel, persuasionLevel);
  }

  private static Designer createDesigner(int salary, int experienceYears) {
    int animationLevel = TypeSafeScanner.getValidInteger("🐺 애니메이션 구현 능력 (1 ~ 10): ");
    int UIUXLevel = TypeSafeScanner.getValidInteger("🧑‍🧒️ UI/UX 능력 (1~10): ");
    List<String> designTools = Arrays.asList(
        TypeSafeScanner.getValidString("🗣️ 사용가능한 디자인 툴 (띄어쓰기로 구분):").split(" "));

    return new Designer(salary, experienceYears, animationLevel, UIUXLevel, designTools);
  }

  private static Frontend createFrontend(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = TypeSafeScanner.getValidString("📜 전문 분야: ");
    int communicationLevel = TypeSafeScanner.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        TypeSafeScanner.getValidString("🖱️ 사용가능 스택 (띄어쓰기 구분): ").split(" "));

    // #2. 개별 필드
    int cssLevel = TypeSafeScanner.getValidInteger("📜 CSS 레벨 (1~10): ");
    int testingLevel = TypeSafeScanner.getValidInteger("️🧪 테스팅 레벨 (1~10): ");

    return new Frontend(salary, experienceYears, domain, communicationLevel, stacks, cssLevel,
        testingLevel);
  }

  private static Backend createBackend(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = TypeSafeScanner.getValidString("📜 전문 분야: ");
    int communicationLevel = TypeSafeScanner.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        TypeSafeScanner.getValidString("🖱️ 사용가능 스택 (띄어쓰기로 구분): ").split(" "));

    // #2. 개별 필드
    int databaseLevel = TypeSafeScanner.getValidInteger("㏈ 데이터베이스 레벨 (1~10): ");
    int securityLevel = TypeSafeScanner.getValidInteger("🔒️ 보안 레벨 (1~10): ");

    return new Backend(salary, experienceYears, domain, communicationLevel, stacks,
        databaseLevel,
        securityLevel);
  }

  private static Devops createDevops(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = TypeSafeScanner.getValidString("📜 전문 분야: ");
    int communicationLevel = TypeSafeScanner.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        TypeSafeScanner.getValidString("🖱️ 사용가능 스택 (띄어쓰기로 구분): ").split(" "));

    // #2. 개별 필드
    int CICDLevel = TypeSafeScanner.getValidInteger("🔃 CICD 레벨 (1~10): ");
    int cloudPlatformLevel = TypeSafeScanner.getValidInteger("☁ 클라우드 레벨 (1~10): ");

    return new Devops(salary, experienceYears, domain, communicationLevel, stacks,
        CICDLevel,
        cloudPlatformLevel);
  }

  private static QA createQA(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = TypeSafeScanner.getValidString("📜 전문 분야: ");
    int communicationLevel = TypeSafeScanner.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        TypeSafeScanner.getValidString("🖱️ 사용가능 스택 (띄어쓰기로 구분): ").split(" "));

    // #2. 개별 필드
    int testingLevel = TypeSafeScanner.getValidInteger("🧪 테스팅 레벨 (1~10): ");
    int bugTrackingLevel = TypeSafeScanner.getValidInteger("🐞 버그트래킹 레벨 (1~10): ");

    return new QA(salary, experienceYears, domain, communicationLevel,
        stacks, testingLevel, bugTrackingLevel);
  }


}
