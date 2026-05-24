package com.server.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Project {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	 @Column(name = "project_name")
	    private String projectName;

	    @Column(name = "project_code", unique = true)
	    private String projectCode;

	    private LocalDate startDate;
	    private LocalDate endDate;

	    private BigDecimal budget;

		public Project() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Project(Long id, String projectName, String projectCode, LocalDate startDate, LocalDate endDate,
				BigDecimal budget) {
			super();
			this.id = id;
			this.projectName = projectName;
			this.projectCode = projectCode;
			this.startDate = startDate;
			this.endDate = endDate;
			this.budget = budget;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public String getProjectCode() {
			return projectCode;
		}

		public void setProjectCode(String projectCode) {
			this.projectCode = projectCode;
		}

		public LocalDate getStartDate() {
			return startDate;
		}

		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}

		public LocalDate getEndDate() {
			return endDate;
		}

		public void setEndDate(LocalDate endDate) {
			this.endDate = endDate;
		}

		public BigDecimal getBudget() {
			return budget;
		}

		public void setBudget(BigDecimal budget) {
			this.budget = budget;
		}

		@Override
		public String toString() {
			return "Project [id=" + id + ", projectName=" + projectName + ", projectCode=" + projectCode
					+ ", startDate=" + startDate + ", endDate=" + endDate + ", budget=" + budget + "]";
		}

	
	    
}
