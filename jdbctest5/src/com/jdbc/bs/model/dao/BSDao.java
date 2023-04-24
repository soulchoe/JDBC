package com.jdbc.bs.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.jdbc.bs.model.dto.Employee;

public class BSDao {
	private Properties sql=new Properties();
	{
		
		try {
			String path=Employee.class.getResource("/sql_employee.properties").getPath();
			sql.load(new FileReader(path));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<Employee> selectAllEmployee(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee> employees=new ArrayList();
		String sql=this.sql.getProperty("selectAllEmployee");
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				employees.add(getEmployee(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return employees;
	}
	public List<Employee> searchEmployee(Connection conn, Map param){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Employee> employees=new ArrayList<>();
		
		String sql=this.sql.getProperty(null)
	}
}
