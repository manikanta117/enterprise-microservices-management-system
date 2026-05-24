package com.server.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.model.Employee;
import com.server.repo.EmployeeRepo;

 

@RestController
@RequestMapping("/employees")
public class EmployeeController {
@Autowired  private EmployeeRepo repo;
@PostMapping("/add")
public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    Employee savedEmployee = repo.save(employee);
    return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
}

@GetMapping("/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
    Optional<Employee> employee = repo.findById(id);
    
    if (employee.isPresent()) {
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


@GetMapping("/show")
public List<Employee> getAllEmployees() {
    return repo.findAll();
}

@PutMapping("id/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    if (repo.existsById(id)) {
        employee.setId(id);
        Employee updatedEmployee = repo.save(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    if (repo.existsById(id)) {
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
