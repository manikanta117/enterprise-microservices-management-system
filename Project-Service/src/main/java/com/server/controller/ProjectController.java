	package com.server.controller;
	
	import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	
	import com.server.model.Project;
	import com.server.model.ProjectAssignment;
	import com.server.repository.ProjectAssignmentRepo;
	import com.server.repository.ProjectRepo;
	
	@RestController
	@RequestMapping("/projects")
	public class ProjectController {
	
		  @Autowired
		    private  ProjectRepo repo1;
	
		    @Autowired
		    private ProjectAssignmentRepo repo2;
		    
		    @GetMapping("/test")
		    public String health() {
		        return "Project controller working";
		    }
		    
		    
	
		    // CREATE PROJECT
		    @PostMapping
		    public Project addProject(@RequestBody Project project) {
		        return repo1.save(project);
		    }
	
		    // GET PROJECT BY ID
		    @GetMapping("/{id}")
		    public Project getProject(@PathVariable Long id) {
		        if(repo1.findById(id).isPresent()) {
		        	return repo1.findById(id).get();
		        }
		        else {
		        	 throw new RuntimeException("Project not found");
		        }
		        
		    }
	
		 
		    @GetMapping
		    public List<Project> getAllProjects() {
		        return repo1.findAll();
		    }
	
		    // ASSIGN EMPLOYEE TO PROJECT
		    @PostMapping("/{id}/assign/{empId}")
		    public String assignEmployee(
		            @PathVariable Long id,
		            @PathVariable Long empId) {
	
		        ProjectAssignment pa = new ProjectAssignment();
		        pa.setProjectId(id);
		        pa.setEmployeeId(empId);
	
		        repo2.save(pa);
		        return "Employee assigned successfully";
		    }
		    
		    @GetMapping("/{id}/employees")
		    public List<ProjectAssignment> getEmployeesByProject(@PathVariable Long id) {

		        return repo2.findByProjectId(id);
		    }

		
	}
