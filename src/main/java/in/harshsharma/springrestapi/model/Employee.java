package in.harshsharma.springrestapi.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.harshsharma.springrestapi.request.EmployeeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
//	@JoinColumn(name = "department_id")
//	@OneToOne
//	private Department department;
	
	@OneToMany(mappedBy = "employee")
	private List<Department> departments;
	
	public Employee(EmployeeRequest req) {
		this.name = req.getName();
	}
	
	
	

	

	
	
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//
//	private Long id;
//	
//	@NotBlank(message="Name should not be null")
//	private String name;
//	
//	private Long age = 0L;
//	
//	private String location;
//	
//	@Email(message="Please enter valid email")
//	private String email;
//	
//	@NotBlank(message="Department should not be null")
//	private String department;
//	
//	@CreationTimestamp
//	@Column(name = "created_at", nullable = false, updatable = false)
//	private Date createdAt;
//	
//	@UpdateTimestamp
//	@Column(name = "updated_at")  
//	private Date updatedAt;
	

}
