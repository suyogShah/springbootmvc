package controller;



import EmployeeResponse.GlobalException;
import EmployeeResponse.response;
import dto.EmplyoeeDto;

public interface EmployeeInterface {
	public response getemployee(long id) throws GlobalException;
	public response getallemployee() throws GlobalException;
	public response saveEmployee(EmplyoeeDto empd)throws GlobalException;
	public response delete(long id)throws GlobalException;

	
	
}