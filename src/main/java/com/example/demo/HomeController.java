package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/home")
    public String index(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employee", new Employee());
        return "userregistration";
    }

    @PostMapping("/processregister")
    public String processRegistrationPage(
            @Valid @ModelAttribute("user") Employee employee,
            BindingResult result, Model model){
        if(result.hasErrors()){
            employee.clearPassword();
            model.addAttribute("user", employee);
            return "register";
        }
        else{
            model.addAttribute("user", employee);
            model.addAttribute("message", "New user Account Created");

            employee.setEnabled(true);
            employeeRepository.save(employee);
            Role role = new Role(employee.getUsername(), "ROLE_USER");
            roleRepository.save(role);
        }
        return "redirect:/";
    }

    @RequestMapping("/employee")
    public String secure (Principal principal, Model model){
        String username = principal.getName();
        Employee employee =employeeRepository.findByUsername(username);
        model.addAttribute("employee", employee);
        return "employee";
    }

    @RequestMapping("/")
    public String showAllDPT(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "index";
    }

    @RequestMapping("/listemployees")
    private String listDPT(Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        return "allemployees";
    }

    @RequestMapping("/viewemployees/{id}")
    private String listbyID(@PathVariable("id") long id, Model model){
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return "viewemployee";
    }

    @RequestMapping("/elements")
    public String elements(){
        return "elements";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/userregistration")
    public String processUpdateFrom(@Valid Employee employee, BindingResult result)
    {
        if(result.hasErrors()){
            return "userregistration";
        }
        employee.setEnabled(true);
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @PostMapping("/dptformprocess")
    public String processDPTForm(@ModelAttribute Department department){
        departmentRepository.save(department);
        return "redirect:/";
    }


    @RequestMapping("/departmentform")
    public String dptForm(Model model){
        model.addAttribute("department", new Department());
        return "departmentform";
    }


    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id")long id,Model model){
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("employee", employeeRepository.findById(id).get());
        return "userregistration";
    }

    @RequestMapping("/disableuser/{id}")
    public String disableEnable(@PathVariable("id") long id, Model model){
        Employee employee = employeeRepository.findById(id).get();
        employee.setEnabled(false);
        employeeRepository.save(employee);
        return "redirect:/";
    }



}


