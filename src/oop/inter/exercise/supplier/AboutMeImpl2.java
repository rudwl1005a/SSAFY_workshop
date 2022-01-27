package oop.inter.exercise.supplier;

import oop.inter.exercise.common.AboutMe;

public class AboutMeImpl2 implements AboutMe {

	@Override
	public String yourName() {
		return "민경대";
	}

	@Override
	public String yourFavoriteCompany() {
		return "Naver";
	}

	@Override
	public String supportMessageToAll() {
		return "대기업 취업 가즈아!";
	}
	
}
