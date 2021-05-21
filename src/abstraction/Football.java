package abstraction;
import java.awt.Color;

public class Football {

	private int radius;
	private Color color;
	
	private double positionX;
	private double positionY;
	private double speed;
	private double acceleration;
	
	public Football(Color color, int radius) {
		this.color = color;
		this.radius = radius;
		
		positionX = 0.0;
		positionY = 0.0;
		speed = 0.0;
		acceleration = 0.0;
	}
	
	// TODO Implement class
}
