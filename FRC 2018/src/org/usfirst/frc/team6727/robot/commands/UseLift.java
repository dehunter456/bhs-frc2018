package org.usfirst.frc.team6727.robot.commands;

import org.usfirst.frc.team6727.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UseLift extends Command {

    public UseLift() {
        requires(Robot.pulleySub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double motorVel = Robot.m_oi.getController().getRawAxis(3) - Robot.m_oi.getController().getRawAxis(2);
    	
    	Robot.pulleySub.useLift(motorVel * 0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
