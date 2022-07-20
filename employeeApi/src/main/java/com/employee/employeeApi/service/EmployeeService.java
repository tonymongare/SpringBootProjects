package com.employee.employeeApi.service;

import com.employee.employeeApi.model.Employee;
import com.employee.employeeApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }


    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
        }

    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        return employeeRepository.save(emp);
    }


}
