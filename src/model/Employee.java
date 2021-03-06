package model;

import java.util.Date;

/**
 * @author Rodrigo Dias Soares
 */
public class Employee extends Person{
    
    private String role;
    private double salary;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
