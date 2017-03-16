package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PosisionArmTop extends Command {

	boolean isDone;
	boolean armUp;

	public PosisionArmTop() {
		requires(Robot.arm);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		isDone = false;
		System.out.println("Position Arm Top" + " isDone: " + isDone + " armUp: " + armUp + "Arm up?" + Robot.arm.armUp());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.arm.armUp() && armUp == false) {
			Robot.arm.armyAmer(-.25);
		} else if (!Robot.arm.armUp()) {
			armUp = true;
			isDone = true;
		}
		System.out.println(Robot.arm.armUp());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isDone;
	}

	// Called once after isFinished returns true
	protected void end() {
		armUp = false;
		isDone = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
