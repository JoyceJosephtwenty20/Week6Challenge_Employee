package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String... args){
        Employee employee = new Employee("joycekj", "joyce.j106s13@gmail.com", "p@ssword","202-594-7406", "Joyce", "Joseph", true);
        Role userRole = new Role ("joycekj", "ROLE_USER");

        employeeRepository.save(employee);
        roleRepository.save(userRole);

        Employee admin = new Employee("admin", "admin@domain.com", "admin","202-594-7406", "Joseph", "Joseph", true);
        Role adminRole1 = new Role ("admin", "ROLE_ADMIN");
        Role adminRole2 = new  Role ("admin", "ROLE_USER");

        employeeRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);








    }
}
