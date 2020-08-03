package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("employees", new Employees());
        return "register";
    }

    @GetMapping("/registernew")
    public String processNewEmployee(
            @Valid @ModelAttribute("employees") Employees employees,
            BindingResult result, Model model){
        if(result.hasErrors()){
            employees.clearPassword();
            model.addAttribute("employees", employees);
            return "register";
        }
        else {
            model.addAttribute("employees", employees);
            model.addAttribute("message", "New Employee has been added");

            employees.setEnabled(true);
            employeeRepository.save(employees);

            Role role = new Role(employees.getUsername(), "ROLE_USER");
            roleRepository.save(role);
        }
        return "redirect:/";
    }

}
