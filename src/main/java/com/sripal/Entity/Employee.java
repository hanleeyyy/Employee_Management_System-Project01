package com.sripal.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="EMP_MNG_SYS")
public class Employee {
	@Id
	@GenericGenerator(name="EMP_MNGMNT_SEQ",strategy="com.sripal.Generators.EmployeeID")
	@GeneratedValue(generator="EMP_MNGMNT_SEQ")
   private String EmployeeId;
	@NotBlank(message="*Enter The Employee Name")
   private String EmployeeName;
	
	@Email
	@NotBlank(message="*Enter The Email")
   private String mailId;
	
	@NotBlank(message="*Enter The Password")
	private String Password;
	@NotBlank(message="*Enter The Dob")
	private String Dob;
	@NotBlank(message="*Enter The Gender")
	private String Gender;
	
	@NotNull(message="*enter The Mobile No")
	private Long Mobile;
	
	@NotBlank(message="*Enter Employee Adress")
   private String Address;
	
	
}