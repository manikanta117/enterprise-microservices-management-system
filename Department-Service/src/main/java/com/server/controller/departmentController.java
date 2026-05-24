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

import com.server.model.department;
import com.server.repo.DepartmentRepo;

@RestController
@RequestMapping("/department")
public class departmentController {
@Autowired 
private DepartmentRepo repo;

@GetMapping("/test")
public  ResponseEntity<String> test(){
	return new ResponseEntity<>("Hello",HttpStatus.OK);
}
	@PostMapping("/add")
	public ResponseEntity<department> AddDetails(@RequestBody department dep) {
		department add = repo.save(dep);
		return  new ResponseEntity<>(add,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<department> getDetails(@PathVariable Long id){
		Optional<department> details = repo.findById(id);
		if(details.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
		return new ResponseEntity<>(details.get(),HttpStatus.OK);
		}
	}
	
	@PutMapping("/id/{id}")
	public ResponseEntity<department> updateDep(@PathVariable Long id,@RequestBody department updatedDept){
		Optional<department> existing = repo.findById(id);
		if(existing.isEmpty()) {
			return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			department dep = existing.get();
			dep.setDepname(updatedDept.getDepname());
			dep.setDeptCode(updatedDept.getDeptCode());
			dep.setLocation(updatedDept.getLocation());
			
			repo.save(dep);
			
			return new ResponseEntity<>(dep, HttpStatus.OK);
		}

	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<Void> deleteDep(@PathVariable Long id){
		Optional<department> existing = repo.findById(id);
		
		if(existing.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			 repo.deleteById(id);
			 
			 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/departments")
	public ResponseEntity<List<department>> getAllDepartments() {
	    List<department> departments = repo.findAll();
	    return new ResponseEntity<>(departments, HttpStatus.OK);
	}


}
