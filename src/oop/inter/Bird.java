package oop.inter;

public class Bird extends Animal implements Fly {

	@Override
	public void howToFly() {
		System.out.println("By Wings!");
	}

	@Override
	public void howFastFly() {
		System.out.println("50km/h!");
	}

}
