package org.usfirst.frc.team4501.robot.commands.auto;

import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.commands.arm.ArmClose;
import org.usfirst.frc.team4501.robot.commands.arm.PositionArmForScore;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddleAutoCommand extends CommandGroup {

    public MiddleAutoCommand() {
    	requires(Robot.driveTrain);
    	
    	addSequential(new PositionArmForScore());
    	addSequential(new AutoPIDEnable());
    	addSequential(new DriveStraight4Time(1, 0.50));
    	addSequential(new ArmClose());
    	addSequential(new DriveStraight4Time(.2, 0));
    	addSequential(new DriveStraight4Time(1, -0.5));
    }
    
    private void centerPeg() {
    	
    	addSequential(new PositionArmForScore());
    	addSequential(new AutoPIDEnable());
    	addSequential(new DriveStraight4Time(1, 0.50));
    	addSequential(new ArmClose());
    	addSequential(new DriveStraight4Time(.2, 0));
    	addSequential(new DriveStraight4Time(1, -0.5));
    	
    }
}
