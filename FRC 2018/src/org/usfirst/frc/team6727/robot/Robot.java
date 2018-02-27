package org.usfirst.frc.team6727.robot;

import org.usfirst.frc.team6727.robot.commands.DriveAutonomous;
import org.usfirst.frc.team6727.robot.subsystems.ActiveIntake;
import org.usfirst.frc.team6727.robot.subsystems.DriveTrain;
import org.usfirst.frc.team6727.robot.subsystems.Pulley;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
	
	public static OI m_oi;
	public static DriveTrain driveTrainSub = new DriveTrain();
	public static Pulley pulleySub = new Pulley();
	public static ActiveIntake intakeSub = new ActiveIntake();
	Command autonomous_command;

	public void robotInit() {
		m_oi = new OI();
		autonomous_command = new DriveAutonomous();
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		autonomous_command.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	public void testPeriodic() {
		
	}
}
