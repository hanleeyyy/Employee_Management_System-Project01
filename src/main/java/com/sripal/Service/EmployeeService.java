package com.sripal.Service;

import java.util.List;

import com.sripal.Entity.Employee;


public interface EmployeeService {
	
	public void SaveEmp(Employee employee);
	
	public void DeleteEmpById(String EmployeeId);
	
	public List<Employee> findAllEmps();
	
	public Employee UpdateEmpById(String EmployeeId);

}
