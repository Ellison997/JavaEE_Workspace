package com.eswork.mvcempsys.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.eswork.mvcempsys.dao.EmployeeDAO;
import com.eswork.mvcempsys.model.Employee;

public class EmpService {
	EmployeeDAO empDao = new EmployeeDAO();

	// 查询符合条件的员工
	public ArrayList<Employee> getEmployee(String postId, String name)
			throws SQLException {
		ArrayList<Employee> list = null;
		list = empDao.showEmployee(postId, name);
		return list;

	}

	public ArrayList<Employee> getEmployee(String postId) throws SQLException {
		ArrayList<Employee> list = null;
		list = empDao.showEmployee(postId);
		return list;

	}

}
