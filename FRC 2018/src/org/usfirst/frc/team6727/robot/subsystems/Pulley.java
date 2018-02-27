package org.usfirst.frc.team6727.robot.subsystems;

import org.usfirst.frc.team6727.robot.RobotMap;
import org.usfirst.frc.team6727.robot.commands.UseLift;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pulley extends Subsystem {

    private VictorSPX pulleyMotor;

    public Pulley () {
        pulleyMotor = new VictorSPX(RobotMap.PULLEY);
        
        pulleyMotor.configOpenloopRamp(0.5, 0);
        pulleyMotor.setNeutralMode(NeutralMode.Brake);
    }
    
    public void useLift (double motorVel) {
    	pulleyMotor.set(ControlMode.PercentOutput, motorVel);
    }

	protected void initDefaultCommand() {
		setDefaultCommand(new UseLift());
		
	}
}

