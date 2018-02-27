package org.usfirst.frc.team6727.robot.commands;

import org.usfirst.frc.team6727.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive extends Command {

    public Drive () {
        requires(Robot.driveTrainSub);
    }

    // Called just before this Command runs the first time
    protected void initialize () {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute () {
    	double leftStickValue = Robot.m_oi.getController().getRawAxis(1), 
    			rightStickValue = Robot.m_oi.getController().getRawAxis(5);
    	
    	Robot.driveTrainSub.tankDrive(-leftStickValue, rightStickValue);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished () {
        return false;
    }

    // Called once after isFinished returns true
    protected void end () {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
