package oop.inheritance;

import oop.inheritance.another.Parent;

public class Child extends Parent {
	Child() {}
	Child(String name){
		super(name);
	}
	Child(String name, int age){
		super(name, age);
	}
}
