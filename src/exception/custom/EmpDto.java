package exception.custom;

public class EmpDto {
	private String empNo; // 사번

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	
	public EmpDto() {}
	public EmpDto(String empNo) {
		super();
		this.empNo = empNo;
	}
	
	
}
