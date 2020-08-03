package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String... args){
        Employees employees = new Employees("IT Administrator", "JohnD", "John", "Davis", "Password", true);
        Department department = new Department("Information Technology");
        Role userRole = new Role("Johnd", "ROLE_USER");

        employeeRepository.save(employees);
        departmentRepository.save(department);
        roleRepository.save(userRole);

    }
}
