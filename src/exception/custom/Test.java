package exception.custom;

public class Test {
	
	public static void main(String[] args) {
		Controller controller = new Controller();
		EmpDto dto = new EmpDto();
//		EmpDto dto = null; // RuntimeException을 발생시키는 코드는 버그 - 반드시 해결!
		// 클라이언트에게 내용 전달
				
		dto.setEmpNo("emp3125");
		try {
			int ret = controller.addEmpVacation(dto, 3);
			if(ret == -1) {
				/// 처리
			}
		} catch (EmpException e) {
			if("ERR_01".equals(e.getExCode())) {
				// log
				// UI
				System.out.println(e.exCode + " : " + e.getMessage());
			} else if("ERR_02".equals(e.getExCode())) {
				System.out.println(e.exCode + " : " + e.getMessage());
			} else if("ERR_03".equals(e.getExCode())) {
				System.out.println(e.exCode + " : " + e.getMessage());
			}
		}
	}
	
}

// 필수사항(Custom Exception 활용)
// 1. 사원 정보가 null이면 안된다. => 해결해야 할 항목
// 2. 사원의 사번이 null이면 안된다.	: ERR_01 <= Controller에서 처리
// 3. 사원의 휴가일수는 5일 이하		: ERR_02 <= Service에서 처리
// 4. 사원의 사번이 emp를 포힘해야 한다.	: ERR_03 <= DAO에서 처리

// 위 사항에 대해서는 한 개의 커스텀 예외를 만들어 처리한다.