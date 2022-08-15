package com.sripal.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sripal.Entity.Employee;
import com.sripal.Service.EmployeeService;

public class EmployeeController1 {
	
	
	
	@Autowired
	private EmployeeService empServ;
	
	@GetMapping("/home")
	public String Homepage(Model model) {
	
	return "Home";
	}
	
	@GetMapping("/list_Emp")
	public String EmpList(Model model) {
		model.addAttribute("listEmp", empServ.findAllEmps());
	return "Empslist";
	}
	
	@GetMapping("/AddEmp")
	public String ADDEmp(Model model,Employee employee) {
		return"AddForm";
	}
	
	@PostMapping("/save")
	public String HandleSaveBtn(@Valid@ModelAttribute("employee") Employee employee,BindingResult br) {
		if (br.hasErrors()) {
			
			return"AddForm";
		}
		empServ.SaveEmp(employee);
		
		return"redirect:/AddEmp?success";
	}
	@GetMapping("/delete/{EmployeeId}")
	public String handleDeleteBtn(@PathVariable("EmployeeId") String EmployeeId) {
		empServ.DeleteEmpById(EmployeeId);
	return"redirect:/";	
	}
	
	@GetMapping("/update/{EmployeeId}")
	
	public String handleUpadteBtn(@PathVariable("EmployeeId") String EmployeeId,Model model) {
		
		model.addAttribute("employee", empServ.UpdateEmpById(EmployeeId));
		
		return"UpdateEmp";
	}

}
