package com.example.Employee.Management.System.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Management.System.dto.EmployeeDto;
import com.example.Employee.Management.System.service.EmployeeService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService; 
	
	//Build Add Employee REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
		}
	
//	public EmployeeController(EmployeeService employeeService) {
//		super();
//		this.employeeService = employeeService;
//	}

	//Build Get Employee REST API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//Build Get All Employees REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> allEmployees = employeeService.getAllEmployees();
		return  ResponseEntity.ok(allEmployees);
	}
	
	//Build Update Employees REST API
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto updatedEmployee){
		EmployeeDto updateEmployee = employeeService.updateEmployee(employeeId, updatedEmployee);
		
		return ResponseEntity.ok(updateEmployee);
		
	}
	//Build Delete Employees REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
		employeeService.deleteEmployee(employeeId);
		
		return ResponseEntity.ok("Employee deleted successfully....!"+employeeId);
		
	}
	
}
