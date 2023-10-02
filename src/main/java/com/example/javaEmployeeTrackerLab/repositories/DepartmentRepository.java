package com.example.javaEmployeeTrackerLab.repositories;

import com.example.javaEmployeeTrackerLab.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
