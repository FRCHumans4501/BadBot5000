package org.usfirst.frc.team4501.robot.subsystems;

import org.usfirst.frc.team4501.robot.Robot;
import org.usfirst.frc.team4501.robot.RobotMap;
import org.usfirst.frc.team4501.robot.commands.auto.EnableShooterPID;
import org.usfirst.frc.team4501.robot.commands.shooter.Shoot;
import org.usfirst.frc.team4501.robot.commands.shooter.ShootStop;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	double kTargetEncoderRate = -75000;
	double kMinShooterEncoderRate = kTargetEncoderRate * 0.95;
	double kMaxShooterEncoderRate = kTargetEncoderRate * 1.00;
	double lastMotorOutput;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Talon shootTalon;
	Talon intakeTalon;
	Encoder shooterEncoder;
	ShooterMotor shooterMotor;
	double shooterEncoderRate;
	
	class ShooterMotor extends PIDSubsystem {
		public ShooterMotor(double p, double i, double d) {
			super("ShooterMotor", p, i, d);
			getPIDController().setContinuous(false);
			getPIDController().setOutputRange(-1, -0.5);
			setSetpoint(kTargetEncoderRate);
			LiveWindow.addActuator("ShooterMotor", "pid", getPIDController());
		}

		@Override
		public void enable() {
			// TODO Auto-generated method stub
			super.enable();
			resetEncoder();
		}

		@Override
		public void disable() {
			// TODO Auto-generated method stub
			super.disable();
			shootTalon.set(0);
		}

		@Override
		protected double returnPIDInput() {
			return readEncoder();
		}

		@Override
		protected void usePIDOutput(double output) {
			lastMotorOutput = -output;
			shootTalon.set(-output);
		}

		@Override
		protected void initDefaultCommand() {
			// TODO Auto-generated method stub

		}
	}

	////////////////////////////////////////////////
	public Shooter() {
		shooterEncoder = new Encoder(RobotMap.ENCODER, RobotMap.ENCODER2);
		shootTalon = new Talon(RobotMap.SHOOTER_MOTOR);
		intakeTalon = new Talon(RobotMap.INTAKE_MOTOR);
		System.out.println("Shooter Enable");
	}

	public void enable() {
		if (shooterMotor == null) {
			shooterMotor = new ShooterMotor(1, 0, 0);
		}
		shooterMotor.enable();
		intakeTalon.set(0);
	}

	public void disable() {
		shooterMotor.disable();
		intakeTalon.set(0);
	}

	public void shoot() {
		enable();
		if (shooterEncoderRate <= kMinShooterEncoderRate) {
			intakeTalon.set(-1);
		} else {
			intakeTalon.set(0);
		}
	}

	public void shootStop() {
		shootTalon.set(0);
		disable();
	}

	public void resetEncoder() {
		shooterEncoder.reset();
	}

	public double readEncoder() {
		shooterEncoderRate = shooterEncoder.getRate();
		SmartDashboard.putNumber("Encoder Rate", shooterEncoderRate);
		//System.out.println("Last Motor Output: " + lastMotorOutput + " EncoderRate: " + shooterEncoderRate);
		
		return shooterEncoderRate;
	}

	public void intake(double speed) {
		intakeTalon.set(speed);

	}

	public void intakeStop() {
		intakeTalon.set(0);
	}

	public void initDefaultCommand() {
		// setDefaultCommand(new EnableShooterPID());
	}

}
