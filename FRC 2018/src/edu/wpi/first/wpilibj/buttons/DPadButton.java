package edu.wpi.first.wpilibj.buttons;

import edu.wpi.first.wpilibj.Joystick;

public class DPadButton extends Button {
	
	private Joystick joystick;
	private Direction direction;
	
	public DPadButton (Joystick joystick, Direction direction) {
		this.joystick = joystick;
		this.direction = direction;
	}

	@Override
	public boolean get() {
		int degree = joystick.getPOV(0);
		
		return degree == direction.degree;
	}
	
	public enum Direction {
		Up (0), Down (180), Right (90), Left (270);
		
		int degree;
		Direction (int degree) {
			this.degree = degree;
		}
	}

}
