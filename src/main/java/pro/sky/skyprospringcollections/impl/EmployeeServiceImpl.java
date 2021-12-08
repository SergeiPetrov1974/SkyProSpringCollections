package pro.sky.skyprospringcollections.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyprospringcollections.data.Employee;
import pro.sky.skyprospringcollections.exceptions.EmployeeDuplicateException;
import pro.sky.skyprospringcollections.exceptions.EmployeeNotFound;
import pro.sky.skyprospringcollections.service.EmployeeService;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Set<Employee> employees = new HashSet<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.add(employee)) {
            return employee;
        }
        throw new EmployeeDuplicateException();
    }

    @Override
    public Employee getEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFound();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFound();

    }

    @Override
    public Set<Employee> getEmployeeList() {
        return employees;
    }
}

