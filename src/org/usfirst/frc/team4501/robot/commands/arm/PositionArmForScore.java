package org.usfirst.frc.team4501.robot.commands.arm;

import org.usfirst.frc.team4501.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PositionArmForScore extends CommandGroup {

    public PositionArmForScore() {
    	requires(Robot.arm);
    	addSequential(new PosisionArmTop());
    	addSequential(new MoveArmForTime(0.5, 0.4));
    }
}
