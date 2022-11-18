package in.harshsharma.springrestapi.response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeResponse {

	private Long id;
	
	private String employeeName;
	
	private List<String> department;
}
