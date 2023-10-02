package com.example.javaEmployeeTrackerLab;

import com.example.javaEmployeeTrackerLab.models.Department;
import com.example.javaEmployeeTrackerLab.models.Employee;
import com.example.javaEmployeeTrackerLab.models.Project;
import com.example.javaEmployeeTrackerLab.repositories.DepartmentRepository;
import com.example.javaEmployeeTrackerLab.repositories.EmployeeRepository;
import com.example.javaEmployeeTrackerLab.repositories.ProjectRepository;
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

	@Autowired
	ProjectRepository projectRepository;

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

	@Test
	public void addEmployeesAndProjects(){
		Department department = new Department("H.R.");
		departmentRepository.save(department);

		Employee employee = new Employee("Jack", 31, 3298, "email@email.com", department);
		employeeRepository.save(employee);

		Project project = new Project("Impossible Mission", 150);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);

	}

}
