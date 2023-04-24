package com.jdbc.bs.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import com.jdbc.bs.model.dao.BSDao;
import com.jdbc.bs.model.dto.Employee;

public class BSService {
	private BSDao dao=new BSDao();
	
	public List<Employee> selectAllEmployee(){
		Connection conn=getConnection();
		List<Employee> employees=dao.selectAllEmployee(conn);
		close(conn);
		return employees;
	}
	public List<Employee> searchEmployee(Map param){
		Connection conn=getConnection();
		List<Employee> employee=dao.searchEmployee(conn,param);
		close(conn);
		return employee;
	}
}
