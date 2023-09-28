package com.example.javaEmployeeTrackerLab;

import com.example.javaEmployeeTrackerLab.models.Employee;
import com.example.javaEmployeeTrackerLab.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaEmployeeTrackerLabApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployee() {
		Employee john = new Employee("John", 31, 47, "john@yahoo.com");
		employeeRepository.save(john);
	}

}
