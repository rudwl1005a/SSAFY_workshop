package design.singleton;

public class MySingleton {
	
	private MySingleton() {}
	private static MySingleton mysingleton = new MySingleton();
	
	public static MySingleton getInstance() {
		return mysingleton;
	}
	
	public void talk(String  person) {
		System.out.println(person+"가 말하고 있습니다.");
	}
}
