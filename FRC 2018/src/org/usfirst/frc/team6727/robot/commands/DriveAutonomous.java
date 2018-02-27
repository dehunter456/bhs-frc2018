package org.usfirst.frc.team6727.robot.commands;

import org.usfirst.frc.team6727.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAutonomous extends Command {
	
	private Timer timer;

    public DriveAutonomous() {
        requires(Robot.driveTrainSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    	System.out.println("hi");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrainSub.tankDrive(1, 1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timer.get() < 3) {
        	return false;
        }
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
