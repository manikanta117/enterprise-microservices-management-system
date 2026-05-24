package com.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectAssignment {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long projectId;
	    private Long employeeId;
		public ProjectAssignment() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ProjectAssignment(Long id, Long projectId, Long employeeId) {
			super();
			this.id = id;
			this.projectId = projectId;
			this.employeeId = employeeId;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getProjectId() {
			return projectId;
		}
		public void setProjectId(Long projectId) {
			this.projectId = projectId;
		}
		public Long getEmployeeId() {
			return employeeId;
		}
		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}
		@Override
		public String toString() {
			return "ProjectAssignment [id=" + id + ", projectId=" + projectId + ", employeeId=" + employeeId + "]";
		}
	    
}
