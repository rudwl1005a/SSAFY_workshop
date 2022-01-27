package exception.custom;

public class Controller {
	
	public int addEmpVacation(EmpDto dto, int days) throws EmpException {
		
		if(dto==null) {
			return -1;
		}
		
		if(dto.getEmpNo() == null) {
			throw new EmpException("ERR_01", "전달된 사원정보가 없습니다.");
		}
		
		Service service = new Service();
		return service.addEmpVacation(dto, days);
		
	}
}
