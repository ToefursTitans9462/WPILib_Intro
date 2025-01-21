package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.subsystems.Drivetrain;
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
  private final PWMVictorSPX rightMotor = new PWMVictorSPX(1);
  private final PWMVictorSPX leftMotor = new PWMVictorSPX(0);
  private final PWMVictorSPX backRightMotor = new PWMVictorSPX(2);
  private final PWMVictorSPX backLeftMotor = new PWMVictorSPX(3);

  // Human Input
  private final XboxController controller1 = new XboxController(0);
  private final SendableChooser<String> autoSelector = new SendableChooser<>();

  // Input shorthand

  // Subsystems
  private final Drivetrain m_drivetrain = new Drivetrain(leftMotor, rightMotor);

  // Robot State
  private String m_currentAutoProgram = "default";

  private RobotContainer() {

    // This is for the SmartDashboard. It allows for a list of options to be presented to the user when the program is running.
    // Add the autos to the chooser
    // autoSelector.setDefaultOption(Autos.frontTesting, Autos.frontTesting);
    // autoSelector.addOption(Autos.backTesting, Autos.backTesting);
    // autoSelector.addOption(Autos.controllerTesting, Autos.controllerTesting);
    autoSelector.addOption(Autos.doubleTesting, Autos.doubleTesting);
    SmartDashboard.putData("Auto choices", autoSelector);


    // Invert the the motors so they move in the correct direction when "positive" voltate is applied.
    leftMotor.setInverted(true);

    // Group the motors on each side
    leftMotor.addFollower(backLeftMotor);
    rightMotor.addFollower(backRightMotor);

    ConfigureKeybindings();

    // Implementing the command-based architecture.
    m_drivetrain.setDefaultCommand(new TeleopDriveCommand(m_drivetrain, ()->controller1.getLeftY(), ()->controller1.getRightX()));
  }

  void ConfigureKeybindings() {

  }
}