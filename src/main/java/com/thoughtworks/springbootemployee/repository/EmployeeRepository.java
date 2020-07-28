package com.thoughtworks.springbootemployee.repository;

import com.thoughtworks.springbootemployee.entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeRepository {
    List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Employee getEmployeeById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }

    public void updateEmployeeById(int id, Employee newEmployee) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employee.setId(newEmployee.getId());
                employee.setName(newEmployee.getName());
                employee.setAge(newEmployee.getAge());
                employee.setGender(newEmployee.getGender());
            }
        }
    }

    public void deleteEmployeeById(int id) {
        for (int i = employees.size() - 1; i >= 0; i--) {
            Employee result = employees.get(i);
            if (result.getId() == id) {
                employees.remove(result);
            }
        }
    }
}
