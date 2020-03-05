package com.bhavesh.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhavesh.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
