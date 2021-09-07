package com.manish.Repository.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manish.Repository.EmployeeRepo;
import com.manish.Repository.exception.UserNotFoundException;
import com.manish.model.Employee;

@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo)
	{
		this.employeeRepo = employeeRepo;
	}
	
	
	public Employee addEmployee(Employee employee)
	{
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees()
	{
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public Employee findEmployeeById(Long id)
	{
//		return findEmployeeById(id)
//				.orElseThrow(() -> new UserNotFoundException("User by id "+ id + " was not found"));
		
		Employee employee = null;
		
		try 
		{
			Optional<Employee> optionalEntity =  employeeRepo.findEmployeeById(id);
			employee = optionalEntity.get();
		}
		catch(UserNotFoundException e){
			e.UserNotFoundException("User by id "+ id + " was not found");
		}
		
		return employee;
	}
	
	public void deleteEmployee(Long id)
	{
		employeeRepo.deleteEmployeeById(id);
	}
	
}
