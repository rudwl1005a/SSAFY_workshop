package io.xml;

public class EmpDto {
	private String empId;
	private String empNm;
	private int salary;
	
	public EmpDto() {}

	public EmpDto(String empId, String empNm, int salary) {
		super();
		this.empId = empId;
		this.empNm = empNm;
		this.salary = salary;
	}
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "EmpDto [empId=" + empId + ", empNm=" + empNm + ", salary=" + salary + "]";
	}
	
}
