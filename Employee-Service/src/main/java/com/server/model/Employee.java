package com.server.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="employeee")
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

	    @Column(name = "first_name", length = 100, nullable = false)
	    private String firstName;

	    @Column(name = "last_name", length = 100, nullable = false)
	    private String lastName;

	    @Column(length = 150, unique = true, nullable = false)
	    private String email;

	    @Column(length = 15)
	    private String phone;

	    @Column(name = "department_id", nullable = false)
	    private Long departmentId;

	    @Column(name = "join_date")
	    private LocalDate joinDate;

	    @Column(precision = 10, scale = 2)
	    private BigDecimal salary;

		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(Long id, String firstName, String lastName, String email, String phone, Long departmentId,
				LocalDate joinDate, BigDecimal salary) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.phone = phone;
			this.departmentId = departmentId;
			this.joinDate = joinDate;
			this.salary = salary;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Long getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Long departmentId) {
			this.departmentId = departmentId;
		}

		public LocalDate getJoinDate() {
			return joinDate;
		}

		public void setJoinDate(LocalDate joinDate) {
			this.joinDate = joinDate;
		}

		public BigDecimal getSalary() {
			return salary;
		}

		public void setSalary(BigDecimal salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", phone=" + phone + ", departmentId=" + departmentId + ", joinDate=" + joinDate + ", salary="
					+ salary + "]";
		}
	    

	   
	}


