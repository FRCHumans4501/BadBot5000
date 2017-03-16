package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.LiftRobot;
import org.usfirst.frc.team4501.robot.commands.stopLiftBot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon liftTalon;
	
	public Lift(){
		liftTalon = new Talon(RobotMap.LIFT_MOTOR);
		System.out.println("Lift Enabled");
	}
	
	public void liftRobot(double liftSpeed){
		liftTalon.set(liftSpeed);
	}
	
	public void stopLift(double stopSpeed){
		liftTalon.set(stopSpeed);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new stopLiftBot());
    }
}
