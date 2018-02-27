/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6727.robot;

import org.usfirst.frc.team6727.robot.commands.DropCube;
import org.usfirst.frc.team6727.robot.commands.GrabCube;
import org.usfirst.frc.team6727.robot.commands.ShiftSpeed;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.DPadButton;
import edu.wpi.first.wpilibj.buttons.DPadButton.Direction;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick controller;
	
	public OI () {
		controller = new Joystick(0);
		
		JoystickButton lBumper = new JoystickButton(controller, 6);
		JoystickButton rBumper = new JoystickButton(controller, 5);
		
		DPadButton up = new DPadButton(controller, Direction.Up);
		DPadButton left = new DPadButton(controller, Direction.Left);
		DPadButton down = new DPadButton(controller, Direction.Down);
		DPadButton right = new DPadButton(controller, Direction.Right);
		
		lBumper.whileHeld(new GrabCube());
		rBumper.whileHeld(new DropCube());
		
		up.whenPressed(new ShiftSpeed(1.0));
		left.whenPressed(new ShiftSpeed(0.75));
		down.whenPressed(new ShiftSpeed(0.5));
		right.whenPressed(new ShiftSpeed(0.25));
	}
	
	public Joystick getController () {
		return controller;
	}
	
}
