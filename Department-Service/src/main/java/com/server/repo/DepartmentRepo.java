package com.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.model.department;
@Repository
public interface DepartmentRepo extends JpaRepository<department, Long> {

}
