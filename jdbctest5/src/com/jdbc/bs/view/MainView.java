package com.jdbc.bs.view;

import java.util.Scanner;

import com.jdbc.bs.common.BSController;

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
				case 1: selectAllEmployee();break;
				case 2: searchEmployee();break;
				case 3: addEmployee();break;
				case 4: updateEmployee();break;
				case 5: deleteEmployee();break;
				case 6: updateDepartment();break;
				case 7: updateJob();break;
				case 0: System.out.println("프로그램을 종료합니다.");return;
				default: System.out.println("0부터 7까지의 메뉴를 입력해 주세요");break;
			}
		}
	}
	public void selectAllEmployee() {
		System.out.println("==== 전체 사원 조회 ====");
		
	}
	public void searchEmployee() {
		System.out.println("==== 사원 조회 ====");
		System.out.println("1. 부서로 조회");
		System.out.println("2. 직책으로 조회");
		System.out.println("3. 이름으로 조회");
		System.out.println("3. 급여로 조회");
		System.out.print("메뉴 선택: ");
		switch(sc.nextInt()) {
		
		}
	}
	public void updateEmployee() {
		
	}
	public void deleteEmployee() {
		
	}
	public void updateDepartment() {
		
	}
	public void updateJob() {
		
	}
	
	
}

