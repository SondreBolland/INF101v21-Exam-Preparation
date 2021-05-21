package inheritance;

import java.awt.Color;

public class Person {
	
	private int age;
	private double height;
	private Color hairColor;
	
	public Person(int age, double height, Color hairColor) {
		this.age = age;
		this.height = height;
		this.hairColor = hairColor;
	}
	
	public void talk(String text) {
		System.out.println(text);
	}
}
