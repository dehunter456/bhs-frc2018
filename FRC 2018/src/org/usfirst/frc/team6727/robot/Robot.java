package org.usfirst.frc.team6727.robot;

import org.usfirst.frc.team6727.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends TimedRobot {
	
	public static OI m_oi;
	public static DriveTrainSubsystem driveTrainSub = new DriveTrainSubsystem();

	public void robotInit() {
		m_oi = new OI();
	}

	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		
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
