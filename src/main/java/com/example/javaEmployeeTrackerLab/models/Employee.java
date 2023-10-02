package com.example.javaEmployeeTrackerLab.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    //    name, age, employeeNumber, email
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;
    @Column(name = "employee_number")
    private int employeeNumber;
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name="project_id", nullable = false)
    @JsonIgnoreProperties({"employees"})
    private Project project;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JsonIgnoreProperties({"employees"})
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinTable(
            name="employees_projects",
            joinColumns = {
                    @JoinColumn(
                            name="employee_id",
                            nullable = false,
                            updatable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name="project_id",
                            nullable = false,
                            updatable = false
                    )
            }
    )
    private List<Project> projects;

    public Employee(String name, int age, int employeeNumber, String email, Department department) {
        this.name = name;
        this.age = age;
        this.employeeNumber = employeeNumber;
        this.email = email;
        this.projects =  new ArrayList<>();
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
