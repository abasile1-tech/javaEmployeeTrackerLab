package com.example.javaEmployeeTrackerLab.repositories;

import com.example.javaEmployeeTrackerLab.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository <Project, Long> {
}
