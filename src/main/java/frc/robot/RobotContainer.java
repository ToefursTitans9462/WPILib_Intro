package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.Drivetrain;
import frc.robot.RobotConstants.BuildMode;
import frc.robot.commands.TeleopDriveCommand;

public final class RobotContainer {

  /** The Singleton Instance. */
  private static RobotContainer m_instance;

  /**
   * Returns the Scheduler instance. If no instance exists, will be created.
   *
   * @return the instance
   */
  public static synchronized RobotContainer getInstance() {
    if (m_instance == null) {
      m_instance = new RobotContainer();
    }
    return m_instance;
  }
  

  // Drive motors
  private final PWMVictorSPX m_rightMotor = new PWMVictorSPX(1);
  private final PWMVictorSPX m_leftMotor = new PWMVictorSPX(0);
  private final PWMVictorSPX m_backRightMotor = new PWMVictorSPX(2);
  private final PWMVictorSPX m_backLeftMotor = new PWMVictorSPX(3);

  // Human Input
  private final XboxController m_controller1 = new XboxController(0);
  private final SendableChooser<String> autoSelector = new SendableChooser<>();

  // Input shorthand

  // Subsystems
  private final Drivetrain m_drivetrain = new Drivetrain(m_leftMotor, m_rightMotor);

  // Robot State
  private String m_currentAutoProgram = "default";
  private BuildMode m_currentBuildMode = BuildMode.TESTING;

  private RobotContainer() {

    ConfigureMotors();
    ConfigureKeybindings();

    // Creating default commands for the subsystems.
    m_drivetrain.setDefaultCommand(new TeleopDriveCommand(m_drivetrain, ()->m_controller1.getLeftY(), ()->m_controller1.getRightX()));
  }



  private void ConfigureKeybindings() {

  }

  private void ConfigureMotors() {
    // Invert the the motors so they move in the correct direction when "positive" voltage is applied.
    m_leftMotor.setInverted(true);

    // Group the motors on each side
    m_leftMotor.addFollower(m_backLeftMotor);
    m_rightMotor.addFollower(m_backRightMotor);
  }
}