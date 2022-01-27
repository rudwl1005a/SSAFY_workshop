package design.singleton;

public class Test {
	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		logger.log("test Message");

		Logger logger2 = Logger.getInstance();
		logger2.log("test2 Message");
		
		MySingleton singleton = MySingleton.getInstance();
		singleton.talk("경대");
	}
}
