package oop.inheritance.another;

import oop.inheritance.GrandParent;

public class Parent extends GrandParent {
	public int age = 40;
	
	// Implicit super constructor GrandParent() is not visible.
	// Must explicitly invoke another constructor
	protected Parent() { }
	public Parent(String name){
		super(name);
	}
	protected Parent(String name, int age){
		super(name);
		this.age = age;
	}
}
