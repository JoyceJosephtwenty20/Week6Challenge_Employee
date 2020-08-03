package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public void run(String... strings) throws Exception{

        Employees firstEmployee = new Employees();
        firstEmployee.setFirstName("David");
        firstEmployee.setLastName("John");

        employeeRepository.save(firstEmployee);


    }
}
