package com.employee.employeeApi.controller;

import com.employee.employeeApi.model.Employee;
import com.employee.employeeApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //Post
    @PostMapping(value = "/employees")
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }

    //get
    @GetMapping(value = "/employees")
    public List<Employee> readEmployees() {
        return employeeService.getEmployees();
    }

    //put
    @PutMapping(value = "/employees/{empId}")
    public Employee readEmployees(@PathVariable(value = "empId") Long id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id,employeeDetails);

    }
    //delete
    @DeleteMapping(value = "/employees/{empId}")
    public void deleteEmployees(@PathVariable(value = "empId") Long id) {
        employeeService.deleteEmployee(id);
    }

}
