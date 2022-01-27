package exception.custom;

public class DAO {
	
	public int addEmpVacation(EmpDto dto, int days) throws EmpException {
		// DB 정합성, 무결성 체크
		if(!dto.getEmpNo().contains("emp")) {
			throw new EmpException("ERR_03", "사원의 사번이 emp를 포함하지 않습니다.");
		}
		System.out.println("사원 " + dto.getEmpNo() + " 의 휴가를 등록했습니다.");
		return 1;
		
	}
}
