package design.singleton;

import java.time.LocalDateTime;

public class Logger {
	// 3번째 방법
//	static {
//		 logger = new Logger();
//	}
	
	// 1. 생성자를 private으로 생성
	private Logger() {}
	
	// 2. 자신의 타입의 멤버변수
//	private static Logger logger;
	private static Logger logger = new Logger();
	
	// 3. 외부에서 객체에 접근할 수 있는 getInstance() 제공 -> public
	public static Logger getInstance() {
		// 첫번쨰
//		if(logger == null) {
//			logger = new Logger();
//		}
		return logger;
	}
	
	
	
	public void log(String message) {
		LocalDateTime ldt = LocalDateTime.now();
		String date = ldt.getYear() + " / " + ldt.getMonthValue() + " / " + ldt.getDayOfMonth();
		String time = ldt.getHour() + " : " + ldt.getMinute() + " : " + ldt.getSecond();
		
		System.out.println("[" + date + " " + time + "]" + message);
		
	}
}
