package com.sripal.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sripal.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

}
