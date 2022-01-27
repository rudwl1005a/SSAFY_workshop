package oop.inter.exercise.consumer;

import oop.inter.exercise.common.AboutMe;
import oop.inter.exercise.supplier.AboutMeImpl;

public class Test {
	public static void main(String[] args) {
		AboutMe someone = new AboutMeImpl();
		System.out.println(someone.yourName());
		System.out.println(someone.yourFavoriteCompany());
		System.out.println(someone.supportMessageToAll());
	}
}
