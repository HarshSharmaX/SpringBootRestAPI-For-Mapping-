package in.harshsharma.springrestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.harshsharma.springrestapi.model.Employee;
import in.harshsharma.springrestapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployees(int pageNumber, int pageSize) {
		Pageable pages = PageRequest.of(pageNumber, pageSize, Direction.DESC, "id");
		return eRepository.findAll(pages).getContent();
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return eRepository.save(employee);
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		// TODO Auto-generated method stub
		 Optional<Employee> employee = eRepository.findById(id);
		 if(employee.isPresent()) {
			 return employee.get();
		 }
		 throw new RuntimeException("No Employee is Present for the id "+id);
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		eRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return eRepository.save(employee);
	}


	
	
	
	
//	@Override
//	public List<Employee> getEmployeeByName(String name) {
//		// TODO Auto-generated method stub
//		return eRepository.findByName(name);
//	}
//
//	@Override
//	public List<Employee> getEmployeeByNameAndLocation(String name, String location) {
//		// TODO Auto-generated method stub
//		return eRepository.findByNameAndLocation(name, location);
//	}
//
//	@Override
//	public List<Employee> getEmployeeByKeyword(String name) {
//		Sort sort = Sort.by(Sort.Direction.ASC,"id");
//		return eRepository.findByNameContaining(name, sort);
//	}
//
//	@Override
//	public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
//		// TODO Auto-generated method stub
//		return eRepository.getEmployeesByNameAndLocation(name, location);
//	}
//
//	@Override
//	public Integer deleteEmployeeByName(String name) {
//		// TODO Auto-generated method stub
//		return eRepository.deleteEmployeeByName(name);
//	}
	
	

	
//	private static List<Employee> list = new ArrayList<> ();
//	
//	static {
//		Employee e = new Employee();
//		e.setName("Harsh");
//		e.setAge(21L);
//		e.setLocation("Delhi");
//		e.setEmail("harshsharma@gmail.com");
//		e.setDepartment("Information Technology");
//		list.add(e);
//		
//		e = new Employee();
//		e.setName("Varun");
//		e.setAge(22L);
//		e.setLocation("Mumbai");
//		e.setEmail("pruthiji@gmail.com");
//		e.setDepartment("Commerce");
//		list.add(e);
//	}
}
