package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.ArmyAmer;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	DoubleSolenoid armSolenoid;
	Talon armMotor;
	AnalogPotentiometer pot;
	DigitalInput bottomSwitch, topSwitch;
	Timer timer;
	Double y;

	public Arm() {
		armMotor = new Talon(RobotMap.ARM_MOTOR);
		armSolenoid = new DoubleSolenoid(RobotMap.ARMRELAY, RobotMap.ARMRELAYPT2);
		pot = new AnalogPotentiometer(RobotMap.POTENT, 360, 30);
		bottomSwitch = new DigitalInput(RobotMap.LIMITSWITCH);
		topSwitch = new DigitalInput(RobotMap.LIMITSWITCH2);
		System.out.println("ARM IS ON!");

	}

	public void initDefaultCommand() {
		setDefaultCommand(new ArmyAmer());
	}

	public void armOpen() {
		armSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void armClose() {
		armSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public boolean armUp() {
		return topSwitch.get();
	}
	
	public boolean armDown() {
		return bottomSwitch.get();
	}

	public void armyAmer(double speed) {
		if (speed > 0) {
			if (!armDown()) {
				armMotor.set(0);
			} else {
				armMotor.set(speed);
			}
		} else if (speed < 0) {
			if (!armUp()) {
				armMotor.set(0);
			} else {
				armMotor.set(speed);
			}
		} else {
			armMotor.set(0);
		}
	}

	public void getPotAngle() {
		y = pot.get();
	}

}
