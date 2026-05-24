package com.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.model.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
