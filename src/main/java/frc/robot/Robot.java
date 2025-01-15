// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {

  private String m_autoSelected;
  // This is for the SmartDashboard. It allows for a list of options to be presented to the user when the program is running.

  // Timer so the robot knows how long it has been working on something
  Timer timer = new Timer();

  // Add motors, input, and output things to the robot
  IOdevices io = new IOdevices();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    
     }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want run during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = io.autoSelector.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
    if (!timer.isRunning())
      timer.start();
    else
      timer.reset();
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    double speed = 0.75;
    switch (m_autoSelected) {
      case Autos.backTestingAuto:
        System.out.println("BR: " + io.backRightMotor.getVoltage());
        System.out.println("BL: " + io.backLeftMotor.getVoltage() + '\n');
        if (timer.get() < 5)
        {
          // Run the motors forwards
          // Using WPILib drivetrain classes: https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html

          // For now, I will roll my own
          // WPILib has some classes for working with PWM motor controllers. These work out of the box, but calibrating them is still recommended.
          io.backRightMotor.set(speed);
          io.backLeftMotor.set(speed);
        }
        io.backRightMotor.set(0);
        io.backLeftMotor.set(0);

        break;
      case Autos.frontTestingAuto:
        System.out.println("FR: " + io.frontRightMotor.getVoltage());
        System.out.println("FL: " + io.frontLeftMotor.getVoltage() + '\n');
        if (timer.get() < 5) {
          io.frontRightMotor.set(speed);
          io.frontLeftMotor.set(speed);
        }
        io.frontRightMotor.set(0);
        io.frontLeftMotor.set(0);
        break;
      case Autos.doubleTestingAuto:
        System.out.println("FR: " + io.frontRightMotor.getVoltage());
        System.out.println("FL: " + io.frontLeftMotor.getVoltage());
        System.out.println("BR: " + io.backRightMotor.getVoltage());
        System.out.println("BL: " + io.backLeftMotor.getVoltage() + '\n');
        if (timer.get() < 5) {
          io.frontLeftMotor.set(speed); // Should be inverted relative to FR
          io.frontRightMotor.set(speed);
          io.backLeftMotor.set(speed); // Should be inverted relative to BR. 
          io.backRightMotor.set(speed);
        }
        break;
      case Autos.doNothingAuto:
        System.out.println("Doing Nothing Auto");
      default:
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    System.out.println("TeleopInit");
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
