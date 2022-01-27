package exception.custom;

public class EmpException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	String exCode;

	public EmpException() {}
	
	public EmpException(String exCode) {
		super("기본 메세지");
		this.exCode = exCode;
	}
	
	public EmpException(String exCode, String message) {
		super(message);
		this.exCode = exCode;
	}

	public String getExCode() {
		return exCode;
	}

	public void setExCode(String exCode) {
		this.exCode = exCode;
	}

}
