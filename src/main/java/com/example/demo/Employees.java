package com.example.demo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name="employee_table")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="jobtitle")
    @Size(min=3)
    private String jobTitle;

    @Column(name="firstname")
    @Size(min=3)
    private String firstName;

    @Column(name="last_name")
    @Size(min=3)
    private String lastName;

    @Column(name="password")
    private String password;

    @Column(name="enabled")
    private boolean enabled;

    @ManyToMany(mappedBy = "Employees",
    cascade = CascadeType.REMOVE,
    fetch = FetchType.EAGER)

    private Set<Department> department;


    public Employees() {
    }

    public Employees(@Size(min = 3) String jobTitle,
                     @Size(min = 3) String firstName,
                     @Size(min = 3) String lastName, String password, boolean enabled,
                     Set<Department> department) {
        this.jobTitle = jobTitle;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setPassword(password);
        this.enabled = enabled;
        this.department = department;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String nameName) {
        this.firstName = nameName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }
}
