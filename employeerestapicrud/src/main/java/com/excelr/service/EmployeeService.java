package com.excelr.service;

import java.util.List;

import com.excelr.entity.Employee;


public interface EmployeeService {
	Employee addEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
	String deleteEmployeeById(int id);
	String updateEmployeeById(int id,Employee employee);

}
