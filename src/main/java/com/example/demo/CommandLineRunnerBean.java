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

    @Autowired
    DepartmentRepository departmentRepository;


    public void run(String... args){
        Employee employee1 = new Employee("mc", "mc@domain.com", "mc","111-111-1111", "MAC", "C", true);
        Role userRole = new Role ("mc", "ROLE_USER");

        Employee employee2 = new Employee("joycekj", "jocye.j106s13@gmail.com", "password","111-111-1111", "Joyce", "Joseph", true);
        Role userRole2 = new Role ("joycekj", "ROLE_USER");


        employeeRepository.save(employee2);
        roleRepository.save(userRole2);
        employeeRepository.save(employee1);
        roleRepository.save(userRole);

        Employee admin = new Employee("admin", "admin@domain.com", "admin","202-594-7406", "Joseph", "Joseph", true);
        Role adminRole1 = new Role ("admin", "ROLE_ADMIN");
        Role adminRole2 = new  Role ("admin", "ROLE_USER");

        employeeRepository.save(admin);
        roleRepository.save(adminRole1);
        roleRepository.save(adminRole2);

        Department IT = new Department();
        IT.setName("Information Technology");

        Department AV = new Department();
        AV.setName("Audio Visual");

        Department HR = new Department();
        HR.setName("Human Resource");

        Department SE = new Department();
        SE.setName("Sales");

        departmentRepository.save(IT);
        departmentRepository.save(AV);
        departmentRepository.save(HR);
        departmentRepository.save(SE);

        employee1.setDepartment(HR);
        employee2.setDepartment(IT);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);


    }
}
