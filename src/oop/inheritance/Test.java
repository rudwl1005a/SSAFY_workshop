package oop.inheritance;

import oop.inheritance.another.Parent;

public class Test {
	public static void main(String[] args) {
		GrandParent gp = new GrandParent();
		System.out.println(gp.name);
		
		Parent p = new Parent("ssafy");
		System.out.println(p.name);
		System.out.println(p.age);
		
		Child c = new Child("ssafy2", 20);
		System.out.println(c.name);
		System.out.println(c.age);
		
	}
}
