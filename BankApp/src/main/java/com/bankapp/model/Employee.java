package com.bankapp.model;

public class Employee {
    private int employee_id;
    private String employee_pass;

public  Employee(){

}
    public Employee(int employee_id, String employee_pass) {
        this.employee_id = employee_id;
        this.employee_pass = employee_pass;
    }

    public int getEmployeeID() {
        return employee_id;
    }

    public void setEmployeeID(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_pass() {
        return employee_pass;
    }

    public void setEmployee_pass(String employee_pass) {
        this.employee_pass = employee_pass;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employee_id +
                ", employee_pass='" + employee_pass + '\'' +
                '}';
    }
}
