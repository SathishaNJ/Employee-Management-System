package com.example.Employee.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee.Management.System.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
