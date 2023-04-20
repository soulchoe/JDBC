package com.jdbc.member.controller;

import java.util.List;

import com.jdbc.member.model.dao.MemberDao;
import com.jdbc.member.model.dto.MemberDTO;
import com.jdbc.view.MainView;

public class MemberController {
	private MemberDao dao=new MemberDao();
	//여기서도 메인뷰를 생성하면 서로를 호출해서 생성해서 스택오버플로우 에러 발생
	
	public void mainMenu() {
		new MainView().mainMenu();
	}
	
	//전체회원 조회하기
	public void selectAllMember() {
		//DB의 STUDENT 계정에 있는 Member 테이블의 모든 데이터를 가져와 출력하는 기능
		//1)DB에서 Member테이블의ㅣ 모든 데이터 가져오기 -> DAO의 역할
		List<MemberDTO> members=dao.selectAllMember();
		//2)가져온 데이터 출력하기 -> VIEW의 역할
		new MainView().printMembers(members);
	}
	public void selectMemberById() {
		//db의 member테이블에서 사용자가 적성한 아이디와 일치하는 데이터 가져오기
		//1. 사용자가 아이디를 작성할 수 있게함 ->화면상에 입력받기(view)
		String inputId=new MainView().inputData("아이디");
		//2. 작성한 아이디와 일치하는 아이디(pk)를 db에서 조회
		MemberDTO m=dao.selectMemberById(inputId);
		//3.조회한 회원 출력하기
		new MainView().printMember(m);
	}
	public void selectMemberByName() {
		//DB의 Member 테이블에서 이름과 부분일치하는 데이터를 가져와 출력해주는 기능
		
		String name=new MainView().inputData("이름");
		List<MemberDTO> members=dao.selectMemberByName(name);
		new MainView().printMembers(members);
	}
	public void addMember() {
		MemberDTO member=new MainView().addMember();
		int result=dao.addMember(member);
		//추가 성공시 1리턴, 실패시 0또는 익셉션 발생
		new MainView().printMsg(result>0?"회원등록 성공:)":"회원등록 실패:/");
	}
	public void updateMember() {

		int result=dao.updateMember(new MainView().updateData());
		//추가 성공시 1리턴, 실패시 0또는 익셉션 발생
		new MainView().printMsg(result>0?"회원수정 성공:)":"회원수정 실패:/");
	}
}
