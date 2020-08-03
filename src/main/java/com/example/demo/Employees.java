package com.example.demo;

import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
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

    @Column(name="username")
    @Size(min=3)
    private String username;

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

    public Employees() {
    }

    public Employees(@Size(min = 3) String jobTitle,
                     @Size(min = 3) String username,
                     @Size(min = 3) String firstName,
                     @Size(min = 3) String lastName, String password, boolean enabled) {
        this.jobTitle = jobTitle;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void clearPassword() {
        this.password = "";
    }
}
