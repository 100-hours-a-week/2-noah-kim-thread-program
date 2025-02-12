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
import lib.SafeInput;

public class EmployeeFactory {

  // 역할에 따라 객체를 생성하는 메서드
  public static Employee createEmployee(Role role) {
    System.out.println("📌 " + role + " 정보를 입력하세요.");

    // ✅ 공통 필드 입력 받기
    int salary = SafeInput.getValidInteger("💰 급여: ");
    int experienceYears = SafeInput.getValidInteger("⌛ 경력 (년): ");

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

    String domain = SafeInput.getValidString("📜 전문 분야: ");
    int leadershipLevel = SafeInput.getValidInteger("🎯 리더십 레벨 (1~10): ");
    int decisionMakingLevel = SafeInput.getValidInteger("📊 의사 결정 능력 (1~10): ");

    return new Manager(salary, experienceYears, domain, leadershipLevel,
        decisionMakingLevel);
  }

  private static Marketer createMarketer(int salary, int experienceYears) {
    // #1. 공통 필드
    List<String> languageSkills = Arrays.asList(
        SafeInput.getValidString("📜 사용가능 언어 (띄어쓰기 구분): ").split(""));

    int creativityLevel = SafeInput.getValidInteger("💡️ 창의력 (1~10): ");
    int persuasionLevel = SafeInput.getValidInteger("🗣️ 설득 "
        + "능력 (1~10): ");

    return new Marketer(salary, experienceYears, languageSkills, creativityLevel, persuasionLevel);
  }

  private static Designer createDesigner(int salary, int experienceYears) {
    int animationLevel = SafeInput.getValidInteger("🐺 애니메이션 구현 능력 (1 ~ 10): ");
    int UIUXLevel = SafeInput.getValidInteger("🧑‍🧒️ UI/UX 능력 (1~10): ");
    List<String> designTools = Arrays.asList(
        SafeInput.getValidString("🗣️ 사용가능한 디자인 툴 (띄어쓰기로 구분):").split(" "));

    return new Designer(salary, experienceYears, animationLevel, UIUXLevel, designTools);
  }

  private static Frontend createFrontend(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = SafeInput.getValidString("📜 전문 분야: ");
    int communationLevel = SafeInput.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        SafeInput.getValidString("🖱️ 사용가능 스택 (띄어쓰기 구분): ").split(" "));

    // #2. 개별 필드
    int cssLevel = SafeInput.getValidInteger("📜 CSS 레벨 (1~10): ");
    int testinglevel = SafeInput.getValidInteger("️🧪 테스팅 레벨 (1~10): ");

    return new Frontend(salary, experienceYears, domain, communationLevel, stacks, cssLevel,
        testinglevel);
  }

  private static Backend createBackend(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = SafeInput.getValidString("📜 전문 분야: ");
    int communationLevel = SafeInput.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        SafeInput.getValidString("🖱️ 사용가능 스택 (띄어쓰기로 구분): ").split(" "));

    // #2. 개별 필드
    int databaseLevel = SafeInput.getValidInteger("㏈ 데이터베이스 레벨 (1~10): ");
    int securityLevel = SafeInput.getValidInteger("🔒️ 보안 레벨 (1~10): ");

    return new Backend(salary, experienceYears, domain, communationLevel, stacks,
        databaseLevel,
        securityLevel);
  }

  private static Devops createDevops(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = SafeInput.getValidString("📜 전문 분야: ");
    int communationLevel = SafeInput.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        SafeInput.getValidString("🖱️ 사용가능 스택 (띄어쓰기로 구분): ").split(" "));

    // #2. 개별 필드
    int CICDLevel = SafeInput.getValidInteger("🔃 CICD 레벨 (1~10): ");
    int cloudPlatformLevel = SafeInput.getValidInteger("☁ 클라우드 레벨 (1~10): ");

    return new Devops(salary, experienceYears, domain, communationLevel, stacks,
        CICDLevel,
        cloudPlatformLevel);
  }

  private static QA createQA(int salary, int experienceYears) {
    // #1. 공통 필드
    String domain = SafeInput.getValidString("📜 전문 분야: ");
    int communationLevel = SafeInput.getValidInteger("🎙️ 커뮤니케이션 레벨 (1~10): ");
    List<String> stacks = Arrays.asList(
        SafeInput.getValidString("🖱️ 사용가능 스택 (띄어쓰기로 구분): ").split(" "));

    // #2. 개별 필드
    int testingLevel = SafeInput.getValidInteger("🧪 테스팅 레벨 (1~10): ");
    int bugTrackingLevel = SafeInput.getValidInteger("🐞 버그트래킹 레벨 (1~10): ");

    return new QA(salary, experienceYears, domain, communationLevel,
        stacks, testingLevel, bugTrackingLevel);
  }


}
