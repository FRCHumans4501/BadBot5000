
package org.usfirst.frc.team4501.robot;

import org.usfirst.frc.team4501.robot.commands.AutoPIDEnable;
import org.usfirst.frc.team4501.robot.commands.DriveArcade;
import org.usfirst.frc.team4501.robot.subsystems.Arm;
import org.usfirst.frc.team4501.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4501.robot.subsystems.Lift;
import org.usfirst.frc.team4501.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static final DriveTrain driveTrain =  new DriveTrain();
	public static final Arm arm = new Arm();
	public static final Shooter shooter =  new Shooter();
	public static final Lift lift = new Lift();
	public static OI oi;
	public static Robot instance;
	
    Command autonomousCommand;
    SendableChooser chooser;
    DriveArcade autoCommand;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
        System.out.println("ROBOT IS ON!");
    	instance = this;
		oi = new OI();
        chooser = new SendableChooser();
        chooser.addObject("My Auto", new AutoPIDEnable());
        SmartDashboard.putData("Auto mode", chooser);
        shooter.resetEncoder();
    }
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		driveTrain.disablePIDPeriodic();
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
        
        System.out.println("Robot.autonomusInit()");
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
        Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
    	shooter.resetEncoder();
        if (autonomousCommand != null) autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
    	shooter.readEncoder();
        Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
