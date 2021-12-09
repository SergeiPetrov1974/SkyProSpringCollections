package pro.sky.skyprospringcollections.service;

import pro.sky.skyprospringcollections.data.Employee;

import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Set<Employee> getEmployeeList();
}