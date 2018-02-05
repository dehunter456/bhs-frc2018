package org.usfirst.frc.team6727.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team6727.robot.RobotMap;
import org.usfirst.frc.team6727.robot.commands.DriveTrainCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.*;

/**
 *
 */
public class DriveTrainSubsystem extends Subsystem {

    private VictorSPX leftMaster, rightMaster, leftFollower, rightFollower;
    
    public DriveTrainSubsystem () {
    	leftMaster = new VictorSPX(RobotMap.LEFT_MASTER);
        rightMaster = new VictorSPX(RobotMap.RIGHT_MASTER);
        leftFollower = new VictorSPX(RobotMap.LEFT_FOLLOWER);
        rightFollower = new VictorSPX(RobotMap.RIGHT_FOLLOWER);
        
        configureRampRate(0.5, 0);
		configureNeutralMode("break");
		
		leftFollower.follow(leftMaster);
		rightFollower.follow(rightMaster);
    }
    
    public void configureRampRate(double secondsFromNeutralToFull, int timeoutMS) {
		leftMaster.configOpenloopRamp(secondsFromNeutralToFull, timeoutMS);
		rightMaster.configOpenloopRamp(secondsFromNeutralToFull, timeoutMS);
		leftFollower.configOpenloopRamp(0, 0);
		rightFollower.configOpenloopRamp(0, 0);
	}
	
	public void configureNeutralMode(String mode) {
		switch(mode) {
			case("brake"):
				leftMaster.setNeutralMode(NeutralMode.Brake);
				rightMaster.setNeutralMode(NeutralMode.Brake);
				leftFollower.setNeutralMode(NeutralMode.Brake);
				rightFollower.setNeutralMode(NeutralMode.Brake);
				break;
			case("coast"):
				leftMaster.setNeutralMode(NeutralMode.Coast);
				rightMaster.setNeutralMode(NeutralMode.Coast);
				leftFollower.setNeutralMode(NeutralMode.Coast);
				rightFollower.setNeutralMode(NeutralMode.Coast);
				break;
			default:
				break;
		}
	}
    
    public void tankDrive (double lVel, double rVel) {
    	/* Allows the robot to drive using the left and right motor. Each side is controlled using the
    	 * given velocities.
    	 * @param lVel A double from -1.0 to 1.0 that controls the left motor's velocity.
    	 * @param rVel A double from -1.0 to 1.0 that controls the right motor's velocity. */
    	
    	leftMaster.set(ControlMode.PercentOutput, lVel);
    	rightMaster.set(ControlMode.PercentOutput, rVel);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveTrainCommand());
    }
}

