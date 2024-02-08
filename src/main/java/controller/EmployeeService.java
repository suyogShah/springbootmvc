package controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import EmployeeResponse.GlobalException;
import EmployeeResponse.response;
import Repository.EmployeeRepository;
import dto.EmplyoeeDto;
import model.Employee;



@Component
public class EmployeeService implements EmployeeInterface{
	
	
	private EmployeeRepository res;
	
	private ModelMapper modelMapper;

	@Override
	public response getemployee(long id) throws GlobalException {
		try {
			return new response("Employee Details",res.findById(String.valueOf(id)));
		}catch(Exception e)
		{
			
		throw new GlobalException("Employee Details not found",HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public response getallemployee() throws GlobalException {
		try {
			return new response("Employee Details",res.findAll());
		}catch(Exception e)
		{
			
		throw new GlobalException("Employee etails not found",HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public response saveEmployee(EmplyoeeDto empdto) throws GlobalException {
		Employee emp=modelMapper.map(empdto, Employee.class);
		
		try
		{
			return new response("Employee Details",res.save(emp));
		}catch(Exception e)
		{
			throw new GlobalException("employee details not found",HttpStatus.BAD_REQUEST);
		}
		
	}

	@Override
	public response delete(long id) throws GlobalException {
		try {
			 res.deleteById(String.valueOf(id));
			return new response("Employee details deleted succesfully",null);
			}catch (Exception e) {
			throw new GlobalException("Employee details not found",HttpStatus.BAD_REQUEST);
			} 
	}
	}

	
