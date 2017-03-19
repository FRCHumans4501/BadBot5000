package org.usfirst.frc.team4501.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static final int ARM_MOTOR = 2;
	public static final int SHOOTER_MOTOR = 3;
	public static final int INTAKE_MOTOR = 4;
	public static final int LIFT_MOTOR = 5;
	public static final int POTENT = 0;
	public static final int SOLENOIDHIGH = 2;
	public static final int SOLENOIDLOW = 3;
	public static final int ARMRELAY = 0;
	public static final int ARMRELAYPT2 = 1;
	public static final int LIMITSWITCH = 1;
	public static final int LIMITSWITCH2 = 0;
	
	//public static final int LEFT_CAN_MOTOR_MASTER = 10;
	//public static final int LEFT_CAN_MOTOR_SLAVE = 11;
	//public static final int RIGHT_CAN_MOTOR_MASTER = 14;
	//public static final int RIGHT_CAN_MOTOR_SLAVE = 15;
	public static final int LEFT_MOTOR = 0;
	public static final int RIGHT_MOTOR = 1;
	public static final int ENCODER = 2;
	public static final int ENCODER2 = 3;
}
