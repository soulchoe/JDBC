package com.jdbc.bs.view;

import java.util.Scanner;

import com.jdbc.bs.common.BSController;
import com.jdbc.bs.model.dto.Department;
import com.jdbc.bs.model.dto.Employee;
import com.jdbc.bs.model.dto.Job;

public class MainView {
	private Scanner sc=new Scanner(System.in);
	
	public void mainMenu() {
		BSController controller=new BSController();
		while(true) {
			System.out.println("==== BS테이블 JDBC ====");
			System.out.println("1. 전체 사원 조회");
			System.out.println("2. 사원 조회");
			System.out.println("3. 사원 등록");
			System.out.println("4. 사원 수정");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서 관리");
			System.out.println("7. 직책 관리");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 선택: ");
			int choice=sc.nextInt();
			switch(choice) {
				case 1: bc.selectAllEmployee();break;
				case 2: bc.searchEmployee();break;
				case 3: bc.addEmployee();break;
				case 4: bc.updateEmployee();break;
				case 5: bc.deleteEmployee();break;
				case 6: bc.updateDepartment();break;
				case 7: bc.updateJob();break;
				case 0: System.out.println("프로그램을 종료합니다.");return;
				default: System.out.println("0부터 7까지의 메뉴를 입력해 주세요");break;
			}
		}
	}
	public void selectAllEmployee() {
		System.out.println("==== 전체 사원 조회 ====");
		
	}
	public void searchEmployee() {
		while(true) {
			System.out.println("==== 사원 조회 ====");
			System.out.println("1. 부서로 조회");
			System.out.println("2. 직책으로 조회");
			System.out.println("3. 이름으로 조회");
			System.out.println("4. 급여로 조회");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("메뉴 선택: ");
			switch(sc.nextInt()) {
				case 1: bc.searchEmpByDept();break;
				case 2: bc.searchEmpByJob();break;
				case 3: bc.searchEmpByName();break;
				case 4: bc.searchEmpBySalary();break;
				case 0:System.out.println("메인으로 돌아갑니다");return;
				default:System.out.println("0부터 4사이의 메뉴를 입력하세요");break;
			}
		}
	}
	public Employee insertEmployee() {
		Employee e=new Employee();
		System.out.println("====== 사원 등록 ======");
		System.out.println("사원 번호: ");
		e.setEmpId(sc.nextInt());
		System.out.println("사원 이름: ");
		sc.nextLine();
		e.setEmpName(sc.nextLine());
		System.out.println("사원 주민등록번호: ");
		e.setEmpNo(sc.nextLine());
		System.out.println("사원 이메일: ");
		e.setEmail(sc.nextLine());
		System.out.println("사원 연락처: ");
		e.setPhone(sc.nextLine());
		System.out.println("사원 부서코드: ");
		e.setDeptCode(sc.nextLine());
		System.out.println("사원 직업코드: ");
		e.setJobCode(sc.nextLine());
		System.out.println("사원 급여레벨: ");
		e.setSalLevel(sc.nextLine());
		System.out.println("사원 급여: ");
		e.setSalary(sc.nextInt());
		System.out.println("사원 보너스: ");
		e.setBonus(sc.nextDouble());
		System.out.println("매니저 사원번호: ");
		e.setManagerId(sc.nextInt());
		return e;
			
	}
	public Employee updateEmployee() {
		Employee e=new Employee();
		System.out.println("===== 사원 정보 수정 =====");
		System.out.println("수정할 사원의 사번: ");
		e.setEmpId(sc.nextInt());
		System.out.println("변경된 직책: ");
		e.setJobCode(sc.next());
		System.out.println("변경된 부서: ");
		e.setDeptCode(sc.next());
		System.out.println("변경된 급여: ");
		e.setSalary(sc.nextInt());
		System.out.println("변경된 연락처: ");
		e.setPhone(sc.next());
		System.out.println("변경된 이메일: ");
		e.setEmail(sc.next());
		return e;
		
	}
	public void deleteEmployee() {
		
	}
	public void departmentMenu() {
		while(true) {
			System.out.println("===== 부서관리 메뉴 =====");
			System.out.println("1. 부서 등록");
			System.out.println("2. 부서 수정");
			System.out.println("3. 부서 삭제");
			System.out.println("0. 메인으로 돌아가기");
			switch(sc.nextInt()) {
				case 1: bc.addDept();break;
				case 2: bc.updateDept();break;
				case 3: bc.deleteDept();break;
				case 0:System.out.println("메인으로 돌아갑니다.");return;
				default:System.out.println("0부터 3사이의 메뉴를 입력하세요.");break;
			}
		}
	}
	public Department insertDept() {
		Department d=new Department();
		System.out.println("==== 부서 등록 ====");
		System.out.print("새 부서 코드:");
		d.setDeptId(sc.next());
		System.out.print("새 부서명:");
		d.setDeptTitle(sc.next());
		System.out.print("새 부서 지역 코드:");
		d.setLocationId(sc.next());
		return d;
	}
	public Department updateDept() {
		Department d=new Department();
		System.out.println("==== 부서 수정 ====");
		System.out.print("수정할 부서 코드:");
		d.setDeptId(sc.next());
		System.out.print("변경된 부서명:");
		d.setDeptTitle(sc.next());
		System.out.print("변경된 지역 코드:");
		d.setLocationId(sc.next());
		return d;
	}
	public void jobMenu() {
		while(true) {
			System.out.println("===== 직책관리 메뉴 =====");
			System.out.println("1. 직책 등록");
			System.out.println("2. 직책 수정");
			System.out.println("3. 직책 삭제");
			System.out.println("0. 메인으로 돌아가기");
			switch(sc.nextInt()) {
				case 1: bc.addJob();break;
				case 2: bc.updateJob();break;
				case 3: bc.deleteJob();break;
				case 0:System.out.println("메인으로 돌아갑니다.");return;
				default:System.out.println("0부터 3사이의 메뉴를 입력하세요.");break;
			}
		}
	}public Job insertJob() {
		Job j=new Job();
		System.out.println("==== 직책 등록 ====");
		System.out.print("새 직책 코드:");
		j.setJobCode(sc.next());
		System.out.print("새 직책명:");
		j.setJobName(sc.next());
	
		return j;
	}
	public Job updateJob() {
		Job j=new Job();
		System.out.println("==== 직책 수정 ====");
		System.out.print("수정할 직책 코드:");
		j.setJobCode(sc.next());
		System.out.print("변경된 직책명:");
		j.setJobName(sc.next());
	
		return j;
	}
	public void printEmp() {
		
	}
	public void printMsg() {
		
	}
	
	
}

