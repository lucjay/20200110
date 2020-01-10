package co.lucjay.dowhile;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.lucjay.countries.CountryDto;
import co.lucjay.countries.CountryService;
import co.lucjay.countries.CountryServiceImpl;

public class Menu {
	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		int choice;
		boolean b = true;
		do {
			System.out.println("▶▶▶ERP◀◀◀");
			System.out.println(" 1. 직 원 관 리");
			System.out.println(" 2. 급 여 관 리");
			System.out.println(" 3. 부 서 관 리");
			System.out.println(" 4. 종 료");
			System.out.println("────────────");
			System.out.println("번호를 입력 하세요.");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				employeeMenu();
				break;
			case 2:
				salaryMenu();
				break;
			case 3:
				departmentMenu();
				break;
			case 4:
				b = false;
				System.out.println("종료 되었습니다.");
				break;
			}
		} while (b);
	}

	public void employeeMenu() {
		int choice;
		boolean b = true;
		do {
			System.out.println("┌──직원관리──┐");
			System.out.println("  1.직원조회 ");
			System.out.println("  2.직원관리 ");
			System.out.println("  3.직원갱신 ");
			System.out.println("  4.직원삭제 ");
			System.out.println("  5.돌아가기 ");
			System.out.println("└──────────┘");
			System.out.println("번호를 입력 하세요.");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				// System.out.println("직원 조회하는 화면.");
				CountryService service = new CountryServiceImpl();
				List<CountryDto> list = new ArrayList<CountryDto>();
				list = service.allSelect();
				for (CountryDto dto : list) {
					System.out.print(dto.getCountry_id() + " : ");
					System.out.print(dto.getCountry_name() + " : ");
					System.out.println(dto.getRegion_id() + " : ");
				}
				break;
			case 2:
				// System.out.println("직원 등록하는 화면.");
				CountryServiceImpl con = new CountryServiceImpl();
				CountryDto dto = new CountryDto();
				dto.setCountry_id("KO");
				dto.setCountry_name("KOREA");
				dto.setRegion_id(1);
				try {
					int n = con.insert(dto);
					if (n != 0)
						System.out.println("정상적으로 등록쓰");
					else
						System.out.println("입력안됐졍");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				// System.out.println("직원 갱신하는 화면.");
				CountryServiceImpl ser = new CountryServiceImpl();
				CountryDto dto1 = new CountryDto();
				Scanner sc = new Scanner(System.in);
				System.out.println("업뎃할사용자 아이디 입력해바");
				String key = sc.nextLine();
				try {
					dto1 = ser.select(key);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("변경 할 country name 입력행");
				dto1.setCountry_name(sc.nextLine());
				try {
					int n = ser.update(dto1);
					if (n != 0)
						System.out.println("정삭적으로 변경됐져~~~");
					else
						System.out.println("변경 안됐눈뎅~~~~~");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				// System.out.println("직원 삭제하는 화면.");
				CountryServiceImpl con1 = new CountryServiceImpl();
				CountryDto dto11 = new CountryDto();
				Scanner sc1 = new Scanner(System.in);
				System.out.println("삭제 할 사용자 입력행");
				dto11.setCountry_id(sc1.nextLine());
				try {
					int n = con1.delete(dto11);
					if (n != 0)
						System.out.println("정상적으로 삭제 됨");
					else
						System.out.println("삭제 안됐졍");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				b = false;
				break;
			}
		} while (b);
	}

	public void salaryMenu() {
		int choice;
		boolean b = true;
		do {
			System.out.println("┌──급여관리──┐");
			System.out.println("  1.급여조회 ");
			System.out.println("  2.급여등록 ");
			System.out.println("  3.급여변경 ");
			System.out.println("  4.급여삭제 ");
			System.out.println("  5.돌아가기 ");
			System.out.println("└──────────┘");
			System.out.println("번호를 입력 하세요.");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				// 국가 조회하는 연결System.out.println("급여 조회 화면");
				break;
			case 2:
				System.out.println("급여 등록 화면");
				break;
			case 3:
				System.out.println("급여 갱신 화면");
				break;
			case 4:
				System.out.println("급여 삭제 화면");
				break;
			case 5:
				b = false;
				break;
			}
		} while (b);
	}

	public void departmentMenu() {
		int choice;
		boolean b = true;
		do {
			System.out.println("┌──부서관리──┐");
			System.out.println("  1.부서조회 ");
			System.out.println("  2.부서등록 ");
			System.out.println("  3.부서변경 ");
			System.out.println("  4.부서삭제 ");
			System.out.println("  5.돌아가기 ");
			System.out.println("└──────────┘");
			System.out.println("번호를 입력 하세요.");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("부서 조회 화면");
				break;
			case 2:
				System.out.println("부서 등록 화면");
				break;
			case 3:
				System.out.println("부서 갱신 화면");
				break;
			case 4:
				System.out.println("부서 삭제 화면");
				break;
			case 5:
				b = false;
				break;
			}
		} while (b);
	}

}
