package com.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.jdbc.member.controller.MemberController;
import com.jdbc.member.model.dto.MemberDTO;

public class MainView {
	
	private MemberController controller=new MemberController();
	//데이터 저장구조가 분리되어있기때문에 생성해서 써도 상관없음
	public void mainMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("=======jdbc 회원관리 프로그램======");
			System.out.println("1.전체회원 조회");
			System.out.println("2.아이디로 회원조회");
			System.out.println("3.이름으로 회원조회");
			System.out.println("4.회원등록");
			System.out.println("5.회원수정(이름, 나이, 이메일, 주소)");
			System.out.println("0.프로그램 종료");
			System.out.print("메뉴 선택 : ");
			int cho=sc.nextInt();
			switch(cho) {
				case 1: controller.selectAllMember();break;
				case 2: controller.selectMemberById();break;
				case 3: controller.selectMemberByName();break;
				case 4: controller.addMember();break;
				case 5: controller.updateMember();break;
				case 0: System.out.println("프로그램을 종료합니다");return;
				default: System.out.println("0~5사이의 메뉴를 입력하세요");
			}
		}
	}
	public void printMembers(List<MemberDTO> members) {
		System.out.println("======== 조회된 결과========");
		members.forEach(m->System.out.println(m));
		System.out.println("=========================");
	}
	public void printMember(MemberDTO match) {
		System.out.println("======== 조회된 결과========");
		System.out.println(match!=null?match:"검색결과가 없습니다.");
		System.out.println("=========================");
	}
	public String inputData(String title) {
		Scanner sc=new Scanner(System.in);
		System.out.println("====== 검색할 "+title+"입력======");
		System.out.print("입력 : ");
		return sc.nextLine();
	}
	public void printMsg(String msg) {
		System.out.println("======== 시스템 메세지 ========");
		System.out.println(msg);
		System.out.println("=========================");
	}

	public MemberDTO addMember() {
		Scanner sc=new Scanner(System.in);
		MemberDTO m=new MemberDTO();
		System.out.print("신규 아이디 입력: ");
		//String id=sc.nextLine();
		m.setMemberId(sc.nextLine());
		System.out.print("신규 비밀번호 입력: ");
		//String pwd=sc.nextLine();
		m.setMemberPwd(sc.nextLine());
		System.out.print("신규 이름 입력: ");
		//String name=sc.nextLine();
		m.setMemberName(sc.nextLine());

		System.out.print("신규 성별(M/F) 입력: ");
		//char gender=sc.next().charAt(0);
		m.setGender(sc.next().charAt(0));
		System.out.print("신규 나이 입력: ");
		//int age=sc.nextInt();
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("신규 전화번호 입력: ");
		//String phone=sc.nextLine();
		m.setPhone(sc.nextLine());
		System.out.print("신규 이메일 입력: ");
		//String email=sc.nextLine();
		m.setEmail(sc.nextLine());
		System.out.print("신규 주소 입력: ");
		//String address=sc.nextLine();
		m.setAddress(sc.nextLine());
		System.out.print("신규 취미 입력(,로 복수입력 가능): ");
		//String[] hobby=sc.nextLine().split(",");
		m.setHobby(sc.nextLine().split(","));
		
		//(id,pwd,name,gender,age,email,phone,address,hobby);
		//같은 타입이 이렇게 여러번 반복하는 경우, 빌더 패턴이나 셋터 이용 추천
		return m;
		
	}
	
	public MemberDTO updateData() {
		Scanner sc=new Scanner(System.in);
		MemberDTO m=new MemberDTO();
		
		System.out.println("===== 회원정보 수정 =====");
		System.out.print("수정할 멤버 아이디: ");
		m.setMemberId(sc.nextLine());
		System.out.print("새 이름: ");
		m.setMemberName(sc.nextLine());
		System.out.print("새 나이: ");
		m.setAge(sc.nextInt());
		sc.nextLine();
		System.out.print("새 이메일: ");
		m.setEmail(sc.nextLine());
		System.out.print("새 주소: ");
		m.setAddress(sc.nextLine());
		return m;
	}
	
}
