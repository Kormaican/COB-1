package org.usfirst.frc.team6945.robot;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import com.ctre.CANTalon.TalonControlMode;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
	/* talons for arcade drive */
	CANTalon leftMotor = new CANTalon(1); 		/* device IDs here (1 of 2) */
	CANTalon rightMotor = new CANTalon(2);
	
	
	RobotDrive _drive = new RobotDrive(rightMotor,leftMotor);
	
	Joystick _joy = new Joystick(0);
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    
    	
    	
    	/* the Talons on the left-side of my robot needs to drive reverse(red) to move robot forward.
    	 * Since _leftSlave just follows frontLeftMotor, no need to invert it anywhere. */
    	_drive.setInvertedMotor(MotorType.kRearLeft, true);
    	_drive.setInvertedMotor(MotorType.kFrontLeft, true);
    	
    	_drive.setSafetyEnabled(false);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    	double right = _joy.getRawAxis(1); 
    	double left = _joy.getRawAxis(2); 
    	_drive.arcadeDrive(right, left);
    }
}