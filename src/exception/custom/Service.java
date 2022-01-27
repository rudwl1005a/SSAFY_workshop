package exception.custom;

public class Service {
	
	public int addEmpVacation(EmpDto dto, int days) throws EmpException {
		// 업무 로직 체크
		if(days>5) {
			throw new EmpException("ERR_02", "휴가 일수가 5일을 초과합니다.");
		}
		
		DAO dao = new DAO();
		return dao.addEmpVacation(dto, days);
		
	}
}
