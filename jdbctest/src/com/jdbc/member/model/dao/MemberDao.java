package com.jdbc.member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.member.model.dto.MemberDTO;

public class MemberDao {
	public List<MemberDTO> selectAllMember(){
		//DB에 접속해서 Member 테이블에 있는 전체 데이터를 가져오는 기능
		//1.드라이버 있는지 확인
		//2.Connection객체 생성
		//	1)
		//	2)
		//	3)
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM MEMBER";
		List<MemberDTO> members=new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", 
					"STUDENT","student");
			conn.setAutoCommit(false);//여기선 의미없지만,,ㅎ
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			//다수값->while문, 0~1개_>if
			while(rs.next()) {
//				MemberDTO member=new MemberDTO();
//				member.setMemberId(rs.getString("member_id"));
//				member.setMemberPwd(rs.getString("member_pwd"));
//				member.setMemberName(rs.getString("member_name"));
//				member.setAge(rs.getInt("age"));
//				member.setGender(rs.getString("gender").charAt(0));
//				member.setPhone(rs.getString("phone"));
//				member.setEmail(rs.getString("email"));
//				member.setHobby(rs.getString("hobby").split(","));
//				member.setEnrollDate(rs.getDate("enroll_date"));
				members.add(getMember(rs));
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return members;
		
	}
	public MemberDTO selectMemberById(String id) {
		//id는 pk값이므로 0또는 1개의 값이 나옴
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;//0또는 1개 값 리턴에 rs가 필요할까..? yes.
		String sql="SELECT * FROM MEMBER WHERE MEMBER_ID='"+id+"'";//....?여기에 변수 어케 받음 이러케!
		MemberDTO match=null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					,"STUDENT","student");
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);//결과가 null이 될 수 없음(ArrayList도 마찬가지), 일단 생성되기때문에
			//안에 있는 각각의 값을 비교해야함
			if(rs.next())//rs!=null가능? 불가능
				{
				match=getMember(rs);
//				match=new MemberDTO();
//				match.setMemberId(rs.getString("member_id"));
//				match.setMemberPwd(rs.getString("member_pwd"));
//				match.setMemberName(rs.getString("member_name"));
//				match.setAge(rs.getInt("age"));
//				match.setGender(rs.getString("gender").charAt(0));
//				match.setPhone(rs.getString("phone"));
//				match.setEmail(rs.getString("email"));
//				match.setHobby(rs.getString("hobby").split(","));
//				match.setEnrollDate(rs.getDate("enroll_date"));
				
			}	
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return match;
	}
	
	public List<MemberDTO> selectMemberByName(String name){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM MEMBER WHERE MEMBER_NAME LIKE '%"+name+"%'";
		List<MemberDTO> members= new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					,"student","student");
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				members.add(getMember(rs));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return members;
	}
	
	public int addMember(MemberDTO m) {
		Connection conn=null;
		Statement stmt=null;
		int result=0;
		String sql="INSERT INTO MEMBER VALUES('"+m.getMemberId()+"','"+m.getMemberPwd()
					+"','"+m.getMemberName()+"','"+m.getGender()+"',"+m.getAge()
					+",'"+m.getEmail()+"','"+m.getPhone()+"','"+m.getAddress()
					+"','"+String.join(",",m.getHobby())+"',DEFAULT)";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					,"student","student");
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);
			
			if(result>0) conn.commit();
			else conn.rollback();
			//커넥션 객체가 끊어지면 자동으로 커밋처리 되긴 함
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateMember(MemberDTO member) {
		Connection conn=null;
		Statement stmt=null;
		int result=0;
		String sql="UPDATE MEMBER SET MEMBER_NAME='"+member.getMemberName()+"', AGE="+
				member.getAge()+", EMAIL='"+member.getEmail()+"', ADDRESS='"+member.getAddress()+
				"' WHERE MEMBER_ID='"+member.getMemberId()+"'";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","student","student");
			conn.setAutoCommit(false);
			stmt=conn.createStatement();
			result=stmt.executeUpdate(sql);
			if(result>0) conn.commit();
			else conn.rollback();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	private MemberDTO getMember(ResultSet rs) throws SQLException{
		//계속 같은 거쓰기 귀찮,유지보수 짜증. 예외는 호출한 곳에서 처리하시길~
		MemberDTO m=new MemberDTO();
		m.setMemberId(rs.getString("member_id"));
		m.setMemberPwd(rs.getString("member_pwd"));
		m.setMemberName(rs.getString("member_name"));
		m.setAge(rs.getInt("age"));
		m.setGender(rs.getString("gender").charAt(0));
		m.setPhone(rs.getString("phone"));
		m.setEmail(rs.getString("email"));
		m.setHobby(rs.getString("hobby").split(","));
		m.setEnrollDate(rs.getDate("enroll_date"));
		return m;
	}
}
