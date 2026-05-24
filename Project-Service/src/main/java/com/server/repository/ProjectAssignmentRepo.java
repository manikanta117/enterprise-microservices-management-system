package com.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.model.ProjectAssignment;

public interface ProjectAssignmentRepo
extends JpaRepository<ProjectAssignment, Long> {

List<ProjectAssignment> findByProjectId(Long projectId);
}
