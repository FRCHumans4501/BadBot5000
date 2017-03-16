package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.OI;
import org.usfirst.frc.team4501.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmyAmer extends Command {

	OI oi;

	public ArmyAmer() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);\
		requires(Robot.arm);
		oi = Robot.oi;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double y = (Math.sin(.5 * oi.getShooterY()) / 1.7);
		/*
		 * while (Robot.arm.armHigh()) {
		 * System.out.println("Top Limit Switch Triggered"); if (y >= 0) {
		 * Robot.arm.armyAmer(0);
		 * System.out.println("Speed set to 0 because of high"); } }
		 * 
		 * while (Robot.arm.armLow()){
		 * System.out.println("Bottom Limit Switch Triggered"); if(y<=0){
		 * Robot.arm.armyAmer(0);
		 * System.out.println("Speed set to 0 because of low"); } }
		 */
		Robot.arm.armyAmer(-y);
		//System.out.println("ArmyAmer.execute; y = " + y);
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
