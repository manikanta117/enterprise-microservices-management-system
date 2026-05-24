package com.server.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="dept_name",length = 100 , nullable = false)
	private String depname;
	@Column(name="dep_code",length=50,unique=true,nullable = false)
	private String deptCode;
	@Column(length=50)
	private String location;
	@Column(name="created-at")
	private LocalDateTime createdat;
	public department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public department(long id, String depname, String deptCode, String location, LocalDateTime createdat) {
		super();
		this.id = id;
		this.depname = depname;
		this.deptCode = deptCode;
		this.location = location;
		this.createdat = createdat;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getCreatedat() {
		return createdat;
	}
	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}
	@Override
	public String toString() {
		return "department [id=" + id + ", depname=" + depname + ", deptCode=" + deptCode + ", location=" + location
				+ ", createdat=" + createdat + "]";
	}
	
}
