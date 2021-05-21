package inheritance;

import java.awt.Color;

public class Student extends Person {
	
	private int studentNumber;

	public Student(int age, double height, Color hairColor, int studentNumber) {
		super(age, height, hairColor);
		this.studentNumber = studentNumber;
	}
	
	public static void main(String[] args) {
		Person sondre = new Student(25, 1.89, Color.black, 69420);
	}

}
