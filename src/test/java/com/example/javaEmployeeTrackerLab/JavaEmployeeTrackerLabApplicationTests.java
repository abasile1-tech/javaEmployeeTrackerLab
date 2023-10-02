package com.example.javaEmployeeTrackerLab;

import com.example.javaEmployeeTrackerLab.models.Department;
import com.example.javaEmployeeTrackerLab.models.Employee;
import com.example.javaEmployeeTrackerLab.repositories.DepartmentRepository;
import com.example.javaEmployeeTrackerLab.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class JavaEmployeeTrackerLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createDepartmentAndAddEmployee() {
		Department department = new Department("H.R.");
		Employee employee = new Employee("Jack", 31, 3298, "email@email.com", department);
		departmentRepository.save(department);
		employeeRepository.save(employee);

		ArrayList<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(employee);

		department.setEmployees(listOfEmployees);

		System.out.println(department.getEmployees());
	}

}
