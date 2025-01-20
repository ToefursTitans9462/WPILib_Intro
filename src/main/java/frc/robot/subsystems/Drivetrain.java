package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

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
    m_DifferentialDrive.curvatureDrive(speed, turn, true);
  }
}
