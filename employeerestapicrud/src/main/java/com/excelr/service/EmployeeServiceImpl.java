package com.excelr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Employee;
import com.excelr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee > emp = employeeRepository.findById(id);
		
		Employee emp2=null;
		
		if(emp.isPresent())
		{
			emp2=emp.get();
		}
		   return emp2;
	}

	@Override
	public String deleteEmployeeById(int id) {
		if(employeeRepository.existsById(id))
	        employeeRepository.deleteById(id);
	   else
		  return "id "+ id +" not found to delete";
	
		  
    return "id "+ id +" is deleted";
	}

	@Override
	public String updateEmployeeById(int id, Employee employee) {
		if(employeeRepository.existsById(id))
		 {
			Employee e= employeeRepository.findById(id).get();
		    e.setName(employee.getName());
		    e.setSalary(employee.getSalary());
		    e.setAge(employee.getAge());
		    e.setDept(employee.getDept());
		    e.setAddress(employee.getAddress());
		    employeeRepository.save(e);
			 
		 }
		     
		 else
			 return "id not present to update";
		 
		return "employee updated";
	}

}
