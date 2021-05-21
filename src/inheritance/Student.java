package inheritance;

import java.awt.Color;

public class Student extends Person {
	
	private int studentNumber;

	public Student(int age, double height, Color hairColor, int studentNumber) {
		super(age, height, hairColor);
		this.studentNumber = studentNumber;
	}
	
	@Override
	public void talk(String text) {
		text.addVoiceCrack();
		System.out.println(text);
	}
	
	public void talkWithConfidence(String text) {
		super.talk(text);
	}

}
