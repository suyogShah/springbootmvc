package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import EmployeeResponse.GlobalException;
import EmployeeResponse.response;
import dto.EmplyoeeDto;
@Controller
@RequestMapping("api/v2/customer")
public class EmployeeController {

	@Autowired
	private EmployeeInterface empint;
	

	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?>getemployeeDetailbyId(@PathVariable ("id") long id) throws GlobalException{
		return new ResponseEntity<response>(empint.getemployee(id),HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<?>getAllEmployee()throws GlobalException{
		return new ResponseEntity<response>(empint.getallemployee(),HttpStatus.OK);
		
		
		
	}
	@PostMapping("/post")
	public ResponseEntity<?>saveEmployee(EmplyoeeDto empdto)throws GlobalException{
		return new ResponseEntity<response>(empint.saveEmployee(empdto),HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>DeleteEmployee(@PathVariable("id") long id)throws GlobalException{
		return new ResponseEntity<response>(empint.delete(id),HttpStatus.OK);
	}
	
}

