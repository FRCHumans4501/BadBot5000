package org.usfirst.frc.team4501.robot.commands;

import org.usfirst.frc.team4501.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ArmGearNameThingie extends CommandGroup {

    public ArmGearNameThingie() {
    	requires(Robot.arm);
    	addSequential(new PosisionArmTop());
    	addSequential(new MoveArmForTime(0.5, 0.20));
    }
}
