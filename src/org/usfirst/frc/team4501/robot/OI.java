package org.usfirst.frc.team4501.robot;

import org.usfirst.frc.team4501.robot.XboxController.Trigger;
import org.usfirst.frc.team4501.robot.commands.ArmClose;
import org.usfirst.frc.team4501.robot.commands.PositionArmForScore;
import org.usfirst.frc.team4501.robot.commands.ArmOpen;
import org.usfirst.frc.team4501.robot.commands.Intake;
import org.usfirst.frc.team4501.robot.commands.IntakeStop;
import org.usfirst.frc.team4501.robot.commands.LiftRobot;
import org.usfirst.frc.team4501.robot.commands.PosisionArmTop;
import org.usfirst.frc.team4501.robot.commands.ShiftGearsHigh;
import org.usfirst.frc.team4501.robot.commands.ShiftGearsLow;
import org.usfirst.frc.team4501.robot.commands.Shoot;
import org.usfirst.frc.team4501.robot.commands.stopLiftBot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public static final int TRIGGER = 1, BUTTON_2 = 2, BUTTON_3 = 3, BUTTON_4 = 4, BUTTON_5 = 5, BUTTON_6 = 6,
			BUTTON_7 = 7, BUTTON_8 = 8, BUTTON_9 = 9, BUTTON_10 = 10, BUTTON_11 = 11;

	XboxController controller = new XboxController(0);
	Joystick stick = new Joystick(1);

	Button shiftHigh = new JoystickButton(controller, controller.BUTTON_A);
	Button shiftLow = new JoystickButton(controller, controller.BUTTON_B);
	Button invertDrive = new JoystickButton(controller, controller.BUMPER_L);
	Button armOpen = new JoystickButton(stick, BUTTON_4);
	Button armClose = new JoystickButton(stick, BUTTON_5);
	Button intake = new JoystickButton(stick, TRIGGER);
	Button shoot = new JoystickButton(stick, BUTTON_2);
	Button liftBot = new JoystickButton(stick, BUTTON_3);
	Button armSetup = new JoystickButton(stick, BUTTON_6);
	Button armUp = new JoystickButton(controller, controller.BUTTON_Y);

	public OI() {
		armSetup.whenPressed(new PositionArmForScore());
		armUp.whenPressed(new PosisionArmTop());

		shiftHigh.whenPressed(new ShiftGearsHigh());
		shiftLow.whenPressed(new ShiftGearsLow());
		armOpen.whenPressed(new ArmOpen());
		armClose.whenPressed(new ArmClose());
		intake.whileHeld(new Intake());
		intake.whenReleased(new IntakeStop());
		shoot.whileHeld(new Shoot());
		shoot.whenReleased(new IntakeStop());
		liftBot.whileHeld(new LiftRobot());
		liftBot.whenReleased(new stopLiftBot());
	}

	public double getLeftXboxX() {
		return controller.getRawAxis(0);
	}

	public double getLeftXboxY() {
		return controller.getRawAxis(1);
	}

	public double getRightXboxX() {
		return controller.getRawAxis(4);
	}

	public double getRightXboxY() {
		return controller.getRawAxis(5);
	}

	public double getShooterX() {
		return stick.getX();
	}

	public double getShooterY() {
		return stick.getY();
	}

	public double getShooterThrottle() {
		return stick.getZ();
	}

	public double getRightTrigger() {
		return controller.getRawTrigger(Trigger.RIGHT);
	}

	public double getLeftTrigger() {
		return controller.getRawTrigger(Trigger.LEFT);
	}

	public double getTrottle() {
		return controller.getZ();
	}

	public double getTriggers() {
		return controller.getRawAxis(XboxController.TRIGGER_L) - controller.getRawAxis(XboxController.TRIGGER_R);
	}

}
