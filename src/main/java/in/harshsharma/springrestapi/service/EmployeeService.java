package in.harshsharma.springrestapi.service;

import java.util.List;

import in.harshsharma.springrestapi.model.Employee;

public interface EmployeeService {

	
	
	
	
	List<Employee> getEmployees(int pageNumber, int pageSize);
	
	Employee saveEmployee (Employee employee);
	
	Employee getSingleEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee);
	

	
	
	
//	List<Employee> getEmployeeByName(String name);
//	
//	List<Employee> getEmployeeByNameAndLocation(String name, String location);
//	
//	List<Employee> getEmployeeByKeyword(String name);
//	
//	List<Employee> getEmployeeByNameOrLocation(String name, String location);
//	
//	Integer deleteEmployeeByName (String name); 
}
