// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// For the PWM motor controllers
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  private static final String frontTestingAuto = "Front Motors Testing";
  private static final String backTestingAuto = "Back Motors Testing";
  private static final String doubleTestingAuto = "Double Motors Testing";
  private static final String doNothingAuto = "Empty Auto";

  private String m_autoSelected;
  // This is for the SmartDashboard. It allows for a list of options to be presented to the user when the program is running.
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  // Timer so the robot knows how long it has been working on something
  Timer timer = new Timer();

  // Add the motors to the robot
  PWMVictorSPX frontRightMotor = new PWMVictorSPX(1);
  PWMVictorSPX frontLeftMotor = new PWMVictorSPX(0);
  PWMVictorSPX backRightMotor = new PWMVictorSPX(2);
  PWMVictorSPX backLeftMotor = new PWMVictorSPX(3);


  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  public Robot() {
    m_chooser.setDefaultOption(frontTestingAuto, frontTestingAuto);
    m_chooser.addOption(backTestingAuto, backTestingAuto);
    m_chooser.addOption(doNothingAuto, doNothingAuto);
    m_chooser.addOption(doubleTestingAuto, doubleTestingAuto);
    SmartDashboard.putData("Auto choices", m_chooser);

    // Invert the the motors so they move in the correct direction when "positive" voltate is applied.
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);
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
    m_autoSelected = m_chooser.getSelected();
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
      case backTestingAuto:
        System.out.println("BR: " + backRightMotor.getVoltage());
        System.out.println("BL: " + backLeftMotor.getVoltage() + '\n');
        if (timer.get() < 5)
        {
          // Run the motors forwards
          // Using WPILib drivetrain classes: https://docs.wpilib.org/en/stable/docs/software/hardware-apis/motors/wpi-drive-classes.html

          // For now, I will roll my own
          // WPILib has some classes for working with PWM motor controllers. These work out of the box, but calibrating them is still recommended.
          backRightMotor.set(speed);
          backLeftMotor.set(speed);
        }
        backRightMotor.set(0);
        backLeftMotor.set(0);

        break;
      case frontTestingAuto:
        System.out.println("FR: " + frontRightMotor.getVoltage());
        System.out.println("FL: " + frontLeftMotor.getVoltage() + '\n');
        if (timer.get() < 5) {
          frontRightMotor.set(speed);
          frontLeftMotor.set(speed);
        }
        frontRightMotor.set(0);
        frontLeftMotor.set(0);
        break;
      case doubleTestingAuto:
        System.out.println("FR: " + frontRightMotor.getVoltage());
        System.out.println("FL: " + frontLeftMotor.getVoltage());
        System.out.println("BR: " + backRightMotor.getVoltage());
        System.out.println("BL: " + backLeftMotor.getVoltage() + '\n');
        if (timer.get() < 5) {
          frontLeftMotor.set(speed); // Should be inverted relative to FR
          frontRightMotor.set(speed);
          backLeftMotor.set(speed); // Should be inverted relative to BR. 
          backRightMotor.set(speed);
        }
        break;
      case doNothingAuto:
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
