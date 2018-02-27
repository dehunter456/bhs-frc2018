package org.usfirst.frc.team6727.robot.subsystems;

import org.usfirst.frc.team6727.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ActiveIntake extends Subsystem {

    private VictorSPX intakeMotor;

    public ActiveIntake () {
    	intakeMotor = new VictorSPX(RobotMap.INTAKE);
    	
    	intakeMotor.configOpenloopRamp(0.5, 0);
        intakeMotor.setNeutralMode(NeutralMode.Brake);
    }
    
    public void rotateMotor (double vel) {
    	intakeMotor.set(ControlMode.PercentOutput, vel);
    }
    
    public void initDefaultCommand () {
        
    }
}

