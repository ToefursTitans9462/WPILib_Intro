package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.RobotConstants.Drivetrain.*;

// This is a differential drivetrain.
public class Drivetrain extends SubsystemBase {

  private final PWMVictorSPX m_leftMotor, m_rightMotor;
  private final DifferentialDrive m_DifferentialDrive;

  // The default driving mode is curvature.
  public Drivetrain(PWMVictorSPX leftMotor, PWMVictorSPX rightMotor) {
    super("Drivetrain");
    m_leftMotor = leftMotor;
    m_rightMotor = rightMotor;

    m_DifferentialDrive = new DifferentialDrive(leftMotor, rightMotor);
  }

  // This is the main drive function.
  public void drive(double speed, double turn) {
    // TODO: Adjust for the Ronstant's max speed things. There is absolute speed and a multiplier. The one that results in the lowest speed should be used.
    m_DifferentialDrive.curvatureDrive(speed * MAX_MOTOR_VOLTAGE, turn * TURN_SENSITIVITY, true);
  }
}
