package in.harshsharma.springrestapi.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.harshsharma.springrestapi.model.Department;
import in.harshsharma.springrestapi.model.Employee;
import in.harshsharma.springrestapi.repository.DepartmentRepository;
import in.harshsharma.springrestapi.repository.EmployeeRepository;
import in.harshsharma.springrestapi.request.EmployeeRequest;
import in.harshsharma.springrestapi.response.DepartmentResponse;
import in.harshsharma.springrestapi.response.EmployeeResponse;
import in.harshsharma.springrestapi.service.EmployeeService;


@RestController   //@Controller + @ResponseBody
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService ;
	
	@Autowired
	private EmployeeRepository eRepo;
	
	@Autowired
	private DepartmentRepository dRepo;
	
	//@RequestMapping(value = "/employees" , method = RequestMethod.GET)
//	@GetMapping("/employees")
//	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
//		return new ResponseEntity<List<Employee>> (eService.getEmployees(pageNumber, pageSize), HttpStatus.OK);
//	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeResponse>> getDepartments () {
		List<Employee> list = eRepo.findAll();
		List<EmployeeResponse> responseList = new ArrayList<>();
		list.forEach(e -> {
			EmployeeResponse eResponse = new EmployeeResponse();
			eResponse.setId(e.getId());
			eResponse.setEmployeeName(e.getName());
			List<String> depts = new ArrayList<>();
			for(Department d : e.getDepartments()) {
				depts.add(d.getName());
			}
			eResponse.setDepartment(depts);
			responseList.add(eResponse);
		});
		return new ResponseEntity<List<EmployeeResponse>>(responseList,HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
		return new ResponseEntity<Employee>(eService.getSingleEmployee(id),HttpStatus.OK);
	}
	
	@PostMapping("/employees")
	public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
		Employee employee = new Employee(eRequest);
		employee = eRepo.save(employee);
		
		for(String s : eRequest.getDepartment()) {
			Department dept = new Department();
			dept.setName(s);
			dept.setEmployee(employee);
			
			dRepo.save(dept);
		}
		return new ResponseEntity<String>("Record Saved Successfully",HttpStatus.CREATED) ;
		
//		Department dept = new Department();
//		dept.setName(eRequest.getDepartment());
//		
//		dept = dRepo.save(dept);
//		
//		Employee employee = new Employee(eRequest);
//		employee.setDepartment(dept);
//		
//		employee = eRepo.save(employee);
//		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return new ResponseEntity<Employee>(eService.updateEmployee(employee),HttpStatus.OK);
	}
	
	@DeleteMapping("/employees")
	public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT) ;
	}
	

	
	
	
//	@GetMapping("/employees/filter")
//	public ResponseEntity<List<Employee>> getEmployeeByDepartmentName (@RequestParam String name ) {
////		return new ResponseEntity<List<Employee>>(eRepo.findByDepartmentName(name),HttpStatus.OK)
//		return new ResponseEntity<List<Employee>>(eRepo.getEmployeesByDeptName(name),HttpStatus.OK);
//	}
	
	
//	@PostMapping("/employees")
//	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody EmployeeRequest eRequest) {
//		Department dept = new Department();
//		dept.setName(eRequest.getDepartment());
//		
//		dept = dRepo.save(dept);
//		
//		Employee employee = new Employee(eRequest);
//		employee.setDepartment(dept);
//		
//		employee = eRepo.save(employee);
//		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
//	}
	
	
//	@GetMapping("/employees/filterByName")
//	public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
//		return new ResponseEntity<List<Employee>> (eService.getEmployeeByName(name), HttpStatus.OK);
//	}
//	
//	@GetMapping("/employees/filterByNameAndLocation")
//	public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name, @RequestParam String location) {
//		return new ResponseEntity<List<Employee>> (eService.getEmployeeByNameAndLocation(name, location), HttpStatus.OK);
//	}
//	
//	@GetMapping("/employees/filterByKeyword")
//	public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name) {
//		return new ResponseEntity<List<Employee>> (eService.getEmployeeByKeyword(name), HttpStatus.OK);
//	}
//	
//	@GetMapping("/employees/{name}/{location}")
//	public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location) {
//		return new ResponseEntity<List<Employee>> (eService.getEmployeeByNameOrLocation(name, location), HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/employees/delete/{name}")
//	public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name) {
//		return new ResponseEntity<String> (eService.deleteEmployeeByName(name)+" Number of records Deleted", HttpStatus.OK);
//	}
	
	
//	@Value("${app.name}")
//	public String appName;
//	
//	@Value("${app.version}")
//	public String appVersion;
//	
//	@GetMapping("/version")
//	public String getAppDetails() {
//		return appName + " - " + appVersion;
//	}

}
