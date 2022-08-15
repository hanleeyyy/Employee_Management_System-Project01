package com.sripal.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sripal.Entity.Employee;
import com.sripal.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void SaveEmp(Employee employee) {
		
		empRepo.save(employee);
		
	}

	@Override
	public void DeleteEmpById(String EmployeeId) {
		empRepo.deleteById(EmployeeId);

	}

	@Override
	public List<Employee> findAllEmps() {
		
		List<Employee> all = empRepo.findAll();
		
		
		return all;
	}

	@Override
	public Employee UpdateEmpById(String EmployeeId) {
		Optional<Employee> optional = empRepo.findById(EmployeeId);
		Employee employee = null;
		
		if (optional.isPresent()) {
			
			employee = optional.get();
			
		}
		return employee;
	}

}
